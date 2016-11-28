package fr.istic.m1.aco.miniediteur.v1;

import java.awt.BorderLayout;
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
	
	public void runFrm()
	{
		
	}
	
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
			}
		});
		toolBar.add(btnPaste);
		
		textArea.getDocument().addDocumentListener(new DocumentListener() 
		{
			
			@SuppressWarnings("static-access")
			@Override
			public void insertUpdate(DocumentEvent e) 
			{
				Configurator.current = new Inserer(Configurator.mei);
				((Inserer)Configurator.current).setText(e.toString());
				Configurator.current.Execute();
				System.out.println("Insertion Executée : " + Configurator.mei.bf.getZoneText().toString());
			}
			
			@SuppressWarnings("static-access")
			@Override
			public void removeUpdate(DocumentEvent e) 
			{
				Configurator.current = new Supprimer(Configurator.mei);		
				Configurator.current.Execute();
				System.out.println("Suppression Effectué : " + Configurator.mei.bf.getZoneText().toString());
			}

			@Override
			public void changedUpdate(DocumentEvent e) { }
			
		});
		
		textArea.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) { }
			
			@Override
			public void mousePressed(MouseEvent e) { }
			
			@Override
			public void mouseExited(MouseEvent e) {	}
			
			@Override
			public void mouseEntered(MouseEvent e) { }
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				int i,j;
				i = textArea.getSelectionStart();
				j= textArea.getSelectedText().length();
				Configurator.mei.selectionner(i, j);
				System.out.println("Selection effectuée : deb " + i + "long : " + j );
			}
		});
				
	}

}
