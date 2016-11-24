package fr.istic.m1.aco.miniediteur.states;

public class Buffer 
{
	
	StringBuffer zoneText;

	public StringBuffer getZoneText() 
	{
		return zoneText;
	}

	public void setZoneText(StringBuffer zoneText) 
	{
		this.zoneText = zoneText;
	}

	public Buffer(StringBuffer zoneText) 
	{		
		this.zoneText = zoneText;
	}	
	
}
