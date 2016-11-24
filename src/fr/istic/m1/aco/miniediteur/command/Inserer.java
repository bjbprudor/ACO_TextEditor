package fr.istic.m1.aco.miniediteur.command;

import fr.istic.m1.aco.miniediteur.IHM;
import fr.istic.m1.aco.miniediteur.MoteurEdition;

public class Inserer implements Command 
{

	MoteurEdition me;
	IHM ihm;
	
	public Inserer(MoteurEdition mei, IHM ihmi)
	{
		me = mei;
		ihm = ihmi;
	}
	
	@Override
	public void Execute() 
	{
		me.Inserer(IHM.ins);
	}

}
