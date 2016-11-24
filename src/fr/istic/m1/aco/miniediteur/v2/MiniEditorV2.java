package fr.istic.m1.aco.miniediteur.v2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.FlowLayout;

public class MiniEditorV2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiniEditorV2 frame = new MiniEditorV2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MiniEditorV2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextArea textArea = new JTextArea(10,10);
		contentPane.add(textArea, BorderLayout.CENTER);
		
		JPanel menu = new JPanel();
		contentPane.add(menu, BorderLayout.NORTH);
		
		JButton btnCopy = new JButton("Copier");
		menu.add(btnCopy);
		
		JButton btnCut = new JButton("Couper");
		menu.add(btnCut);
		
		JButton btnPaste = new JButton("Coller");
		menu.add(btnPaste);
		
		JPanel down = new JPanel();
		FlowLayout flowLayout = (FlowLayout) down.getLayout();
		contentPane.add(down, BorderLayout.SOUTH);
		
		JTextArea buffer = new JTextArea(10,40);
		down.add(buffer);
		buffer.setEditable(false);
	}

}
