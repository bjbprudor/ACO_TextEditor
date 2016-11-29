package fr.istic.m1.aco.miniediteur.v2;

import fr.istic.m1.aco.miniediteur.Configurator;
import fr.istic.m1.aco.miniediteur.v1.MiniEditorV1;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MiniEditorV2 extends MiniEditorV1
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MiniEditorV2() 
	{
		setTitle("Editor V2");
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		getContentPane().add(toolBar, BorderLayout.WEST);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Configurator.current = new Record((MEI2)Configurator.mei);		
				Configurator.current.Execute();
				System.out.println("Enregistrement en cours");
			}
		});
		toolBar.add(btnSave);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Configurator.current = new Stop((MEI2)Configurator.mei);		
				Configurator.current.Execute();
				System.out.println("Enregistrement terminer");
			}
		});
		toolBar.add(btnStop);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Configurator.current = new Replay((MEI2)Configurator.mei);		
				Configurator.current.Execute();
				System.out.println("Replay effectué");
				System.out.println("Buffer : " + Configurator.mei.bf.getZoneText().toString());
				textArea.setText(Configurator.mei.bf.getZoneText().toString());
			}
		});
		toolBar.add(btnPlay);
	}

}
