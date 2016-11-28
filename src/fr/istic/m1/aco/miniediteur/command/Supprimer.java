package fr.istic.m1.aco.miniediteur.command;

import fr.istic.m1.aco.miniediteur.MoteurEdition;

public class Supprimer implements Command
{

	MoteurEdition me;
	
	public Supprimer(MoteurEdition mei)
	{
		me = mei;
	}
	
	@Override
	public void Execute() 
	{
		me.Supprimer();
	}

}
