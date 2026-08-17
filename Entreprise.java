package ca.uqam.h2024.inf2120.grpe30.tp1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * UQAM - Hiver 2024 - INF2120 - Groupe 30 - TP1
 * 
 * Classe Entreprise : cette classe définit un ensemble de services pour la
 * gestion des listes de projets et d'employés. Ces services permettront
 * d'ajouter des projets dans une listes, d'assigner des employés aux projets,
 * et de retirer des employés des projets.
 * 
 * VOUS DEVEZ COMPLÉTER LES MÉTHODES SUIVANTES : - public void
 * lireFichierProjets() - public void lireFichierEmployes() - public
 * ProjetInformatique rechercherProjetParId(int identifiant) - public Employe
 * rechercherEmployeParMatricule(String matricule) - public boolean
 * ajouterProjet(ProjetInformatique unProjet) - public boolean
 * ajouterEmployeProjet(int projetId, Employe emp) - public boolean
 * retirerEmployeProjet(int projetId, Employe emp) - public ArrayList<Employe>
 * rechercherEmployesNonAssignes() - public ArrayList<ProjetInformatique>
 * rechercherProjetsParType(String type) - public ArrayList<Employe>
 * rechercherEmployesParProjet(int identifiant)
 * 
 * 
 * VOIR LA JAVADOC DE CES MÉTHODES POUR PLUS DE DÉTAILS SUR LEURS
 * IMPLÉMENTATIONS.
 * 
 * INFORMATIONS IMPORTANTES : Ajoutez toute autre méthode privée que vous jugez
 * nécessaire pour accomplir ce travail.
 * 
 * @author ASSANE DIEYE  
 * 
 * @version 31 janvier 2024
 */

public class Entreprise {

	// Déclaration des constantes
	final String GP = "Gestionnaire de projet";
	final String AF = "Analyste Fonctionnel";
	final String DP = "Développeur Permanent";
	final String DC = "Développeur contractuel";
	final String TT = "Testeur";

	public static final String WEB = "WEB"; // Type du projet Web
	public static final String MOBILE = "MOBILE"; // Type du projet Mobile

	final String OUI = "OUI";
	final String NON = "NON";

	final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	// Le fichier à lire
	private static final String EMPLOYES = "Employes.csv";
	private static final String PROJETS = "Projets.csv";

	// La liste des projets
	private ArrayList<ProjetInformatique> projets;

	// La liste des employés
	private ArrayList<Employe> employes;

	/**
	 * Le constructeur de la classe qui crée les listes des projets et des employés.
	 */
	public Entreprise() {
		projets = new ArrayList<>();
		employes = new ArrayList<>();
	}

	/**
	 * Retourne la liste des projets.
	 * 
	 * @return la liste des projets
	 */
	public ArrayList<ProjetInformatique> getProjets() {
		return projets;
	}

	/**
	 * Retourne la liste des employés
	 * 
	 * @return la liste des employés
	 */
	public ArrayList<Employe> getEmployes() {
		return employes;
	}

	/**
	 * Cette méthode doit lire le fichier "Projets.csv", créer les projets,
     * ensuite ces projets doivent être ajoutés dans la liste des projets 
     * (projets).
	 * 
	 * À l'exception de la 1ère ligne, chaque ligne du fichier est composée des
	 * données d'un projet Web ou d'un projet Mobile.
	 * 
	 * Chaque ligne doit être lue, séparée en plusieurs données,et ces dernières
	 * doivent être utilisées pour créer les différents objets.
	 * 
	 */
	public void lireFichierProjets() {

		String uneLigne;

		try (BufferedReader fluxTampon = new BufferedReader(new FileReader(PROJETS))) {

			while (fluxTampon.ready()) {

				uneLigne = fluxTampon.readLine();

				ajouterProjetDansListeProjet(uneLigne);
			}
			

		} catch (FileNotFoundException e) {
			System.out.println("Fichier introuvable: " + PROJETS);

		} catch (IOException e) {
			System.out.println("Erreur de lecture du fichier: " + PROJETS);
		}

		
	}

