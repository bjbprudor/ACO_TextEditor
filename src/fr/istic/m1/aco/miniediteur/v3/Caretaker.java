package fr.istic.m1.aco.miniediteur.v3;

import java.util.ArrayList;
import java.util.Stack;

public class Caretaker {
	
	// Where all mementos are saved
	
		ArrayList<MementoConcret> savedmomento = new ArrayList<MementoConcret>();
        Stack stundo = new Stack();
        Stack stredo = new Stack();
		// Adds memento to the ArrayList
		
		public void addMemento(MementoConcret m) { 
		//	savedmomento.add(m); 
			stundo.push(m);
			stredo.pop();
			}
	   
		// Gets the memento requested from the ArrayList
		
		public MementoConcret getMemento(int index) { 
			return savedmomento.get(index);
			//Memento m= stundo.get(index)
			}

}
