package fr.istic.m1.aco.miniediteur.v2;

import fr.istic.m1.aco.miniediteur.command.*;
import fr.istic.m1.aco.miniediteur.v1.MEI1;

/**
 * @author 16013094
 *
 */
public class MEI2 extends MEI1
{
	
	private boolean recording;
	Caretaker ca;
	Originator ori;
	
	public MEI2() 
	{
		recording = false;
		ca = new Caretaker();
		ori = new Originator();
	}
	
	public void startRecord()
	{
		recording = true;
	}
	
	public void stopRecord()
	{
		recording = false;
	}
	
	public void replayRecord()
	{
		for (Memento me : ca.getSavedStates()) 
		{
			ori.restoreFromMemento(me);
		}
	}
	
	@Override
	public void Inserer(String txt) 
	{
		if(recording)
		{
			Command c = new Inserer(this);
			((Inserer)c).setText(txt);
			Memento m = new Memento(c);
			ca.addMemento(m);
		}
		super.Inserer(txt);
	}
	
	@Override
	public void supprimer() 
	{
		if(recording)
		{
			Command c = new Supprimer(this);
			Memento m = new Memento(c);
			ca.addMemento(m);
		}
		super.supprimer();
	}
	
	@Override
	public void Copier() 
	{
		if(recording)
		{
			Command c = new Copier(this);
			Memento m = new Memento(c);
			ca.addMemento(m);
		}
		super.Copier();
	}
	
	@Override
	public void Couper() 
	{
		if(recording)
		{
			Command c = new Couper(this);
			Memento m = new Memento(c);
			ca.addMemento(m);
		}
		super.Couper();
	}
	
	@Override
	public void Coller() 
	{
		if(recording)
		{
			Command c = new Coller(this);
			Memento m = new Memento(c);
			ca.addMemento(m);
		}
		super.Coller();
	}
	
	
	
}
