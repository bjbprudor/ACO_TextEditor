package fr.istic.m1.aco.miniediteur.states;

public class Selection 
{
	
	private int Debut;
	private int Fin;
	private boolean Selected;
 
	public Selection(int debut, int fin) 
	{
		Debut = debut;
		Fin = fin;
	}
  
	public int getDebut() 
	{
		return Debut;
	}
  
	public void setDebut(int debut) 
	{
		Debut = debut;
	}
  
	public int getFin() 
	{
		return Fin;
	}
  
	public void setFin(int fin) 
	{
		Fin = fin;
	}

	public boolean isSelected() 
	{
		return Selected;
	}

	public void setSelected(boolean selected) 
	{
		Selected = selected;
	}
    
}
