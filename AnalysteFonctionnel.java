package ca.uqam.h2024.inf2120.grpe30.tp1;

/**
 * 
 * UQAM_Hiver 2024_INF2120_Groupe_30_TP1
 * 
 * Cette classe représente les données d’un employé responsable de l’analyse des
 * besoins de l’utilisateur.
 * 
 * @author ASSANE DIEYE  
 * @version 11 FEVRIER 2024
 */

public class AnalysteFonctionnel extends Employe {

	private boolean estDesignerUxUI;

	public AnalysteFonctionnel() {
		super();
	}

	public AnalysteFonctionnel(String prenom, String nom, String matricule, String poste, String courrielAdresse,
			String telephone, boolean estDesignerUxUI) {
		super(prenom, nom, matricule, poste, courrielAdresse, telephone);
		this.estDesignerUxUI = estDesignerUxUI;
	}

	/**
	 * @return estDesignerUxUI en String
	 */
	public String getEstDesignerUxUI() {

		String estDesignerUxUIString = "";

		if (estDesignerUxUI == true) {
			estDesignerUxUIString = "Designer Ux/UI ";
		}

		return estDesignerUxUIString;
	}

	@Override
	public String toString() {

	    return String.format(" %-25s     | %-20s", super.toString(), getEstDesignerUxUI());
	
		
	}

}