	/**
	 *  
	* cette methode cree un projet web
	* 
	*/
	private ProjetInformatique creerProjetWeb(String[] tab) {

		int identifiant = Integer.parseInt(tab[0].trim());
		String titre = tab[1].trim();
		String type = tab[2].trim();
		double budget = Double.parseDouble(tab[3].trim());
		String dateDebutString = tab[4].trim();
		String dateFinString = tab[5].trim();
		String navigateursSupportes = tab[6].trim();
		LocalDate dateDebut = LocalDate.parse(dateDebutString, FORMAT);
		LocalDate dateFin = LocalDate.parse(dateFinString, FORMAT);
		ProjetInformatique proj=new ProjetWeb();
		
		return new ProjetWeb(identifiant, dateDebut, dateFin, budget, type, titre,proj.getEquipe(), navigateursSupportes);
	}
	

	/**
	* 
	* cette methode cree un projet mobile
	*
	*/
	private ProjetInformatique creerProjetMobile(String[] tab) {

		int identifiant = Integer.parseInt(tab[0].trim());
		String titre = tab[1].trim();
		String type = tab[2].trim();
		double budget = Double.parseDouble(tab[3].trim());
		String dateDebutString = tab[4].trim();
		String dateFinString = tab[5].trim();
		String appareilsCible = tab[7].trim();
		String systemeExploitationSupp = tab[8].trim();
		LocalDate dateDebut = LocalDate.parse(dateDebutString, FORMAT);
		LocalDate dateFin = LocalDate.parse(dateFinString, FORMAT);
        ProjetInformatique proj = new ProjetMobile();
		
		return new ProjetMobile(identifiant, dateDebut, dateFin, budget, type, titre, proj.getEquipe() , appareilsCible, systemeExploitationSupp);

	}

	/**
	* 
	* cette methode ajoute les projets dans la liste des projets
	* 
	*/
	private void ajouterProjetDansListeProjet(String uneLigne) 
	{

		String[] DonneesLignes;
		String typeProjet;
		ProjetInformatique unProjet;

		DonneesLignes = uneLigne.split("\\;");
		typeProjet = DonneesLignes[2].trim();

		
			
		if (WEB.equalsIgnoreCase(typeProjet)) {
			unProjet = creerProjetWeb(DonneesLignes);
			projets.add(unProjet);
			
		} else if (MOBILE.equalsIgnoreCase(typeProjet)) {
			unProjet = creerProjetMobile(DonneesLignes);
			projets.add(unProjet);

		}
	}

	

	/**
	 * Cette méthode doit lire le fichier "Employes.csv", créer les employés,
	 * ensuite ces employés doivent être ajoutés dans la liste des employés
	 * (employes).
	 * 
	 * À l'exception de la 1ère ligne, chaque ligne du fichier est composée des
	 * données d'un gestionnaire de projet, d'un analyste fonctionnel, d'un
	 * développeur permanent, d'un développeur contractuel, ou d'un testeur.
	 * 
	 * Chaque ligne doit être lue, séparée en plusieurs données,et ces dernières
	 * doivent être utilisées pour créer les différents objets.
	 * 
	 */
	public void lireFichierEmployes() {

		String uneLigne;

		try (BufferedReader fluxTampon = new BufferedReader(new FileReader(EMPLOYES))) 
		
		{

			while (fluxTampon.ready()) {

				uneLigne = fluxTampon.readLine();
				
				ajouterEmplDansListeEmpl(uneLigne);
			}

		} catch (FileNotFoundException e) {
			System.out.println("Fichier introuvable: " + EMPLOYES);

		} catch (IOException e) {
			System.out.println("Erreur de lecture du fichier: " + EMPLOYES);
		}

	}
	

