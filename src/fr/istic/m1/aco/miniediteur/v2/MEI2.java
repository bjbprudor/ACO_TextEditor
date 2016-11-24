package fr.istic.m1.aco.miniediteur.v2;

import fr.istic.m1.aco.miniediteur.MoteurEdition;

/**
 * @author 16013094
 *
 */
public class MEI2 implements MoteurEdition
{
	
	public void Copier() 
	{
		if(se.getDebut() >= 0 && se.getFin() >= 0 && se.isSelected())
		{
			if(bf.getZoneText().length() >= se.getFin())
			{
				String val = bf.getZoneText().substring(se.getDebut(), se.getFin()+1); // on recupere la selection de texte
				pp.setContenuPP(val); // on enregistre le texte dans le presse papier
			}
		}
	}

	@Override
	public void Coller()
	{
		if (se.getDebut() >= 0 && se.getFin() >= 0) 
		{
			if(se.isSelected())
			{
				StringBuffer val = bf.getZoneText().delete(se.getDebut(), se.getFin());
				bf.setZoneText(val);
			}		
			StringBuffer val = bf.getZoneText().insert(se.getDebut(), se.getFin());
			bf.setZoneText(val);
		}
		
	}

	@Override
	public void Couper()
	{
		if(se.getDebut() >= 0 && se.getFin() >= 0 && se.isSelected())
		{
			if(bf.getZoneText().length() >= se.getFin())
			{
				String val = bf.getZoneText().substring(se.getDebut(), se.getFin()+1);
				pp.setContenuPP(val);
				StringBuffer val2 = bf.getZoneText().delete(se.getDebut(), se.getFin());
				bf.setZoneText(val2);
				se.setDebut(-1);
				se.setFin(-1);
			}
		}
	}

	@Override
	public void selectionner(int debut, int longueur)
	{
		if (debut >= 0 && longueur > 0) 
		{			
			if (bf.getZoneText().length() - debut >= longueur) //pour ne pas dépasser la chaine séléctionnée
			{
				se.setFin(debut + longueur-1);
			}
			else 
			{
				se.setFin(bf.getZoneText().length()-1 );
			}
			se.setDebut(debut);
			se.setSelected(true);
		}
		else 
		{
			se.setDebut(debut);
			se.setFin(debut);
			se.setSelected(false);
		}
	}
		
	public void Inserer(String txt)
	{
		bf.getZoneText().insert(0, txt);
		/*if(se.getDebut() >= 0 && se.getFin() >= 0)	
		{
			if(se.isSelected())
			{
				StringBuffer val = bf.getZoneText().delete(se.getDebut(), se.getFin());
				bf.setZoneText(val);
			}
			bf.getZoneText().insert(se.getDebut(), txt);
		}*/
	}
	
}
