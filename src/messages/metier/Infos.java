/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.metier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author USER
 */
public class Infos {

    /**
     * date de lecture du message
     */
    protected LocalDate datelecture;
    /**
     * id du message
     */
    protected int idmsg;
    /**
     * id du destinataire du message
     */
    protected int iddest;

    /**
     * constructeur par défaut
     */
    public Infos() {

    }

    /**
     * constructeur paramétré
     *
     * @param idmsg identifiant du message, généré par la base de données
     * @param iddest id du destinataire
     */
    public Infos(int idmsg, int iddest) {
        this.iddest = iddest;
        this.idmsg = idmsg;
    }

    /**
     * getter datelecture
     *
     * @return la date de lecture
     */
    public LocalDate getDatelecture() {
        return datelecture;
    }

    /**
     * getter idmsg
     *
     * @return l'id du message
     */
    public int getIdmsg() {
        return idmsg;
    }

    /**
     * getter iddest
     *
     * @return id du destinataire
     */
    public int getIddest() {
        return iddest;
    }

    /**
     * setter datelecture
     *
     * @param datelecture date de lecture
     */
    public void setDatelecture(LocalDate datelecture) {
        this.datelecture = datelecture;
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
     * setter iddest
     *
     * @param iddest identifiant du destinataire
     */
    public void setIddest(int iddest) {
        this.iddest = iddest;
    }

}
