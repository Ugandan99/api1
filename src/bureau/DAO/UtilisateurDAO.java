/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau.DAO;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import messages.metier.Utilisateur;

/**
 *
 * @author Valentin De Cooman
 */
import messages.metier.Message;
import messages.metier.Utilisateur;


public class UtilisateurDAO extends DAO<Utilisateur> {

    /**
     * création d'un utilisateur sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj utilisateur à créer
     * @return utilisateur créé
     */
    @Override
    public Utilisateur create(Utilisateur obj) throws SQLException {
        String req1 = "insert into api_employe(matricule,nom,prenom,idbur) values(?,?,?,?)";
        String req2 = "select idemp from api_employe where matricule=? and nom=? and prenom=? and idbur=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getMatricule());
            pstm1.setString(2, obj.getNom());
            pstm1.setString(3, obj.getPrenom());
            pstm1.setInt(4, obj.getIdbur());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("Ereur de crétation d'employé, aucune ligne créée");
            }
            pstm2.setString(1, obj.getMatricule());
            pstm2.setString(2, obj.getNom());
            pstm2.setString(3, obj.getPrenom());
            pstm2.setInt(4, obj.getIdbur());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idemp = rs.getInt(1);
                    obj.setIdemp(idemp);
                    return read(idemp);
                } else {
                    throw new SQLException("Erreur de création d'employé, la ligne n'a pas été créée");
                }
            }
        }
    }

    /**
     * récupération des informations sur un utilisateur avec son id
     *
     * @throws SQLException id inconnu
     * @param i identifiant de l'utilisateur
     * @return utilisateur trouvé
     */
    @Override
    public Utilisateur read(int i) throws SQLException {
        String req = "select * from api_employe where idemp = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, i);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    int idemp = rs.getInt("IDEMP");
                    String matricule = rs.getString("MATRICULE");
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    int idbur = rs.getInt("IDBUR");
                    return new Utilisateur(idemp, matricule, nom, prenom, idbur);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }

    /**
     * modification des informations d'un utilisateur
     *
     * @throws SQLException erreur de mise à jour
     * @param obj utilisateur à modifier
     * @return utilisateur modifié
     */
    @Override
    public Utilisateur update(Utilisateur obj) throws SQLException {
        String req = "update api_employe set matricule= ?, nom = ? , prenom = ? , idbur = ? where idemp= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, obj.getMatricule());
            pstm.setString(2, obj.getNom());
            pstm.setString(3, obj.getPrenom());
            pstm.setInt(4, obj.getIdbur());
            pstm.setInt(5, obj.getIdemp());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("Erreur : aucune ligne n'a été mise à jour");
            }
            return read(obj.getIdemp());
        }
    }

    @Override
    public void delete(Utilisateur obj) throws SQLException {
        DAO<Message> MessDAO = null;
        MessDAO = new MessageDAO();
        MessDAO.setConnection(dbConnect);
        try {
            List<Message> alc = (List<Message>) ((MessageDAO) MessDAO).search(obj);
            for (Message ul : alc) {
                MessDAO.delete(ul);
            }
        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }
        String req = "delete from api_employe where idemp= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdemp());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("Aucun employé n'a été viré");
            }

        }
        catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }
    }

    /**
     * lecture d'un utilisateur en fonction de son matricule
     *
     * @throws SQLException aucun bureau ne correspond
     * @param matr matricule de l'utilisateur
     * @return utilisateur concerné
     */
    @Override
    public Utilisateur read(String matr) throws SQLException {
        String req = "select * from api_employe where matricule like ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, matr);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    int idemp = rs.getInt("IDEMP");
                    int idbur = rs.getInt("IDBUR");
                    String matricule = rs.getString("MATRICULE");
                    return new Utilisateur(idemp, matricule, nom, prenom, idbur);

                } else {
                    throw new SQLException("Erreur de matricule");
                }

            }
        }
    }

    /**
     * recherche des utilisateurs occupant un bureau en fonction de son sigle
     *
     * @throws SQLException aucun utilisateur
     * @param sigle sigle du bureau
     * @return la des utilisateurs
     */
    public List<Utilisateur> search(String sigle) throws SQLException {
        List<Utilisateur> plusieurs = new ArrayList<>();
        String req = "select * from vue2 where sigle like ? ";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, sigle);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");

                    plusieurs.add(new Utilisateur(nom, prenom));
                }

                if (!trouve) {
                    throw new SQLException("Aucun utilisateur !");
                } else {
                    return plusieurs;
                }
            }
        }
    }

}
