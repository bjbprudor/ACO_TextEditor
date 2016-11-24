package fr.istic.m1.aco.miniediteur.command;

import fr.istic.m1.aco.miniediteur.MoteurEdition;

public class Copier implements Command
{
	
	MoteurEdition me;
	
	public Copier(MoteurEdition mei)
	{
		me = mei;
	}
	
	@Override
	public void Execute()
	{
		me.Copier();
	}

}
