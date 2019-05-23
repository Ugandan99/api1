/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPattern.builder;



/**
 *
 * @author USER
 */
public class Utilisateur {

    protected int id;
    protected String nom;
    protected String prenom;
    protected String matr;
    protected int idbur;

    private Utilisateur(UtilisateurBuilder ub) {
        this.id = ub.id;
        this.nom = ub.nom;
        this.prenom = ub.prenom;
        this.matr = ub.matr;
        this.idbur = ub.idbur;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMatr() {
        return matr;
    }

    public int getIdbur() {
        return idbur;
    }

    public static class UtilisateurBuilder {

        protected int id;
        protected String nom;
        protected String prenom;
        protected String matr;
        protected int idbur;

        public UtilisateurBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public UtilisateurBuilder setNom(String nom) {
            this.nom = nom;
            return this;
        }

        public UtilisateurBuilder setPrenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public UtilisateurBuilder setMatr(String matr) {
            this.matr = matr;
            return this;
        }

        public UtilisateurBuilder setIdbur(int idbur) {
            this.idbur = idbur;
            return this;
        }

        public Utilisateur build() throws Exception {
            if (nom == null || prenom == null || matr == null || idbur <= 0) {
                throw new Exception("Informations de construction incomplètes");
            }
            return new Utilisateur(this);
        }

    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", matr=" + matr + ", idbur=" + idbur + '}';
    }

}
