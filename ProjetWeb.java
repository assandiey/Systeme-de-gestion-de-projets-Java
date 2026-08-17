package ca.uqam.h2024.inf2120.grpe30.tp1;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *UQAM_Hiver-2024_INF2120_Groupe_30_TP1
 * 
 * Cette classe représente les données d’un projet informatique de type Web.
 * 
 * @author ASSANE DIEYE 
 * @version 11 FEVRIER 2024
 */

public class ProjetWeb extends ProjetInformatique {

	
	//declaration des attributs
	private String navigateursSupportes;

	
	
	
	//constructeur sans parametre
	public ProjetWeb() {
		super();
	}

	
	
	
	//constructeur avec parametre
	public ProjetWeb(int identifiant, LocalDate dateDebut, LocalDate dateFin, double budget, 
			String type, String titre,ArrayList<Employe> equipe,String navigateursSupportes) {

		super(identifiant, dateDebut, dateFin, budget, type, titre,equipe);

		this.navigateursSupportes = navigateursSupportes;
	}

	

	
	//methode to string pour affichage des informations de la classe
	@Override
	public String toString() {
		

		
		 return String.format("%-20s %-15s  \t\t\t\t\t\t %-15s", super.toString(), navigateursSupportes, 
				 super.getEquipe().isEmpty() ? "" : super.affichertableau() );
		
	}

}
