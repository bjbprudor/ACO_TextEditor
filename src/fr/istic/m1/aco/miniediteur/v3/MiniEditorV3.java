package fr.istic.m1.aco.miniediteur.v3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import fr.istic.m1.aco.miniediteur.MoteurEdition;
import fr.istic.m1.aco.miniediteur.v2.MiniEditorV2;
import javax.swing.JToolBar;
import java.awt.BorderLayout;

/**
 * 
 * @author 
 *
 */
public class MiniEditorV3  extends MiniEditorV2
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void SetMEI(MoteurEdition me) 
	{
		if(me instanceof MEI3)
		{
			super.SetMEI(me);
		}
	}
	
	public static void main(String[] args) 
	{	
       new MiniEditorV3();
	}
   
	
   Caretaker caretak = new Caretaker();
   Organisator organisator = new Organisator();
	
   int saveFiles = 0, currentText = 0;
   private JToolBar toolBar;
   
   JButton undoBut;
   JButton redoBut;
   
   public MiniEditorV3()
   {
	   
	   // Set basic information for the panel that will
	   // hold all the GUI elements
	   
	   this.setSize(588,557);
	   this.setTitle("Memento Design Pattern");
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	   toolBar = new JToolBar();
	   getContentPane().add(toolBar, BorderLayout.SOUTH);
	 
	   undoBut = new JButton("Undo");
	   toolBar.add(undoBut);
	   
	   redoBut = new JButton("Redo");
	   
	   toolBar.add(redoBut);
	   
	   
	   ButtonListener undoListener = new ButtonListener();
	   ButtonListener redoListener = new ButtonListener();
	     
	   
	   undoBut.addActionListener(undoListener);
	   redoBut.addActionListener(redoListener);
	   
	   
	   textArea.getDocument().addDocumentListener(new DocumentListener(){

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
		
			//warn();
			undoBut.setEnabled(true);
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			
			
		}
		@SuppressWarnings("unused")
		public void  warn()
		{
			String textInTextArea = textArea.getText();
			
			
			// Set the value for the current memento
				saveFiles++;
			    currentText++;
			
			
			MementoConcret mem = new MementoConcret(mei.bf,mei.pp);
			
			
		
			caretak.addMemento(mem);
			//System.out.println("Current Text " + currentText);
			System.out.println("Current Text " + currentText);
			
			undoBut.setEnabled(true);
		}
	   });
	   
	   
	   this.setVisible(true);
   }   
   
        class ButtonListener implements ActionListener{
            
        	
        	
        	
        	
			@Override
			public void actionPerformed(ActionEvent e) {
				
			//	String textInTextArea = Text.getText();
				
				// Set the value for the current memento
			//	String textInTextArea =textArea.getText();
				
				// Set the value for the current memento
					saveFiles++;
				currentText++;
				
			//	organisator.set(textInTextArea);
			
				//caretak.addMemento(organisator.createNewMemento());
			//	System.out.println("Current Text " + currentText);
				//System.out.println("Current Text " + currentText);
				
			//	undoBut.setEnabled(true);
				
				MementoConcret mem = new MementoConcret(mei.bf,mei.pp);
				
				
				
				caretak.addMemento(mem);
				//System.out.println("Current Text " + currentText);
				System.out.println("Current Text " + currentText);
				
				undoBut.setEnabled(true);
				
				
					if(e.getSource() == undoBut){
					//	currentText--;
						
						//if(currentText==0)
					//	{
					//		textArea.setText("");
							
					//	}
						
					//	System.out.println("Current Text after first undo  " + currentText);
						
						if(currentText>0){
							
							
							
							currentText--;
							System.out.println("Current Text " + currentText);
							
						
							String textBoxString = organisator.getMemento(caretak.getMemento(currentText));
							
							textArea.setText(textBoxString);
							
							// Make Redo clickable
							
							redoBut.setEnabled(true);
						
						} else {
							
							// Don't allow user to click Undo
							
							undoBut.setEnabled(false);
							
						}
					}
                      else
						
						if(e.getSource() == redoBut){
						//	System.out.println("redo button is clicked");
							//System.out.println("savefiles value1  " + saveFiles);
						if((saveFiles - 1) > currentText){
							System.out.println("savefiles value2  " + saveFiles);
							// Increment to the current article displayed
							
							currentText++;
							
							// Get the newer article saved and display it in JTextArea
						
							String textBoxString = organisator.getMemento(caretak.getMemento(currentText-1));
							
							textArea.setText(textBoxString);
							
							// Make undo clickable
							
							undoBut.setEnabled(true);
						
						} else {
							
							// Don't allow user to click Redo
							
							redoBut.setEnabled(false);
							
						}
				}
					
		
				
			}
        	
        }
	   
	   
	   
	   

	   
	   
	   
	   
	   
	   
       // }
   
}
