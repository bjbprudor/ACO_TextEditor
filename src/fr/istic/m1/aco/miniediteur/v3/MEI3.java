package fr.istic.m1.aco.miniediteur.v3;

import fr.istic.m1.aco.miniediteur.v2.MEI2;

public class MEI3 extends MEI2
{
	@Override
	public void Inserer(String txt) 
	{
		MementoConcret mc = new MementoConcret(this.bf,this.pp);
		super.Inserer(txt);
	}
	
	@Override
	public void Copier() 
	{
		MementoConcret mc = new MementoConcret(this.bf,this.pp);
		super.Copier();
	}
	
	@Override
	public void Couper() {
		// TODO Auto-generated method stub
		MementoConcret mc = new MementoConcret(this.bf,this.pp);
		super.Couper();
	}
	
	@Override
	public void Coller() {
		MementoConcret mc = new MementoConcret(this.bf,this.pp);
		super.Coller();
	}
	
	@Override
	public void Supprimer() {
		MementoConcret mc = new MementoConcret(this.bf,this.pp);
		super.Supprimer();
	}
	
}
