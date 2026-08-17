package ca.uqam.h2024.inf2120.grpe30.tp1;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * UQAM_Hiver-2024_INF2120_Groupe_30_TP1
 * 
 * Cette classe représente les données d’un projet informatique de type Mobile.
 * 
 * @author ASSANE DIEYE 
 * @version 11 FEVRIER 2024
 */

public class ProjetMobile extends ProjetInformatique {

	
	//declaration des attribut
	private String appareilsCibles;
	private String systExplSupportes;

	
	//constructeur sans parametre
	public ProjetMobile() {
		super();

	}

	
	//constructeur avec parametre
	public ProjetMobile(int identifiant, LocalDate dateDebut, LocalDate dateFin, double budget, String type,
			String titre, ArrayList<Employe> equipe,String appareilsCibles, String systExplSupportes) {

		super(identifiant, dateDebut, dateFin, budget, type, titre,equipe);
		this.appareilsCibles = appareilsCibles;
		this.systExplSupportes = systExplSupportes;
	}

	
	
	//methode to string pour affichage des informations de la classe
	@Override
	public String toString() {
		
		return String.format("%s %-40s   | %-40s  \t\t\t\t\t\t %-20s ", 
		        super.toString(), appareilsCibles, systExplSupportes,
		        super.getEquipe().isEmpty() ? "" : super.affichertableau());
		
		
	}

}
