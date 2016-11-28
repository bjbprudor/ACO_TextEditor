package fr.istic.m1.aco.miniediteur.states;

public class Selection 
{
	
	private int Debut;
	private int Longueur;
	private boolean Selected;
 
	public Selection(int debut, int lon) 
	{
		Debut = debut;
		Longueur = lon;
	}
  
	public int getDebut() 
	{
		return Debut;
	}
  
	public void setDebut(int debut) 
	{
		Debut = debut;
	}
  
	public int getLongueur() 
	{
		return Longueur;
	}
  
	public void setLongueur(int fin) 
	{
		Longueur = fin;
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
