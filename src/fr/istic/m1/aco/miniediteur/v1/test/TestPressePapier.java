package fr.istic.m1.aco.miniediteur.v1.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.istic.m1.aco.miniediteur.states.PressePapier;

public class TestPressePapier 
{

	@Test
	public void test() 
	{
		String s1 = "Hello world";
		String s2 = "Hello java";
		
		PressePapier pp = new PressePapier(s1);
		assertEquals(s1, pp.getContenuPP());
		
		pp.setContenuPP(s2);
		assertEquals(s2, pp.getContenuPP());
		
	}

}
