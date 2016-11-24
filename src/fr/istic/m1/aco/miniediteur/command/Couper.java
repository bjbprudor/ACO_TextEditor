package fr.istic.m1.aco.miniediteur.command;

import fr.istic.m1.aco.miniediteur.MoteurEdition;

public class Couper implements Command
{

	MoteurEdition me;
	
	public Couper(MoteurEdition mei)
	{
		me = mei;
	}
	
	@Override
	public void Execute() 
	{
		me.Couper();
	}

}
