package fr.istic.m1.aco.miniediteur;

import fr.istic.m1.aco.miniediteur.states.Buffer;
import fr.istic.m1.aco.miniediteur.states.PressePapier;
import fr.istic.m1.aco.miniediteur.states.Selection;

/**
 * 
 * @author Mu-B
 *
 */
public interface MoteurEdition 
{

	public Buffer bf = new Buffer(new StringBuffer());
	public PressePapier pp = new PressePapier("");
	public Selection se = new Selection(0, 0);
	
	public void Copier();
	public void Coller();
	public void Couper();
	public void Inserer(String txt);
	public void selectionner(int deb, int longe);
	public void Supprimer();

}
