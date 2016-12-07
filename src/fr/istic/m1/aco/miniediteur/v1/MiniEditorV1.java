package fr.istic.m1.aco.miniediteur.v1;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import fr.istic.m1.aco.miniediteur.IHM;
import fr.istic.m1.aco.miniediteur.MoteurEdition;
import fr.istic.m1.aco.miniediteur.command.Coller;
import fr.istic.m1.aco.miniediteur.command.Command;
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

public class MiniEditorV1 extends JFrame implements IHM
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	protected JPanel contentPane;
	protected JToolBar toolBar;
	protected JTextArea textArea;
	
	protected static MoteurEdition mei;
	protected static Command current;
	
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
				current = new Copier(mei);		
				current.Execute();
				System.out.println("Copier executé");
				System.out.println("presse papier : " + mei.pp.getContenuPP());
			}
		});
		toolBar.add(btnCopy);
		
		JButton btnCut = new JButton("Couper");
		btnCut.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) 
			{
				current = new Couper(mei);		
				current.Execute();
				System.out.println("Couper executé");
				System.out.println("presse papier : " + mei.pp.getContenuPP());
				System.out.println("buffer : " + mei.pp.getContenuPP());
				textArea.setText(mei.bf.getZoneText().toString());
			}
		});
		toolBar.add(btnCut);
		
		JButton btnPaste = new JButton("Coller");
		btnPaste.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) 
			{
				current = new Coller(mei);		
				current.Execute();
				System.out.println("Coller executé");
				System.out.println("buffer : " + mei.bf.getZoneText().toString());
				textArea.setText(mei.bf.getZoneText().toString());
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
					current = new Supprimer(mei);		
					current.Execute();
					System.out.println("Suppression Effectué : " + mei.bf.getZoneText().toString());
				}
				else
				{
					if(!e.isActionKey())
					{
						int[] ignoring = new int[] {KeyEvent.VK_ALT,KeyEvent.VK_CAPS_LOCK,KeyEvent.VK_CONTROL,KeyEvent.VK_SHIFT,KeyEvent.VK_NUM_LOCK,KeyEvent.VK_ESCAPE};
						boolean ignore = false;
						int ind = 0;
						while(ind < ignoring.length & !ignore)
						{
							ignore = (ignoring[ind] == e.getKeyCode());
							ind++;
						}
						if(!ignore)
						{
							current = new Inserer(mei);
							String txt = String.valueOf(e.getKeyChar());
							((Inserer)current).setText(txt);
							current.Execute();
							System.out.println("Insertion Executée : " + mei.bf.getZoneText().toString());
						}
					}
					else
					{
						int[] moving = new int[] {KeyEvent.VK_LEFT,KeyEvent.VK_RIGHT,KeyEvent.VK_DOWN,KeyEvent.VK_UP};
						boolean ignore = true;
						int ind = 0;
						while(ind < moving.length & ignore)
						{
							ignore = (moving[ind] == e.getKeyCode());
							ind++;
						}
						if(!ignore)
						{
							int i,j;
							i = textArea.getSelectionStart();
							j = textArea.getSelectionEnd();
							mei.selectionner(i, j);
							System.out.println("Deplacement effectué : deb " + mei.se.getDebut() + " fin " + mei.se.getLongueur());
						}
					}
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
				mei.selectionner(i, j);
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
	
	

	@Override
	public void SetMEI(MoteurEdition me) { mei = me; }

	@Override
	public MoteurEdition GetMEI() { return mei; }

	@Override
	public void SetCommand(Command c) { current = c; }

	@Override
	public Command GetCommand() { return current; }

}