	/**
	* 
	* 
	* cette methode ajoute un employe dans la liste des employes
	* 
	*/
	private void ajouterEmplDansListeEmpl(String uneLigne) 
	{

		String[] tab;
		String typeEmploye;
		Employe unEmploye;

		tab = uneLigne.split("\\;");
		typeEmploye = tab[3].trim();

		if (GP.equalsIgnoreCase(typeEmploye)) {

			unEmploye = creerGestionnaireProjet(tab);
			employes.add(unEmploye);

		} else if (AF.equalsIgnoreCase(typeEmploye)) {
			unEmploye = creerAnalysteFonctionnel(tab);
			employes.add(unEmploye);

		}

		else if (DP.equalsIgnoreCase(typeEmploye)) {
			unEmploye = creerDeveloppeurPermanent(tab);
			employes.add(unEmploye);

		}

		else if (DC.equalsIgnoreCase(typeEmploye)) {
			unEmploye = creerDeveloppeurContractuel(tab);
			employes.add(unEmploye);

		}

		else if (TT.equalsIgnoreCase(typeEmploye)) {
			unEmploye = creerTesteur(tab);
			employes.add(unEmploye);

		}
	}
	
	/*
	 * public static String removeAccents(String str) { String normalizedStr =
	 * Normalizer.normalize(str, Normalizer.Form.NFD); Pattern pattern =
	 * Pattern.compile("\\p{InCombiningDiacriticalMarks}+"); return
	 * pattern.matcher(normalizedStr).replaceAll(""); }
	 */

	/**
	* 
	* cette methode cree un gestionnaire de projet
	* 
	*/
	private Employe creerGestionnaireProjet(String[] uneLignes)
	{

		String prenom = uneLignes[0].trim();
		String nom = uneLignes[1].trim();
		String matricule = uneLignes[2].trim();
		String poste = uneLignes[3].trim();
		String courrielAdresse = uneLignes[4].trim();
		String telephone = uneLignes[5].trim();
		String seniorite = uneLignes[6].trim();

		return new GestionnaireProjet(prenom, nom, matricule, poste, courrielAdresse, telephone, seniorite);

	}

	/**
	* 
	* 
	* cette methode cre un analyste fonctionnel
	* 
	*/
	private Employe creerAnalysteFonctionnel(String[] uneLignes) 
	{

		String prenom = uneLignes[0].trim();
		String nom = uneLignes[1].trim();
		String matricule = uneLignes[2].trim();
		String poste = uneLignes[3].trim();
		String courrielAdresse = uneLignes[4].trim();
		String telephone = uneLignes[5].trim();
		// String seniorite = uneLignes[6].trim();
		String estDesignerUxUIString = uneLignes[7].trim();

		boolean estDesignerUxUI = false;

		if (estDesignerUxUIString.equalsIgnoreCase(OUI)) {

			estDesignerUxUI = true;

		} else if (estDesignerUxUIString.equalsIgnoreCase(NON)) {

			estDesignerUxUI = false;
		}

		return new AnalysteFonctionnel(prenom, nom, matricule, poste, courrielAdresse, telephone, estDesignerUxUI);

	}
	

	/**
	  * 
	  * cette methode cree un testeur
	  * 
	  */
	private Employe creerTesteur(String[] uneLignes) 
	{

		String prenom = uneLignes[0].trim();
		String nom = uneLignes[1].trim();
		String matricule = uneLignes[2].trim();
		String poste = uneLignes[3].trim();
		String courrielAdresse = uneLignes[4].trim();
		String telephone = uneLignes[5].trim();
		String specialite = uneLignes[8].trim();

		return new Testeur(prenom, nom, matricule, poste, courrielAdresse, telephone, specialite);

	}

	/**
	*  
	* cette methode cree un developpeur permanent
	* 
	*/
	private Employe creerDeveloppeurPermanent(String[] uneLignes) 
	{

		String prenom = uneLignes[0].trim();
		String nom = uneLignes[1].trim();
		String matricule = uneLignes[2].trim();
		String poste = uneLignes[3].trim();
		String courrielAdresse = uneLignes[4].trim();
		String telephone = uneLignes[5].trim();
		String type = uneLignes[9].trim();
		String titre = uneLignes[10].trim();

		return new DeveloppeurPermanent(prenom, nom, matricule, poste, courrielAdresse, telephone, type, titre);

	}

