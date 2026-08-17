package ca.uqam.h2024.inf2120.grpe30.tp1;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * UQAM_Hiver-2024_INF2120_Groupe_30_TP1
 * 
 * Cette classe represente la super classe de projet mobile eet projet web
 * 
 * @author ASSANE DIEYE  
 * @version 11 FEVRIER 2024
 */

public abstract class ProjetInformatique {

	//declaration des attributs
	private int identifiant;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private double budget;
	private String type;
	private String titre;

	private ArrayList<Employe> equipe = new ArrayList<Employe>();

	
	
	//constructeur sans parametre
	public ProjetInformatique() 
	{

	}
	

	//constructeur avec parametere
	public ProjetInformatique(int identifiant, LocalDate dateDebut, 
			LocalDate dateFin, double budget, String type,String titre, ArrayList<Employe> equipe) 
	{

		this.identifiant = identifiant;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.budget = budget;
		this.type = type;
		this.titre = titre;
		
	}

	public int getIdentifiant() 
	{
		return identifiant;
	}
	

	public String getType() 
	{
		return type;
	}
	

	//obtenir equipe
	public ArrayList<Employe> getEquipe() 
	{
		return equipe;
	}
	

	/**
	 * 
	 * Cette méthode vérifie si un employé de type GestionnaireProjet est assigné au
	 * projet courant, autrement dit elle vérifie si la liste des membres (attribut
	 * 'equipe') contient un objet de type GestionnaireProjet.
	 * 
	 * @return vrai si l'attribut 'equipe' contient un objet de type
	 *         GestionnaireProjet, sinon faux.
	 * 
	 */

	public boolean estAssigneGestionnaireProjet() 
	{
		if(!equipe.isEmpty()) 
		{
			for (Employe emp : equipe) {
				if (emp.getClass().getSimpleName().equals("GestionnaireProjet")) {
					return true;
				}
			}		
		}
		return false;
	}
	

	/**
	 * Cette méthode vérifie si l'employé passé en paramètre est assigné au projet
	 * courant, autrement dit elle vérifie si la liste des membres (attribut
	 * 'equipe') contient l'employé passé en paramètre.
	 * 
	 * @param empl
	 * @return vrai si l'attribut 'equipe' contient l'employé passé en paramètre,
	 *         sinon faux.
	 */
	public boolean estAssigneEmploye(Employe empl) 
	{

		if (!(equipe == null)) {

			for (Employe emp : equipe) {
				if (emp == empl) {
					return true;
				}
			}

		}
		return false;
	}

	
	/**
	 * Cette méthode ajoute un membre dans la liste des membres, autrement dit elle
	 * ajoute l'employé 'empl' passé en paramètre dans l'attribut 'equipe'.
	 * 
	 * 
	 * @param empl
	 * @return vrai si l'employé 'empl' passé en paramètre est ajouté dans
	 *         l'attribut 'equipe' avec succès, sinon faux.
	 */
	public boolean ajouterMembre(Employe empl) 
	{

		// equipe.add(empl);

		if (equipe.add(empl)) 
		{

			return true;
		}
		return false;
	}

	
	/**
	 *  Cette méthode retire un membre de la liste des membres, autrement dit
	 * elle retire l'employé 'empl' passé en paramètre dans l'attribut 'equipe'.
	 * 
	 * 
	 * @param empl
	 * @return vrai si l'employé 'empl' est retiré dans l'attribut 'equipe'
	 * avec succès, sinon faux.
	 */
	public boolean retirerMembre(Employe empl)
	{

		equipe.remove(empl);

		if (equipe.remove(empl)) {

			return true;

		}
		return false;
	}
	

	public String  affichertableau() 
	{
		
		String result = "\n\t\t\t\t\t\t";
		for (int i = 0; i < equipe.size(); i++) {
			result += equipe.get(i).toString();
			
			if (i != equipe.size()-1) {
				result += " \n\t\t\t\t\t\t"; 
			}
		}
		return result;
		
	}
	
	
	// methode to string pour affichage des informations de la classe
	@Override
	public String toString() 
	{
		
		return String.format("%-7s | %-8s | %-50s |%-8.2f $| %-11s | %-10s|", 
		        identifiant, type, titre, budget, dateDebut, dateFin);
		
		
	}

	

}
