package fr.istic.m1.aco.miniediteur.v2;

import fr.istic.m1.aco.miniediteur.command.Command;

public class Stop implements Command
{

	public MEI2 me;
	
	public Stop(MEI2 mei)
	{
		me = mei;
	}

	@Override
	public void Execute()
	{
		me.stopRecord();
	}
	
}
