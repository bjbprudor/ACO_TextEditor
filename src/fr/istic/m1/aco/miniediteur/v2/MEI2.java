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
			System.out.println("Replay " + bf.getZoneText().toString());
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
			System.out.println("Commande Enregistrée : Inserer");
		}
		super.Inserer(txt);
	}
	
	@Override
	public void Supprimer() 
	{
		if(recording)
		{
			Command c = new Supprimer(this);
			Memento m = new Memento(c);
			ca.addMemento(m);
			System.out.println("Commande Enregistrée : Supprimé");
		}
		super.Supprimer();
	}
	
	@Override
	public void Copier() 
	{
		if(recording)
		{
			Command c = new Copier(this);
			Memento m = new Memento(c);
			ca.addMemento(m);
			System.out.println("Commande Enregistrée : Copier");
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
			System.out.println("Commande Enregistrée : Couper");
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
			System.out.println("Commande Enregistrée : Coller");
		}
		super.Coller();
	}
	
	
	
}
