package fr.istic.m1.aco.miniediteur.v2;

import fr.istic.m1.aco.miniediteur.command.Command;

public class Record implements Command
{
	
	public MEI2 me;
	
	public Record(MEI2 mei)
	{
		me = mei;
	}

	@Override
	public void Execute() 
	{
		me.startRecord();
	}	
	
}
