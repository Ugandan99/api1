/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.metier;

import java.time.LocalDate;

/**
 *
 * @author Valentin De Cooman
 */
public class Message {

    /**
     * identifiant unique du message
     */
    protected int idmsg;
    /**
     * contenu du message
     */
    protected String contenu;
    /**
     * date d'envoi du message
     */
    protected LocalDate dateenvoi;
    /**
     * id émetteur du message
     */
    protected int idemett;
     /**
     * id du destinataire d'un message
     */
    protected int iddest;
    /**
     * constructeur par défaut
     */
    public Message() {

    }

    /**
     * constructeur paramétré
     *
     * @param idmsg identifiant du message, généré par la base de données
     * @param contenu contenu du message envoyé
     * @param dateenvoi date d'envoi du message, généré par la base de données
     * @param idemett id de l'expéditeur
     */
    public Message(int idmsg, String contenu, LocalDate dateenvoi, int idemett) {
        this.idemett = idemett;
        this.contenu = contenu;
        this.dateenvoi = dateenvoi;
    }

    /**
     * constructeur paramétré
     *
     * @param contenu contenu du message
     */
    public Message(String contenu) {
        this.contenu = contenu;
    }
    
    /**
     * constructeur paramétré
     *
     * @param idmsg identifiant du message, généré par la base de données
     * @param idemett identifiant de l'émetteur
     * @param iddest identifiant du destinataire
     */
    public Message(int idmsg, int idemett,int iddest) {
        this.idemett = idemett;
        this.iddest = iddest;
        this.idmsg = idmsg;
    }

    /**
     * setter idmsg
     *
     * @param idmsg id du message
     */
    public void setIdmsg(int idmsg) {
        this.idmsg = idmsg;
    }

    /**
     * setter contenu
     *
     * @param contenu contenu du message
     */
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    /**
     * setter date d'envoi
     *
     * @param dateenvoi date d'envoi du message
     */
    public void setDateenvoi(LocalDate dateenvoi) {
        this.dateenvoi = dateenvoi;
    }

    /**
     * setter id emetteur
     *
     * @param idemett id de l'émetteur
     */
    public void setIdemett(int idemett) {
        this.idemett = idemett;
    }

    /**
     * méthode toString
     *
     * @return informations complètes
     */
    @Override
    public String toString() {
        return "Message : " + contenu;
    }

    /**
     * getter id message
     *
     * @return l'id du message
     */
    public int getIdmsg() {
        return idmsg;
    }

    /**
     * getter contenu
     *
     * @return contenu du message
     */
    public String getContenu() {
        return contenu;
    }

    /**
     * getter date d'envoi
     *
     * @return date d'envoi du message
     */
    public LocalDate getDateenvoi() {
        return dateenvoi;
    }

    /**
     * getter id emeteur
     *
     * @return id de l'emetteur
     */
    public int getIdemett() {
        return idemett;
    }
    /**
     * getter id destinataire
     *
     * @return id du destinataire
     */
    public int getIddest() {
        return iddest;
    }
    /**
     * setter id destinataire
     *
     * @param iddest id du destinataire
     */
    public void setIddest(int iddest) {
        this.iddest = iddest;
    }
    
}
