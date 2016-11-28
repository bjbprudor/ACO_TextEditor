package fr.istic.m1.aco.miniediteur.v3;

import fr.istic.m1.aco.miniediteur.states.Buffer;
import fr.istic.m1.aco.miniediteur.states.PressePapier;

public class MementoConcret implements Memento {

	String Text;
	Buffer buff;
	PressePapier presspap;

	public String getText() {
		return Text;
	}

	public void setText(String txt) {
		Text = txt;
	}
	public void setBuffer(Buffer b)
	{
		buff=b;
	}
	public void setPressPapier(PressePapier pp)
	{
		presspap=pp;
	}

	public MementoConcret(Buffer bb,PressePapier pp) {
		//Text = text;
		this.buff=bb;
		this.presspap=pp;
	}
  
	public MementoConcret() {
		super();
	}

	public Buffer getBuff() {
		return buff;
	}
	
	public PressePapier getPresspap() {
		return presspap;
	}

	
	
	
	
}
