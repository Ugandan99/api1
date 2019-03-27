/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau.DAO;

/**
 * classe de mappage poo-relationnel client
 *
 * @author Valentin De Cooman
 * @version 1.0
 * @see Bureau
 */
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import messages.metier.Bureau;


public class BureauDAO extends DAO<Bureau> {
    
    /**
     * création d'un bureau sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj bureau à créer
     * @return bureau créé
     */
    @Override
    public Bureau create(Bureau obj)throws SQLException {
        String req1 = "insert into api_bureau(sigle,tel,description) values(?,?,?)";
        String req2 = "select idbur from api_bureau where sigle=? and tel=? and description=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getSigle());
            pstm1.setString(2, obj.getTel());
            pstm1.setString(3, obj.getDescription());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("Ereur de crétation de bureau, aucune ligne créée");
            }
            pstm2.setString(1, obj.getSigle());
            pstm2.setString(2, obj.getTel());
            pstm2.setString(3, obj.getDescription());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idbur = rs.getInt(1);
                    obj.setIdbur(idbur);
                    return read(idbur);
                } else {
                    throw new SQLException("Erreur de création de bureau, la ligne n'a pas été créée");
                }
            }
        }
        
    }
    
    /**
     * récupération des informations sur un bureau avec son id
     *
     * @throws SQLException id inconnu
     * @param idbur identifiant du bureau
     * @return bureau trouvé
     */
    @Override
    public Bureau read(int idbur)throws SQLException {
        String req = "select * from api_bureau where idbur = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idbur);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String sigle = rs.getString("SIGLE");
                    String tel = rs.getString("TEL");
                    String description = rs.getString("DESCRIPTION");
                    return new Bureau(idbur, sigle, tel, description);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }
    
     /**
     * modification des informations d'un bureau
     *
     * @throws SQLException erreur de mise à jour
     * @param obj bureau à modifier
     * @return bureau modifier
     */
    @Override
    public Bureau update(Bureau obj)throws SQLException {
        
                String req = "update api_bureau set sigle= ?, tel = ? , description = ? where idbur= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(4, obj.getIdbur());
            pstm.setString(1, obj.getSigle());
            pstm.setString(2, obj.getTel());
            pstm.setString(3, obj.getDescription());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("Erreur : aucune ligne n'a été mise à jour");
            }
            return read(obj.getIdbur());
        }
    }
    
     /**
     * suppression d'un bureau 
     *
     * @throws SQLException erreur de suppression
     * @param obj bureau a supprimer
     */
    @Override
    public void delete(Bureau obj)throws SQLException {
        String req = "delete from api_bureau where idbur= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdbur());
            int n = pstm.executeUpdate();
            //System.out.println(n);
            if (n == 0) {
                throw new SQLException("Aucun bureau n'a été effacé");
            }

        }
        
    }
    
    /**
     * recherche d'un bureau sur base de sa description
     *
     * @throws SQLException aucun bureau trouvé
     * @param rech partie de la description
     * @return bureau trouvé
     */
    public List <Bureau> search(String rech)throws SQLException {
        List<Bureau> plusieurs = new ArrayList<>();
        String req = "select * from api_bureau where description like ? ";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%"+rech+"%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idbur = rs.getInt("IDBUR");
                    String sigle = rs.getString("SIGLE");
                    String tel = rs.getString("TEL");
                    String description = rs.getString("DESCRIPTION");
                    
                    plusieurs.add(new Bureau(idbur, sigle, tel, description));
                }

                if (!trouve) {
                    throw new SQLException("Aucun bureau !");
                } else {
                    return plusieurs;
                }
            }
        }
    }
    
    
    
    
    
}
