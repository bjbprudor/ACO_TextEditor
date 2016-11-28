package fr.istic.m1.aco.miniediteur.v3;

public class MementoConcret implements Memento {

	String Text;

	public String getText() {
		return Text;
	}

	public void setText(String txt) {
		Text = txt;
	}

	public MementoConcret(String text) {
		Text = text;
	}
	
	
}
