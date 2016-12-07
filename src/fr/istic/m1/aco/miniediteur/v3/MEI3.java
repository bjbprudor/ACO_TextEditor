package fr.istic.m1.aco.miniediteur.v3;

import fr.istic.m1.aco.miniediteur.v2.MEI2;

public class MEI3 extends MEI2
{
	
	@Override
	public void Inserer(String txt) 
	{
		@SuppressWarnings("unused")
		MementoConcret mc = new MementoConcret(bf,pp);
		super.Inserer(txt);
	}
	
	@Override
	public void Copier() 
	{
		@SuppressWarnings("unused")
		MementoConcret mc = new MementoConcret(bf,pp);
		super.Copier();
	}
	
	@Override
	public void Couper() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		MementoConcret mc = new MementoConcret(bf,pp);
		super.Couper();
	}
	
	@Override
	public void Coller() {
		@SuppressWarnings("unused")
		MementoConcret mc = new MementoConcret(bf,pp);
		super.Coller();
	}
	
	@Override
	public void Supprimer() {
		@SuppressWarnings("unused")
		MementoConcret mc = new MementoConcret(bf,pp);
		super.Supprimer();
	}
	
}
