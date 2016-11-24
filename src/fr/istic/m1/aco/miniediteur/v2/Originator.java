package fr.istic.m1.aco.miniediteur.v2;

import fr.istic.m1.aco.miniediteur.command.Command;

class Originator 
{

	private Command state;
	/* lots of memory consumptive private data that is not necessary to define the 
	* state and should thus not be saved. Hence the small memento object. */
	public void set(Command state) 
	{ 
		
		System.out.println("Originator: Setting state to "+state);
	    this.state = state; 
	    
	}

	public Memento saveToMemento() 
	{ 
		
		System.out.println("Originator: Saving to Memento.");
	    return new Memento(state);
	    
	}
	
	public void restoreFromMemento(Memento m) 
	{
		
	    state = m.getSavedState(); 
	    System.out.println("Originator: State after restoring from Memento: "+state);
	    
	}
	   
}   