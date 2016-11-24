package fr.istic.m1.aco.miniediteur.v2;

import fr.istic.m1.aco.miniediteur.command.Command;

class Memento 
{
	
	private Command state;

	public Memento(Command stateToSave) 
	{ 
		state = stateToSave;
	}
	
	public Command getSavedState() 
	{ 
		return state;
	}
	   
}
