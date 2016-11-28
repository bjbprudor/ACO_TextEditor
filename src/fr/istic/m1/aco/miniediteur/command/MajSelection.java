package fr.istic.m1.aco.miniediteur.command;

import fr.istic.m1.aco.miniediteur.MoteurEdition;

public class MajSelection implements Command
{

	MoteurEdition me;
	private int deb, longe;
	
	public int getDeb() 
	{
		return deb;
	}

	public void setDeb(int deb) 
	{
		this.deb = deb;
	}

	public int getLonge() 
	{
		return longe;
	}

	public void setLonge(int longe) 
	{
		this.longe = longe;
	}

	public MajSelection(MoteurEdition mei)
	{
		me = mei;
	}
	
	@Override
	public void Execute() 
	{
		me.selectionner(deb,longe);
	}

}
