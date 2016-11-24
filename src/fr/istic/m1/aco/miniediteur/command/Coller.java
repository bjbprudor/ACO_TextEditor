package fr.istic.m1.aco.miniediteur.command;

import fr.istic.m1.aco.miniediteur.MoteurEdition;

public class Coller implements Command 
{

	MoteurEdition me;
	
	public Coller(MoteurEdition mei)
	{
		me = mei;
	}
	
	@Override
	public void Execute() 
	{
		me.Coller();
	}

}
