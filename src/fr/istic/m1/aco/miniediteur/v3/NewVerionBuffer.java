package fr.istic.m1.aco.miniediteur.v3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class NewVerionBuffer  extends JFrame{

	public static void main(String[] args) {
	
       new NewVerionBuffer();
	}
	
	
   private JButton undoBut, redoBut;
	   
	   // JTextArea(rows, columns)
	   
   private JTextArea Text = new JTextArea(40,60);
   
	
   Caretaker caretak = new Caretaker();
   Organisator organisator = new Organisator();
	
   int saveFiles = 0, currentText = 0;
	
   public NewVerionBuffer(){
	   
	   // Set basic information for the panel that will
	   // hold all the GUI elements
	   
	   this.setSize(588,557);
	   this.setTitle("Memento Design Pattern");
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	   JPanel panel1 = new JPanel();
	   
	   // Add label to the panel
	   
	   panel1.add(new JLabel("Text"));
	   
	   // Add JTextArea to the panel
	   
	   panel1.add(Text);
	   
	   
	   ButtonListener undoListener = new ButtonListener();
	   ButtonListener redoListener = new ButtonListener();
	 
	   
	   
	   undoBut = new JButton("Undo");
	   undoBut.addActionListener(undoListener);
	   
	   redoBut = new JButton("Redo");
	   redoBut.addActionListener(redoListener);
	  	   
	   
	   panel1.add(undoBut);
	   panel1.add(redoBut);
	  
	   
	   getContentPane().add(panel1);
	   
	   Text.getDocument().addDocumentListener(new DocumentListener(){

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
		
			warn();
			undoBut.setEnabled(true);
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			
			
		}
		public void  warn()
		{
			String textInTextArea = Text.getText();
			
			// Set the value for the current memento
				saveFiles++;
			currentText++;
			
			organisator.set(textInTextArea);
		
			caretak.addMemento(organisator.createNewMemento());
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
				
				String textInTextArea = Text.getText();
				
				// Set the value for the current memento

				
				
				
					if(e.getSource() == undoBut){
						currentText--;
						
						if(currentText==0)
						{
							Text.setText("");
							
						}
						
						System.out.println("Current Text after first undo  " + currentText);
						
						if(currentText>0){
							
							
							
							currentText--;
							System.out.println("Current Text " + currentText);
							
						
							String textBoxString = organisator.getMemento(caretak.getMemento(currentText));
							
							Text.setText(textBoxString);
							
							// Make Redo clickable
							
							redoBut.setEnabled(true);
						
						} else {
							
							// Don't allow user to click Undo
							
							undoBut.setEnabled(false);
							
						}
					}
                      else
						
						if(e.getSource() == redoBut){
							System.out.println("redo button is clicked");
							System.out.println("savefiles value1  " + saveFiles);
						if((saveFiles - 1) > currentText){
							System.out.println("savefiles value2  " + saveFiles);
							// Increment to the current article displayed
							
							currentText++;
							
							// Get the newer article saved and display it in JTextArea
						
							String textBoxString = organisator.getMemento(caretak.getMemento(currentText-1));
							
							Text.setText(textBoxString);
							
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
