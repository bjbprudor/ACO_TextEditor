package fr.istic.m1.aco.miniediteur.v1;

import fr.istic.m1.aco.miniediteur.MoteurEdition;

/**
 * @author 16013094
 *
 */
public class MEI1 implements MoteurEdition
{
	
	public void Copier() 
	{
		if(se.getDebut() >= 0 && se.getLongueur() >= 0 && se.isSelected())
		{
			if(bf.getZoneText().length() >= se.getLongueur())
			{
				String val = bf.getZoneText().substring(se.getDebut(), se.getLongueur()+1); // on recupere la selection de texte
				pp.setContenuPP(val); // on enregistre le texte dans le presse papier
			}
		}
	}

	@Override
	public void Coller()
	{
		if (se.getDebut() >= 0 && se.getLongueur() >= 0) 
		{
			if(se.isSelected())
			{
				StringBuffer val = bf.getZoneText().delete(se.getDebut(), se.getLongueur());
				bf.setZoneText(val);
			}		
			StringBuffer val = bf.getZoneText().insert(se.getDebut(), pp.getContenuPP());
			bf.setZoneText(val);
			se.setDebut(se.getDebut()+pp.getContenuPP().length());
			se.setLongueur(0);
			se.setSelected(false);
		}
		
	}

	@Override
	public void Couper()
	{
		if(se.getDebut() >= 0 && se.getLongueur() >= 0 && se.isSelected())
		{
			if(bf.getZoneText().length() >= se.getLongueur())
			{
				String val = bf.getZoneText().substring(se.getDebut(), se.getLongueur()+1);
				pp.setContenuPP(val);
				StringBuffer val2 = bf.getZoneText().delete(se.getDebut(), se.getLongueur());
				bf.setZoneText(val2);
				se.setLongueur(0);//
				se.setSelected(false);
			}
		}
	}

	@Override
	public void selectionner(int deb, int longe)
	{
		int debut = 0, longueur = 0;
		if (debut >= 0 && longueur > 0) 
		{			
			if (bf.getZoneText().length() - debut >= longueur) //pour ne pas dépasser la chaine séléctionnée
			{
				se.setLongueur(debut + longueur-1);
			}
			else 
			{
				se.setLongueur(bf.getZoneText().length()-1 );
			}
			se.setDebut(debut);
			se.setSelected(true);
		}
		else 
		{
			se.setDebut(debut);
			se.setLongueur(debut);
			se.setSelected(false);
		}
	}
		
	public void Inserer(String txt)
	{
		if(se.getDebut() >= 0 && se.getLongueur() >= 0)	
		{
			if(se.isSelected())
			{
				StringBuffer val = bf.getZoneText().delete(se.getDebut(), se.getLongueur());
				bf.setZoneText(val);
			}
			bf.getZoneText().insert(se.getDebut(), txt);
			se.setDebut(se.getDebut()+txt.length());
			se.setLongueur(0);
			se.setSelected(false);
		}
	}

	@Override
	public void Supprimer() 
	{
		if(se.getDebut() >= 0 && se.getLongueur() >= 0 && se.isSelected())
		{
			if(bf.getZoneText().length() >= se.getLongueur())
			{
				StringBuffer val2 = bf.getZoneText().delete(se.getDebut(), se.getLongueur());
				bf.setZoneText(val2);
				se.setLongueur(0);
				se.setSelected(false);
			}
		}
		else if(se.getDebut() > 0)
		{
			StringBuffer val = bf.getZoneText().delete(se.getDebut()-1, se.getDebut());
			bf.setZoneText(val);
			se.setLongueur(0);
			se.setSelected(false);
		}
		
	}
	
}
