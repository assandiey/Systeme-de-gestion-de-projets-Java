package ca.uqam.h2024.inf2120.grpe30.tp1;

/**
 * UQAM_Hiver-2024_INF2120_Groupe_30_TP1
 * 
 * Cette classe represente la super classe de développeur permanent et developpeur contractuel
 * 
 * @author ASSANE DIEYE  
 * @version 11 FEVRIER 2024
 */

public abstract class Developpeur extends Employe {
	
	
	//declaration des attributs
	private String type;

	//constructeur sans parametre 
	public Developpeur()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	//constructeur avec parametre
	public Developpeur(String prenom, String nom, String matricule, String poste, 
			String courrielAdresse,String telephone, String type) 
	{
		super(prenom, nom, matricule, poste, courrielAdresse, telephone);
		this.type = type;

	}
	

	public String getType() 
	{
		return type;
	}

	
	//methode to string pour affichage des informations de la classe
	@Override
	public String toString()
	{
		
		return String.format("%-20s     |   %-20s", super.toString(), type);
		//return super.toString() + "   |   " + type;
	}

}
