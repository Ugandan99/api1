/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.metier;

/**
 * Classe métier de gestion des bureaux
 *
 * @author Valentin De Cooman
 * @version 1.0
 */
public class Bureau {

    /**
     * identifiant unique du bureau
     */
    protected int idbur;
    /**
     * sigle du bureau
     */
    protected String sigle;
    /**
     * numero de tel du bureau
     */
    protected String tel;
    /**
     * description du bureau
     */
    protected String description;

    /**
     * constructeur par défaut
     */
    public Bureau() {

    }

    /**
     * constructeur paramétré
     *
     * @param idbur identifiant unique du bureau, affecté par la base de données
     * @param sigle sigle du bureau
     * @param tel numero de tel du bureau
     * @param description brève description du bureau
     */
    public Bureau(int idbur, String sigle, String tel, String description) {
        this.idbur = idbur;
        this.sigle = sigle;
        this.tel = tel;
        this.description = description;
    }

    /**
     * getter idbur
     *
     * @return identifiant du bureau
     */
    public int getIdbur() {
        return idbur;
    }

    /**
     * getter sigle
     *
     * @return sigle du bureau
     */
    public String getSigle() {
        return sigle;
    }

    /**
     * getter tel
     *
     * @return numéro de téléphone du bureau
     */
    public String getTel() {
        return tel;
    }

    /**
     * getter description
     *
     * @return description du bureau
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter idbur
     *
     * @param idbur identifiant du bureau
     */
    public void setIdbur(int idbur) {
        this.idbur = idbur;
    }

    /**
     * setter sigle
     *
     * @param sigle sigle du bureau
     */
    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    /**
     * setter tel
     *
     * @param tel numéro du téléphone du bureau
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * setter description
     *
     * @param description description du bureau
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * méthode toString
     *
     * @return informations complètes
     */
    @Override
    public String toString() {
        return "Bureau{" + "idbur=" + idbur + ", sigle=" + sigle + ", tel=" + tel + ", description=" + description + '}';
    }
}
