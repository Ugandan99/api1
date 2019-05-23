/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Message {

    protected String exp;
    protected String contenu;
    protected int id;
    protected String date_envoi;
    protected List<Utilisateur> dest = new ArrayList();

    private Message(MessageBuilder mb) {
        this.exp = mb.exp;
        this.contenu = mb.contenu;
        this.id = mb.id;
        this.date_envoi = mb.date_envoi;
        this.dest = mb.dest;
    }

    public String getExp() {
        return exp;
    }

    public String getContenu() {
        return contenu;
    }

    public int getId() {
        return id;
    }

    public String getDate_envoi() {
        return date_envoi;
    }

    public List<Utilisateur> getDest() {
        return dest;
    }

    public static class MessageBuilder {

        protected String exp;
        protected String contenu;
        protected int id;
        protected String date_envoi;
        protected List<Utilisateur> dest = new ArrayList();

        public MessageBuilder setExp(String exp) {
            this.exp = exp;
            return this;
        }

        public MessageBuilder setContenu(String contenu) {
            this.contenu = contenu;
            return this;
        }

        public MessageBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public MessageBuilder setDate_envoi(String date_envoi) {
            this.date_envoi = date_envoi;
            return this;
        }

        public MessageBuilder setDest(List dest) {
            this.dest = dest;
            return this;
        }

        public Message build() throws Exception {
            if (exp == null || contenu == null || date_envoi == null || dest == null) {
                throw new Exception("Informations de construction incomplètes");
            }
            return new Message(this);
        }
    }

    @Override
    public String toString() {
        return "Message{" + "exp=" + exp + ", contenu=" + contenu + ", id=" + id + ", date_envoi=" + date_envoi + ", \ndest= " + dest + '}';
    }

}
