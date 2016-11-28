package fr.istic.m1.aco.miniediteur.v3;

public class Organisator {
	
	String Text;
	
	
	public String getMemento(MementoConcret memento) {
		   
		Text = memento.getText(); 
	       
		System.out.println("From Originator: Previous Text Saved in Memento\n"+Text + "\n");
		
		return Text;
	   
}
	//Option
	
	public MementoConcret createNewMemento()
	{
		
		System.out.println("From Organisator saving to mement");
		return new MementoConcret();
	}

	public void set(String txt) {
		
		System.out.println("Form organisator:Current txt is: ");
		Text = txt;
	}
    
	
	
	
	
	
	
	
}