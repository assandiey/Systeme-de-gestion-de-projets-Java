package ca.uqam.h2024.inf2120.grpe30.tp1;

import java.time.LocalDate;

/**
 * UQAM_Hiver-2024_INF2120_Groupe_30_TP1
 * 
 * Cette classe représente les données du contrat d’un développeur contractuel.
 * 
 * @author ASSANE DIEYE  
 * @version 11 FEVRIER 2024
 */

public class Contrat {

	private int identifiant;
	private LocalDate dateDebut;
	private LocalDate dateFin;

	public Contrat() {
		super();
	}

	public Contrat(int identifiant, LocalDate dateDebut, LocalDate dateFin) {

		this.identifiant = identifiant;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}



	@Override
	public String toString() {
		return "Contrat : " + identifiant + " | " + dateDebut + " | " + dateFin;
	}

}// fin
