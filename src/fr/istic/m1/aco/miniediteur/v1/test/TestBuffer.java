package fr.istic.m1.aco.miniediteur.v1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.istic.m1.aco.miniediteur.states.Buffer;

public class TestBuffer 
{

	@Test
	public void test() 
	{
		StringBuffer sb = new StringBuffer();
		sb.append("hello world");		
		StringBuffer sb2 = new StringBuffer();
		sb2.append("hello java");
		
		Buffer bf = new Buffer(sb);
		assertEquals(sb, bf.getZoneText());		

		bf.setZoneText(sb2);
		assertEquals(sb2, bf.getZoneText());
		
	}

}
