/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau.DAO;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import messages.metier.Message;
import messages.metier.Utilisateur;
import bureau.DAO.UtilisateurDAO;

/**
 *
 * @author Valentin De Cooman
 */
public class MessageDAO extends DAO<Message> {

    @Override
    public Message create(Message obj) throws SQLException {
        return null;
    }

    @Override
    public Message read(String chaine) throws SQLException {
        return null;
    }

    @Override
    public Message read(int i) throws SQLException {
        return null;
    }

    @Override
    public Message update(Message obj) throws SQLException {
        return null;
    }

    @Override
    public void delete(Message obj) throws SQLException {
        String req = "delete from api_infos where idmsg= ?";
        String req2 = "delete from api_message where idmsg= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdmsg());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("Aucune ligne n'a été effacée dans infos");
            }
            try (PreparedStatement pstm2 = dbConnect.prepareStatement(req2)){
                pstm2.setInt(1, obj.getIdmsg());
            int n2 = pstm2.executeUpdate();
            if (n2 == 0) {
                throw new SQLException("Aucune ligne n'a été effacée dans messages");
            }
            }
            

        }
        
    }

    /**
     * sélection des messages envoyés par un utilisateur
     *
     * @return liste de messages
     * @param idemp id employé émetteur
     * @throws SQLException aucun message
     */
    public List<Message> search(int idemp) throws SQLException {
        List<Message> plusieurs = new ArrayList<>();
        String req = "select * from vue1 where idemett = ? ";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idemp);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idmsg = rs.getInt("IDMSG");
                    String contenu = rs.getString("CONTENU");
                    String dateenvoi = rs.getString("DATEENVOI");
                    int idemett = rs.getInt("IDEMETT");
                    String dest = rs.getString("DEST");
                    plusieurs.add(new Message(idmsg, contenu, dateenvoi, idemett,dest));
                }

                if (!trouve) {
                    throw new SQLException("Aucun message !");
                } else {
                    return plusieurs;
                }
            }
        }
    }

    /**
     * sélection des messages reçus par un utilisateur
     *
     * @return liste de messages
     * @param matr matricule destinataire
     * @throws SQLException aucun message
     */
    public List<Message> searchrec(String matr) throws SQLException {
        List<Message> plusieurs = new ArrayList<>();
        String req = "select * from vue1 where dest = ? ";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, matr);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    String contenu = rs.getString("CONTENU");
                    String date = rs.getString("DATEENVOI");
                    String dest = rs.getString("DEST");
                    String emett = rs.getString("EMETT");
                    plusieurs.add(new Message(contenu,date,dest,emett));
                }

                if (!trouve) {
                    throw new SQLException("Aucun message !");
                } else {
                    return plusieurs;
                }
            }
        }
    }

    /**
     * sélection des messages envoyés ou reçus par un utilisateur
     *
     * @return liste de messages
     * @param obj objet de type utilisateur
     * @throws SQLException aucun message
     */
    public List<Message> search(Utilisateur obj) throws SQLException {
        List<Message> plusieurs = new ArrayList<>();
        String req = "select * from vue3 where idemett = ? OR iddest = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, obj.getIdemp());
            pstm.setInt(2, obj.getIdemp());
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idmsg = rs.getInt("IDMSG");
                    int idemett = rs.getInt("IDEMETT");
                    int iddest = rs.getInt("IDDEST");
                    plusieurs.add(new Message(idmsg, idemett, iddest));
                }

                if (!trouve) {
                    throw new SQLException("Aucun message !");
                } else {
                    return plusieurs;
                }
            }
        }
    }
}
