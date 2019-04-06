/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.metier;

/**
 *
 * @author Valentin De Cooman
 */
public class Utilisateur {

    /**
     * identifiant unique de l'employé
     */
    protected int idemp;
    /**
     * matricule de l'employé
     */
    protected String matricule;
    /**
     * nom de l'utilisateur
     */
    protected String nom;
    /**
     * prénom de l'utilisateur
     */
    protected String prenom;
    /**
     * clef étrangère de l'id du bureau
     */
    protected int idbur;

    /**
     * constructeur par défaut
     */
    public Utilisateur() {

    }

    /**
     * constructeur paramétré
     *
     * @param idemp identifiant unique dde l'employé, affecté par la base de
     * données
     * @param matricule matricule de l'employé
     * @param nom nom employé
     * @param prenom prénom employé
     * @param idbur clef étrangère de l'id du bureau
     *
     */
    public Utilisateur(int idemp, String matricule, String nom, String prenom, int idbur) {
        this.idemp = idemp;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.idbur = idbur;
    }

    /**
     * constructeur paramétré
     *
     * @param nom nom employé
     * @param prenom prénom employé
     *
     */
    public Utilisateur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * setter id employé
     *
     * @param idemp id de l'employé
     */
    public void setIdemp(int idemp) {
        this.idemp = idemp;
    }

    /**
     * setter matricule
     *
     * @param matricule nouveau matricule
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     * setter nom
     *
     * @param nom nom de l'employé
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * setter prenom
     *
     * @param prenom prénom de l'employé
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * setter idbur
     *
     * @param idbur id du bureau de l'employé
     */
    public void setIdbur(int idbur) {
        this.idbur = idbur;
    }

    /**
     * getter idemp
     *
     * @return id de l'employé
     */
    public int getIdemp() {
        return idemp;
    }

    /**
     * getter matricule
     *
     * @return matricule de l'employé
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * getter nom
     *
     * @return nom de l'employé
     */
    public String getNom() {
        return nom;
    }

    /**
     * getter prenom
     *
     * @return prénom de l'employé
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * getter id bureau
     *
     * @return bureau de l'employé
     */
    public int getIdbur() {
        return idbur;
    }

    /**
     * méthode toString
     *
     * @return informations complètes
     */
    @Override
    public String toString() {
        return "Utilisateur{" + "nom=" + nom + ", prenom=" + prenom + ", matricule=" + matricule + '}';
    }

}
