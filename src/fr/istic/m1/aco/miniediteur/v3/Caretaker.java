package fr.istic.m1.aco.miniediteur.v3;

import java.util.ArrayList;

public class Caretaker {
	
	// Where all mementos are saved
	
		ArrayList<MementoConcret> savedmomento = new ArrayList<MementoConcret>();
        
		// Adds memento to the ArrayList
		
		public void addMemento(MementoConcret m) { savedmomento.add(m); }
	   
		// Gets the memento requested from the ArrayList
		
		public MementoConcret getMemento(int index) { return savedmomento.get(index); }

}
