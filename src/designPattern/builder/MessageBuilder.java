/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPattern.builder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class MessageBuilder {

    public static void main(String[] args) {
        try {
            Utilisateur u1 = new Utilisateur.UtilisateurBuilder().setId(1).setIdbur(1).setMatr("Matr").setNom("Nom").setPrenom("Prenom").
                    build();
            Utilisateur u2 = new Utilisateur.UtilisateurBuilder().setId(2).setIdbur(1).setMatr("Matr2").setNom("Nom2").setPrenom("Prenom2").
                    build();
            Utilisateur u3 = new Utilisateur.UtilisateurBuilder().setId(3).setIdbur(1).setMatr("Matr3").setNom("Nom3").setPrenom("Prenom3").
                    build();
            List<Utilisateur> dest = new ArrayList();
            dest.add(u1);
            dest.add(u2);
            dest.add(u3);
            String dateactu;
            DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            dateactu = (format.format(date));
            System.out.println(dateactu);
            Message m1 = new Message.MessageBuilder().setContenu("Exemple de message").setDate_envoi(dateactu).setDest(dest).setExp("Jean").setId(1).
                    build();
            System.out.println(m1);
        } catch (Exception e) {
            System.out.println("erreur " + e);
        }
        try {
            Message m1 = new Message.MessageBuilder().setContenu("Exemple de message").setExp("Jean").setId(1).
                    build();
            System.out.println(m1);
        } catch (Exception e) {
            System.out.println("erreur " + e);
        }

    }

}
