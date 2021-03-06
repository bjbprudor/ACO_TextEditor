package fr.istic.m1.aco.miniediteur.v2;

import java.util.ArrayList;

class Caretaker 
{
	 
	private ArrayList<Memento> savedStates = new ArrayList<Memento>();
	
	public void addMemento(Memento m) 
	{ 
		savedStates.add(m);
	}
	
	public ArrayList<Memento> getSavedStates()
	{
		return savedStates;		
	}
	
	public Memento getMemento(int index) 
	{ 
		return savedStates.get(index); 
	}
	   
}   