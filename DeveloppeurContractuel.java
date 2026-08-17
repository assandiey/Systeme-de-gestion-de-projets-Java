package ca.uqam.h2024.inf2120.grpe30.tp1;

/**
 * UQAM_Hiver-2024_INF2120_Groupe_30_TP1
 * 
 * Cette classe représente les données d’un employé contractuel dont le rôle est
 * de concevoir, programmer, développer, et améliorer les logiciels (c’est
 * l’expert des langages informatiques).
 * 
 * @author ASSANE DIEYE  
 * @version 11 FEVRIER 2024
 * 
 */

public class DeveloppeurContractuel extends Developpeur {
	
	//declaration attribut
	private Contrat unContrat;

	///constructeur sans parametre
	public DeveloppeurContractuel() {

		super();
	}
	
	//constructeur avec parametre
	public DeveloppeurContractuel(String prenom, String nom, String matricule, String poste, String courrielAdresse,
			String telephone, String type, Contrat unContrat) {
		super(prenom, nom, matricule, poste, courrielAdresse, telephone, type);

		this.unContrat = unContrat;

	}


	//methode to string pour affichage des informations de la classe
	@Override
	public String toString() {
		 return String.format(" %-20s\n\t\t\t\t\t               | %-20s", super.toString(), unContrat);
		
	}//

}
