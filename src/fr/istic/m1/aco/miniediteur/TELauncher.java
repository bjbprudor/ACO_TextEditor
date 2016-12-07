package fr.istic.m1.aco.miniediteur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.istic.m1.aco.miniediteur.v1.MEI1;
import fr.istic.m1.aco.miniediteur.v1.MiniEditorV1;
import fr.istic.m1.aco.miniediteur.v2.MEI2;
import fr.istic.m1.aco.miniediteur.v2.MiniEditorV2;
import fr.istic.m1.aco.miniediteur.v3.MEI3;
import fr.istic.m1.aco.miniediteur.v3.MiniEditorV3;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Mu-B
 *
 */
public class TELauncher extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					TELauncher frame = new TELauncher();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TELauncher() 
	{
		setTitle("Text Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 102);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnV1 = new JButton("Version 1");
		btnV1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				LaunchV1();
			}
		});
		contentPane.add(btnV1, BorderLayout.WEST);
		
		JButton btnV2 = new JButton("Version 2");
		btnV2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{				
				LaunchV2();
			}
		});
		contentPane.add(btnV2, BorderLayout.CENTER);
		
		JButton btnV3 = new JButton("Version 3");
		btnV3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				LaunchV3();
			}
		});
		contentPane.add(btnV3, BorderLayout.EAST);
	}
	
	public static void LaunchV1()
	{
		MiniEditorV1 frame = new MiniEditorV1();
		frame.SetMEI(new MEI1());
		frame.setVisible(true);		
	}
	
	public static void LaunchV2()
	{
		MiniEditorV2 frame = new MiniEditorV2();
		frame.SetMEI(new MEI2());
		frame.setVisible(true);	
	}
	
	public static void LaunchV3()
	{
		MiniEditorV3 frame = new MiniEditorV3();
		frame.SetMEI(new MEI3());
		frame.setVisible(true);	
	}

}
