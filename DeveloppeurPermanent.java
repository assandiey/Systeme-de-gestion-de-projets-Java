package ca.uqam.h2024.inf2120.grpe30.tp1;

/**
 * UQAM_Hiver-2024_INF2120_Groupe_30_TP1
 * 
 * Cette classe représente les données d’un employé permanent dont le rôle est
 * de concevoir, programmer, développer, et améliorer les logiciels (c’est
 * l’expert des langages informatiques).
 * 
 * @author ASSANE DIEYE  
 * @version 11 FEVRIER 2024
 */

public class DeveloppeurPermanent extends Developpeur {
	
	//declaration des attributs
	private String  titre;

	//constructeur sans parametre
	public DeveloppeurPermanent() {
		super();
	}

	//constructeur avec parametre
	public DeveloppeurPermanent(String prenom, String nom, String matricule, String poste, String courrielAdresse,
			String telephone, String type, String titre) {
		super(prenom, nom, matricule, poste, courrielAdresse, telephone, type);
		this.titre = titre;
	}

	

	//methode to string pour affichage des informations de la classe
	@Override
	public String toString() {
		return String.format(" %-40s   |   %-40s", super.toString(), titre);
		 
	}

}
