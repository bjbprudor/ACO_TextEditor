package fr.istic.m1.aco.miniediteur.v1.test;

import static org.junit.Assert.*;

import fr.istic.m1.aco.miniediteur.states.Selection;

public class TestSelection 
{

	@org.junit.Test
	public void test() 
	{
		int i,j,k,l;
		i = 0;
		j = 10;
		k = 20;
		l = 42;
		
		Selection se = new Selection(i, j);
		assertEquals(i, se.getDebut());
		assertEquals(j, se.getFin());
		
		se.setDebut(k);
		se.setFin(l);
		assertEquals(k, se.getDebut());
		assertEquals(l, se.getFin());
		
	}
	
}
