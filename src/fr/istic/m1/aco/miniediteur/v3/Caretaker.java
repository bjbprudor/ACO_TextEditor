package fr.istic.m1.aco.miniediteur.v3;

import java.util.ArrayList;
import java.util.Stack;

public class Caretaker {
	
	// Where all mementos are saved
	
		ArrayList<MementoConcret> savedmomento = new ArrayList<MementoConcret>();
        Stack<MementoConcret> stredo = new Stack<MementoConcret>();
        Stack<MementoConcret> stundo = new Stack<MementoConcret>();
		// Adds memento to the ArrayList
		
		public void addMemento(MementoConcret m) 
		{ 
			savedmomento.add(m); 
			stredo.pop();
			stundo.push(m);
		}
	   
		// Gets the memento requested from the ArrayList
		
		public MementoConcret getMemento(int index) 
		{
			@SuppressWarnings("unused")
			Memento m = stundo.get(index);
			return savedmomento.get(index);
		}

}