	/**
	* 
	* cette methode cre un developpeur contractuel
	* 
	*/
	private Employe creerDeveloppeurContractuel(String[] uneLignes)
	{

		String prenom = uneLignes[0].trim();
		String nom = uneLignes[1].trim();
		String matricule = uneLignes[2].trim();
		String poste = uneLignes[3].trim();
		String courrielAdresse = uneLignes[4].trim();
		String telephone = uneLignes[5].trim();
		String type = uneLignes[9].trim();
		int identifiant = Integer.parseInt(uneLignes[11].trim());
		String dateDebutString = uneLignes[12].trim();
		String dateFinString = uneLignes[13].trim();
		LocalDate dateDebut = LocalDate.parse(dateDebutString, FORMAT);
		LocalDate dateFin = LocalDate.parse(dateFinString, FORMAT);

		Contrat ctra = new Contrat(identifiant, dateDebut, dateFin);

		return new DeveloppeurContractuel(prenom, nom, matricule, poste, courrielAdresse, telephone, type, ctra);

	}

	/**
	 * Cette méthode recherche un projet dans liste des projets (projets) à partir
	 * de son identifiant.
	 * 
	 * La méthode retourne le projet qui a l'identifiant égal à l'identifiant passé
	 * en paramètre, null si aucun projet trouvé avec cet identifiant.
	 * 
	 * @param identifiant l'identifiant du projet à rechercher
	 * @return le projet ou null si aucun projet trouvé
	 */
	public ProjetInformatique rechercherProjetParId(int identifiant)
	{

		for (ProjetInformatique projet : projets) {

			int id = projet.getIdentifiant();

			if (projet != null && id == identifiant) {
				return projet;
			}

		}

		return null;
	}
	
	

	/**
	 * Cette méthode recherche un employé dans liste des employés (employes) à
	 * partir de son matricule.
	 * 
	 * La méthode retourne l'employé qui a le matricule égal au matricule passé en
	 * paramètre, null si aucun employé trouvé avec ce matricule.
	 * 
	 * @param matricule le matricule de l'employé à rechercher
	 * @return l'employé ou null si aucun employé trouvé
	 */
	public Employe rechercherEmployeParMatricule(String matricule)
	{
		if (!employes.isEmpty()) {
			for (Employe empl : employes) {
				if (empl != null && empl.getMatricule().equalsIgnoreCase(matricule)) {
					return empl;
				}
			}
		}
		return null;
	}
	
	

	/**
	 * Cette méthode ajoute le projet passé en paramètre dans la liste des projets
	 * (projets).
	 * 
	 * @param unProjet le projet à ajouter
	 * @return vrai si le projet a été ajouté, sinon faux.
	 */
	public boolean ajouterProjet(ProjetInformatique unProjet) 
	{

		if (unProjet != null && !projets.contains(unProjet)) {
			projets.add(unProjet);
			return true;
		}

		return false;

	}
	
	
	

	/**
	 * Cette méthode ajoute l'employé passé en paramètre dans le projet dont
	 * l'identifiant est aussi passé en paranmètre. Elle recherche le projet dans la
	 * liste des projets en utilisant l'identifiant passé en paramètre. Une fois que
	 * le projet est trouvé, elle fait appel à la méthode 'ajouter un membre dans
	 * l'équipe' de la classe Projet.
	 * 
	 * L'ajout de l'employé dans le projet ne doit pas être fait si une des deux (2)
	 * règles suivantes est vraie: - L'employé 'emp' est déjà ajouté dans ce projet
	 * (un même employé ne peut pas être ajouté deux (2) fois dans le même projet).
	 * - Si l'employé 'emp' à ajouter est un gestionnaire de projet, et le projet a
	 * déjà un gestionnaire de projet (on ne veut pas avoir 2 gestionnaires de
	 * projet dans un même projet).
	 * 
	 * @param projetId l'identifiant du projet dans lequel l'employé est ajouté
	 * @param emp      l'employé à ajouter
	 * @return vrai si l'employé est ajouté, sinon faux
	 */
	public boolean ajouterEmployeProjet(int projetId, Employe emp) 
	{

		ProjetInformatique projet = null;
		
		for (ProjetInformatique pro : projets) {
			if (pro.getIdentifiant() == projetId) {
				projet = pro;
			
				break;

			}
		}

		if (projet == null) {
			return false;
		}

		if (projet.estAssigneEmploye(emp)) {
			return false;
		}

		if (emp.getPoste().equalsIgnoreCase(GP) && projet.estAssigneGestionnaireProjet()) {
			return false;
		}

		if (projet.ajouterMembre(emp)) {
			return true;
		}

		
		return false;
	}
	
	
	
	

