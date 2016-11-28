package fr.istic.m1.aco.miniediteur.v2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class MiniEditorV2 extends JFrame {

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
		setBounds(100, 100, 494, 460);
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
		toolBar.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(toolBar, BorderLayout.WEST);
		
		JButton btnSave = new JButton("Save");
		toolBar.add(btnSave);
		
		JButton btnStop = new JButton("Stop");
		toolBar.add(btnStop);
		
		JButton btnPaly = new JButton("Play");
		toolBar.add(btnPaly);
		
		JToolBar toolBar_1 = new JToolBar();
		contentPane.add(toolBar_1, BorderLayout.NORTH);
		
		JButton btnCut = new JButton("Couper");
		toolBar_1.add(btnCut);
		
		JButton button_1 = new JButton("Couper");
		toolBar_1.add(button_1);
		
		JButton button_2 = new JButton("Coller");
		toolBar_1.add(button_2);
	}

}
