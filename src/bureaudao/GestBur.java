/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureaudao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import bureau.DAO.BureauDAO;
import bureau.DAO.DAO;
import messages.metier.Bureau;
import myconnections.DBConnection;

/**
 *
 * @author Valentin De Cooman
 */
public class GestBur {

    Scanner sc = new Scanner(System.in);
    Bureau BurActuel = null;
    DAO<Bureau> BurDAO = null;

    public GestBur() {

    }

    public void gestion() {
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("Connexion invalide");
            System.exit(1);
        }

        System.out.println("Connexion établie");

        BurDAO = new BureauDAO();
        BurDAO.setConnection(dbConnect);

        int ch = 0;
        do {
            System.out.println("1.Nouveau bureau \n2.Recherche bureau id\n3.Modifier tel bureau\n4.Supprimer bureau"
                    + "\n5.Recherche sur description\n6.Afficher les messages envoyés avec id utilisateur"
                    + "\n7.Afficher les messages envoyés à un utilisateur avec matricule"
                    + "\n8.Afficher utilisateurs en encodant sigle bureau \n9.Fin");
            System.out.print("choix :");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    creer();
                    break;
                case 2:
                    aff();
                    break;
                case 3:
                    modif();
                    break;
                case 4:
                    supp();
                    break;
                case 5:
                    rechdesc();
                    break;
                case 6:
                    //derncom();
                    break;
                case 7:
                    //derncom();
                    break;
                case 8:
                    //derncom();
                    break;
                case 9:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("\nErreur");
            }

        } while (ch != 9);
        DBConnection.closeConnection();
    }
    
    public void rechdesc() {
        System.out.println("Entrez une partie de la description : ");
        String desc= sc.nextLine();
        try {
            List <Bureau> alc = (List <Bureau>) ((BureauDAO) BurDAO).search(desc);
            for (Bureau bl : alc) {
               System.out.println(bl);
            }
        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }
    }

    public void supp() {
        try {
            System.out.println("Entrez l'id du bureau  :");
            int n1 = sc.nextInt();
            
            try {
                BurActuel = BurDAO.read(n1);
            }
            catch (SQLException a)
            {
                System.out.println("Erreur " + a.getMessage());
            }
            
            BurDAO.delete(BurActuel);
            
        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }
        
    }

    public void aff() {
        try {
            System.out.println("Entrez l'id du bureau :");
            int nc = sc.nextInt();
            BurActuel = BurDAO.read(nc);
            System.out.println("Bureau " + BurActuel);

        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }

    }

    public void creer() {
        System.out.print("Sigle du bureau :");
        String sigle = sc.nextLine();
        System.out.print("Numero de tel du bureau :");
        String tel = sc.nextLine();
        System.out.print("Description du bureau : ");
        String desc = sc.nextLine();
        BurActuel = new Bureau(0, sigle, tel, desc);
        try {
            BurActuel = BurDAO.create(BurActuel);
            System.out.println("Bureau actuel : " + BurActuel);
        } catch (SQLException e) {
            System.out.println("Erreur : " + e);
        }

    }

    public void modif() {
        try {
            System.out.println("Entrez l'id du bureau à modifier :");
            int id = sc.nextInt();
            sc.skip("\n");
            BurActuel = BurDAO.read(id);
            System.out.println("Entrez le nouveau num de tel");
            String nouvtel = sc.nextLine();
            BurActuel.setTel(nouvtel);
            BurDAO.update(BurActuel);
        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        GestBur g1 = new GestBur();
        g1.gestion();
    }

}
