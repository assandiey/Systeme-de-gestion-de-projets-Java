package ca.uqam.h2024.inf2120.grpe30.tp1;

/**
 * UQAM_Hiver-2024_INF2120_Groupe_30_TP1
 * Cette classe represente les donnees d'un employe responsable de la gestion des projets 
 * 
 * @author ASSANE DIEYE  
 * @version 11 FEVRIER 2024
 */

public class GestionnaireProjet extends Employe {

	//declaration des attributs
	private String seniorite;

	//constructeru sans parametre
	public GestionnaireProjet()
	{
		super();

	}

	
	//constructeur avec parametre
	public GestionnaireProjet(String prenom, String nom, String matricule, String poste,
			String courrielAdresse,String telephone, String seniorite) 
	{
		super(prenom, nom, matricule, poste, courrielAdresse, telephone);
		this.seniorite = seniorite;
	}
	

	
	//methode to string pour affichage des informations de la classe
	@Override
	public String toString() 
	{
		
		return String.format(" %-10s     |   %-20s", super.toString(), seniorite);

	}

}
