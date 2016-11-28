package fr.istic.m1.aco.miniediteur.command;

import fr.istic.m1.aco.miniediteur.MoteurEdition;

public class Inserer implements Command 
{

	private MoteurEdition me;
	private String text;
	
	public Inserer(MoteurEdition mei)
	{
		me = mei;
	}
	
	public String getText() 
	{
		return text;
	}

	public void setText(String text) 
	{
		this.text = text;
	}

	@Override
	public void Execute() 
	{
		me.Inserer(text);
	}

}
