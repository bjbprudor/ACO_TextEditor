package fr.istic.m1.aco.miniediteur.v2;

import fr.istic.m1.aco.miniediteur.command.Command;

public class Replay implements Command
{

	MEI2 me;
	
	public Replay(MEI2 mei)
	{
		me = mei;
	}

	@Override
	public void Execute() 
	{
		me.replayRecord();
	}
		
}
