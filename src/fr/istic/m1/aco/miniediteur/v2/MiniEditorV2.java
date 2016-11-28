package fr.istic.m1.aco.miniediteur.v2;

import fr.istic.m1.aco.miniediteur.v1.MiniEditorV1;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MiniEditorV2 extends MiniEditorV1
{
	public MiniEditorV2() 
	{
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		getContentPane().add(toolBar, BorderLayout.WEST);
		
		JButton btnSave = new JButton("Save");
		toolBar.add(btnSave);
		
		JButton btnStop = new JButton("Stop");
		toolBar.add(btnStop);
		
		JButton btnPlay = new JButton("Play");
		toolBar.add(btnPlay);
	}

}
