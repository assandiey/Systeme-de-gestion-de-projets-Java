package ca.uqam.h2024.inf2120.grpe30.tp1;

/**
 *UQAM_Hiver-2024_INF2120_Groupe_30_TP1
 * 
 * Cette classe représente les données d’un testeur dont le rôle est d’établir
 * des stratégies, d’élaborer et d’exécuter les tests. Il ou elle analyse les
 * résultats, rédige des rapports et transmet les anomalies détectées au
 * développeur, chargé des corrections.
 * 
 * @author ASSANE DIEYE 
 * @version 11 FEVRIER 2024
 */

public class Testeur extends Employe {

	//declaration des attribut
	private String specialite;

	
	//constructeur sans parametre
	public Testeur() {

		super();
	}
	
	//constructeur avec parametre
	public Testeur(String prenom, String nom, String matricule, String poste,
			String courrielAdresse, String telephone,String specialite) {

		super(prenom, nom, matricule, poste, courrielAdresse, telephone);
		this.specialite = specialite;
	}

	
	//methode to string pour affichage des informations de la classe
	@Override
	public String toString() {
		return String.format(" %-40s     |  %-40s", super.toString(), specialite);
		
	}

}