	/**
	 * Cette méthode retire l'employé passé en paramètre (emp) dans le projet dont
	 * l'identifiant (projetId) est aussi passé en paramètre.
	 * 
	 * Elle retourne vrai si l'employé est retiré avec succès, sinon faux.
	 * 
	 * @param projetId l'identifiant du projet dans lequel l'employé est retiré
	 * @param emp      l'employé à retirer
	 * @return vrai si l'employé est retiré avec succès, sinon faux
	 */
	public boolean retirerEmployeProjet(int projetId, Employe emp) 
	{

		ProjetInformatique projet = rechercherProjetParId(projetId);

		if (projet != null && projet.ajouterMembre(emp)) {
			projet.retirerMembre(emp);
			return true;
		}

		return false;

	}

	
	
	
	/**
	 * Cette méthode retourne la liste des employés qui ne sont pas encore assignés
	 * à un projet.
	 * 
	 * Elle retourne null si tous les employés sont assignés à des projets.
	 * 
	 * @return la liste des employés non assignés à un projet ou null
	 */
	public ArrayList<Employe> rechercherEmployesNonAssignes()
	{

		ArrayList<Employe> employesNonAssignes = new ArrayList<>();

		
		for (Employe emp : employes) {
			boolean estAssignee = false;

		
			for (ProjetInformatique projet : projets) {
				if (projet.estAssigneEmploye(emp)) {
					estAssignee = true;
					break; 
				}
			}

			if (!estAssignee) {
				employesNonAssignes.add(emp);
			}
		}

		if (employesNonAssignes.isEmpty()) {
			return null;
		}

		return employesNonAssignes;
	}

	
	
	
	/**
	 * Cette méthode retourne la liste des projets dont le type est passé en
	 * paramètre à partir de la liste des projets (attribut 'projets).
	 * 
	 * Si le type = "Web", elle retourne la liste projets Web, sinon le type est
	 * "Mobile" elle retourne la liste projets Mobile. Elle retourne null si aucun
	 * projet de ce type ne se trouve dans la liste.
	 * 
	 * @return la liste des projets dont le type est passé en passé en paramètre
	 *         sinon null si aucun projet de ce type se trouve dans la liste
	 */
	public ArrayList<ProjetInformatique> rechercherProjetsParType(String type)
	{

		ArrayList<ProjetInformatique> projetsDuType = new ArrayList<>();

		for (ProjetInformatique projet : projets) {
			if (projet.getType().equalsIgnoreCase(type)) {
				projetsDuType.add(projet);
			}
		}

		if (projetsDuType.isEmpty()) {
			return null;
		}

		return projetsDuType;

	}

	
	
	/**
	 * Cette méthode retourne la liste des employés du projet dont l'identifiant est
	 * passé en passé.
	 * 
	 * Elle retourne null s'il n'y a aucun projet avec cet identifiant.
	 * 
	 * @return la liste des employés d'un projet ou null
	 */
	public ArrayList<Employe> rechercherEmployesParProjet(int identifiant)
	{

		ProjetInformatique projet = rechercherProjetParId(identifiant);

		if (projet != null) {
			return projet.getEquipe();
		}

		return null;

	}
	
	

	@Override
	public String toString()
	{

		String chaine = "";

		for (int i = 0; i < projets.size(); i++) {
			chaine += "\n  " + projets.get(i);
		}

		return chaine;
	}

}