package fr.istic.m1.aco.miniediteur;

import java.util.Scanner;

import fr.istic.m1.aco.miniediteur.v1.MEI1;
import fr.istic.m1.aco.miniediteur.v1.MiniEditorV1;
import fr.istic.m1.aco.miniediteur.v2.MEI2;
import fr.istic.m1.aco.miniediteur.v2.MiniEditorV2;
import fr.istic.m1.aco.miniediteur.v3.MEI3;
import fr.istic.m1.aco.miniediteur.v3.MiniEditorV3;

/**
 * 
 * @author Mu-B
 *
 */
public class Configurator 
{
	
	public static void main(String[] args) 
	{
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Veuillez selectionner la version du programme que vous voulez lancer");
		System.out.println("Ver.1,2 ou 3 ?");
		int resu = scan.nextInt();
		scan.close();
		if(resu == 1)
		{
			LaunchV1();
		}
		else if(resu == 2)
		{
			LaunchV2();
		}
		else if(resu == 3)
		{
			LaunchV3();
		}
		
	}

	public static void LaunchV1()
	{
		MiniEditorV1 frame = new MiniEditorV1();
		frame.SetMEI(new MEI1());
		frame.setVisible(true);		
	}
	
	public static void LaunchV2()
	{
		MiniEditorV2 frame = new MiniEditorV2();
		frame.SetMEI(new MEI2());
		frame.setVisible(true);	
	}
	
	public static void LaunchV3()
	{
		MiniEditorV3 frame = new MiniEditorV3();
		frame.SetMEI(new MEI3());
		frame.setVisible(true);	
	}
	
	
}
