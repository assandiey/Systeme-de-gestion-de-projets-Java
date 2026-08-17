package ca.uqam.h2024.inf2120.grpe30.tp1;

import java.util.Objects;

/**
 * UQAM_Hiver-2024_INF2120_Groupe_30_TP1
 * Cette classe Employe represente la super classe des employes
 * 
 * @author ASSANE DIEYE  
 * @version 11 FEVRIER 2024
 */

public abstract class Employe {

	//declraration des attributs
	private String prenom;
	private String nom;
	private String matricule;
	private String poste;
	private String courrielAdresse;
	private String telephone;

	//constructeur sans parametre
	public Employe() {

	}
	//constructeur avec parametre
	public Employe(String prenom, String nom, String matricule, String poste, String courrielAdresse,
			String telephone) {

		this.prenom = prenom;
		this.nom = nom;
		this.matricule = matricule;
		this.poste = poste;
		this.courrielAdresse = courrielAdresse;
		this.telephone = telephone;
	}

	
	//obtenir matricule de l'employe 
	public String getMatricule() {
		return matricule;
	}
	//obtenir poste de l'employe 
	public String getPoste() {
		return poste;
	}

	

	//Method equals redefine
	@Override
	public boolean equals(Object autreobj) {
		if (this == autreobj)
			return true;
		if (autreobj == null)
			return false;
		if (getClass() != autreobj.getClass())
			return false;
		Employe hakunaMatata = (Employe) autreobj;
		return Objects.equals(poste, hakunaMatata.poste);
	}

	//methode to string pour affichage des informations de la classe
	@Override
	public String toString() {
		
		return String.format("%-25s | %-20s  |  %-10s  |  %-13s  |  %-34s",poste,prenom + "  " + nom,
				matricule, telephone, courrielAdresse);
		
	}

}// FIN
