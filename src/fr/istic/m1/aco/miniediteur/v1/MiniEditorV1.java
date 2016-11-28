package fr.istic.m1.aco.miniediteur.v1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JToolBar;

public class MiniEditorV1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiniEditorV1 frame = new MiniEditorV1();
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
	public MiniEditorV1() {
		setTitle("Editor V1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextArea textArea = new JTextArea(10,10);
		contentPane.add(textArea, BorderLayout.CENTER);
		
		JPanel down = new JPanel();
		@SuppressWarnings("unused")
		FlowLayout flowLayout = (FlowLayout) down.getLayout();
		contentPane.add(down, BorderLayout.SOUTH);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton button = new JButton("Copier");
		toolBar.add(button);
		
		JButton button_1 = new JButton("Couper");
		toolBar.add(button_1);
		
		JButton button_2 = new JButton("Coller");
		toolBar.add(button_2);
	}

}
