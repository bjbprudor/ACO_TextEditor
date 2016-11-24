package fr.istic.m1.aco.miniediteur;

import java.util.Scanner;

import fr.istic.m1.aco.miniediteur.v1.MEI1;
import fr.istic.m1.aco.miniediteur.v1.MiniEditorV1;
import fr.istic.m1.aco.miniediteur.v2.MEI2;
import fr.istic.m1.aco.miniediteur.v2.MiniEditorV2;

public class Configurator 
{

	public static MoteurEdition mei;
	public static IHM ihm;
	
	public static void main(String[] args) 
	{
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Veuillez selectionner la version du programme que vous voulez lancer");
		System.out.println("V1, V2 ou V3 ?");
		String res = scan.nextLine();
		scan.close();
		if(res == "V1")
		{
			LaunchV1();
		}
		if(res == "V2")
		{
			LaunchV2();
		}
		if(res == "V3")
		{
			LaunchV3();
		}
		
	}

	public static void LaunchV1()
	{
		mei = new MEI1();
		MiniEditorV1.main(null);		
	}
	
	public static void LaunchV2()
	{
		mei = new MEI2();
		MiniEditorV2.main(null);
	}
	
	public static void LaunchV3()
	{
		
	}
	
	
}
