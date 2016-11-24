package fr.istic.m1.aco.miniediteur.command;

import fr.istic.m1.aco.miniediteur.IHM;
import fr.istic.m1.aco.miniediteur.MoteurEdition;

public class Selectionner implements Command
{

	MoteurEdition me;
	
	public Selectionner(MoteurEdition mei)
	{
		me = mei;
	}
	
	@Override
	public void Execute() 
	{
		me.selectionner(IHM.posA, IHM.posB);
	}

}
