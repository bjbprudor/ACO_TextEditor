package fr.istic.m1.aco.miniediteur.v1;

import java.awt.BorderLayout;
import java.awt.RenderingHints.Key;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import fr.istic.m1.aco.miniediteur.Configurator;
import fr.istic.m1.aco.miniediteur.command.Coller;
import fr.istic.m1.aco.miniediteur.command.Copier;
import fr.istic.m1.aco.miniediteur.command.Couper;
import fr.istic.m1.aco.miniediteur.command.Inserer;
import fr.istic.m1.aco.miniediteur.command.Supprimer;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class MiniEditorV1 extends JFrame 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel contentPane;
	protected JToolBar toolBar;
	protected JTextArea textArea;
	
	/**
	 * Create the frame.
	 */
	public MiniEditorV1() 
	{
		
		setTitle("Editor V1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textArea = new JTextArea(10,10);
		contentPane.add(textArea, BorderLayout.CENTER);
		
		toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnCopy = new JButton("Copier");
		btnCopy.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) 
			{
				Configurator.current = new Copier(Configurator.mei);		
				Configurator.current.Execute();
				System.out.println("Copier executé");
				System.out.println("presse papier : " + Configurator.mei.pp.getContenuPP());
			}
		});
		toolBar.add(btnCopy);
		
		JButton btnCut = new JButton("Couper");
		btnCut.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) 
			{
				Configurator.current = new Couper(Configurator.mei);		
				Configurator.current.Execute();
				System.out.println("Couper executé");
				System.out.println("presse papier : " + Configurator.mei.pp.getContenuPP());
				System.out.println("buffer : " + Configurator.mei.pp.getContenuPP());
				textArea.setText(Configurator.mei.bf.getZoneText().toString());
			}
		});
		toolBar.add(btnCut);
		
		JButton btnPaste = new JButton("Coller");
		btnPaste.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) 
			{
				Configurator.current = new Coller(Configurator.mei);		
				Configurator.current.Execute();
				System.out.println("Coller executé");
				System.out.println("buffer : " + Configurator.mei.bf.getZoneText().toString());
				textArea.setText(Configurator.mei.bf.getZoneText().toString());
			}
		});
		toolBar.add(btnPaste);
		
		textArea.addKeyListener(new KeyListener() 
		{
			
			@Override
			public void keyTyped(KeyEvent e) { }
			
			@Override
			public void keyReleased(KeyEvent e) { }
			
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE | e.getKeyCode() == KeyEvent.VK_DELETE)
				{
					Configurator.current = new Supprimer(Configurator.mei);		
					Configurator.current.Execute();
					System.out.println("Suppression Effectué : " + Configurator.mei.bf.getZoneText().toString());
				}
				else
				{
					Configurator.current = new Inserer(Configurator.mei);
					String txt = String.valueOf(e.getKeyChar());
					((Inserer)Configurator.current).setText(txt);
					Configurator.current.Execute();
					System.out.println("Insertion Executée : " + Configurator.mei.bf.getZoneText().toString());
				}
			}
			
		});
		
		textArea.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) 
			{ 
				int i,j;
				i = textArea.getSelectionStart();
				try 
				{
					j= textArea.getSelectedText().length();
				}
				catch (Exception e2) 
				{
					j = 0;
				}
				Configurator.mei.selectionner(i, j);
				System.out.println("Selection effectuée : deb " + i + "long : " + j );
			}
			
			@Override
			public void mousePressed(MouseEvent e) { }
			
			@Override
			public void mouseExited(MouseEvent e) {	}
			
			@Override
			public void mouseEntered(MouseEvent e) { }
			
			@Override
			public void mouseClicked(MouseEvent e) { }
		});
				
	}

}
