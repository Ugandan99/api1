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
import messages.metier.Message;
import messages.metier.Utilisateur;
import bureau.DAO.UtilisateurDAO;
import messages.metier.Infos;
import bureau.DAO.InfosDAO;
import bureau.DAO.MessageDAO;
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
    BureauDAO Bur;
    Utilisateur UtilActuel = null;
    DAO<Utilisateur> UtilDAO = null;
    Message MessActuel = null;
    DAO<Message> MessDAO = null;
    Infos InfActuel = null;
    DAO<Infos> InfDAO = null;

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
        MessDAO = new MessageDAO();
        MessDAO.setConnection(dbConnect);
        UtilDAO = new UtilisateurDAO();
        UtilDAO.setConnection(dbConnect);
        InfDAO = new InfosDAO();
        InfDAO.setConnection(dbConnect);

        int ch = 0;
        do {
            System.out.println("***********************************************"
                    + "\n1.Nouveau bureau \n2.Recherche bureau id\n3.Modifier tel bureau\n4.Supprimer bureau"
                    + "\n5.Recherche sur description\n6.Afficher les messages envoyés avec id utilisateur"
                    + "\n7.Afficher les messages envoyés à un utilisateur avec matricule"
                    + "\n8.Afficher utilisateurs en encodant sigle bureau \n9.Ajouter un employé"
                    + "\n10.Afficher info employé avec matricule \n11.Changer le bureau d'un employé"
                    + "\n12.Supprimer un employé\n13.Fin\n***********************************************");
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
                    affenv();
                    break;
                case 7:
                    affrec();
                    break;
                case 8:
                    affemp();
                    break;
                case 9:
                    creeremp();
                    break;
                case 10:
                    affempmatr();
                    break;
                case 11:
                    modifemp();
                    break;
                case 12:
                    suppemp();
                    break;    
                case 13:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("\nErreur");
            }

        } while (ch != 12);
        DBConnection.closeConnection();
    }
    
    public void suppemp(){
        try {
            System.out.println("Entrez l'id de l'employé à supprimer :");
            int n1 = sc.nextInt();
            sc.skip("\n");
            UtilActuel = new Utilisateur(n1, null, null, null, 0);
            UtilDAO.delete(UtilActuel);
            
        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }
        
    }

    public void modifemp() {
        try {
            System.out.println("Entrez le matricule de l'employé pour le changer de bureau :");
            String matr = sc.nextLine();
            UtilActuel = UtilDAO.read(matr);
            System.out.println("Entrez le sigle du nouveau bureau");
            String sigle = sc.nextLine();
            try {
                BurActuel = ((BureauDAO) BurDAO).rechsigle(sigle);
                int idbur = BurActuel.getIdbur();
                UtilActuel.setIdbur(idbur);
                UtilDAO.update(UtilActuel);
                System.out.println("Transaction effectuée");
            } catch (SQLException e) {
                System.out.println("Erreur " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }

    }

    public void affempmatr() {
        try {
            System.out.println("Entrez le matricule de l'employé :");
            String matr = sc.nextLine();
            UtilActuel = UtilDAO.read(matr);
            System.out.println("Employé " + UtilActuel);

        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }

    }

    public void creeremp() {
        System.out.print("Matricule de l'employé :");
        String matr = sc.nextLine();
        System.out.print("Nom de l'employé :");
        String nom = sc.nextLine();
        System.out.print("Prénom de l'employé : ");
        String pre = sc.nextLine();
        System.out.print("Sigle du bureau : ");
        String sigle = sc.nextLine();
        System.out.println(sigle);
        try {
            BurActuel = ((BureauDAO) BurDAO).rechsigle(sigle);
            int idbur = BurActuel.getIdbur();
            UtilActuel = new Utilisateur(0, matr, nom, pre, idbur);
            try {
                UtilActuel = UtilDAO.create(UtilActuel);
                System.out.println("Employé créé : " + UtilActuel);
            } catch (SQLException e) {
                System.out.println("Erreur : " + e);
            }

        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
            System.out.println("\nTransaction refusée");
        }

    }

    public void affemp() {
        System.out.println("Entrez le sigle du bureau : ");
        String sigle = sc.nextLine();
        try {
            List<Utilisateur> alc = (List<Utilisateur>) ((UtilisateurDAO) UtilDAO).search(sigle);
            for (Utilisateur ul : alc) {
                System.out.println(ul);
            }
        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }
    }

    public void affrec() {
        System.out.println("Entrez le matricule pour avoir les messages reçus : ");
        String matr = sc.nextLine();
        int cpt = 0;
        try {
            List<Message> alc = (List<Message>) ((MessageDAO) MessDAO).searchrec(matr);
            for (Message ml : alc) {
                cpt++;
                System.out.println("Message " + cpt + " : " + ml.getContenu());

            }
        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }
    }

    public void affenv() {
        System.out.println("\nEntrez l'id employé pour avoir les messages envoyés : ");
        int idemp = sc.nextInt();
        sc.skip("\n");
        try {
            List<Message> alc = ((MessageDAO) MessDAO).search(idemp);
            for (Message ml : alc) {
                System.out.println(ml);
            }
        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }
    }

    public void rechdesc() {
        System.out.println("Entrez une partie de la description du bureau : ");
        String desc = sc.nextLine();
        try {
            List<Bureau> alc = (List<Bureau>) ((BureauDAO) BurDAO).search(desc);
            for (Bureau bl : alc) {
                System.out.println(bl);
            }
        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }
    }

    public void supp() {
        try {
            System.out.println("! le bureau à supprimer doit etre vide !");
            System.out.println("Entrez l'id du bureau  :");
            int n1 = sc.nextInt();
            sc.skip("\n");
            try {
                BurActuel = BurDAO.read(n1);
            } catch (SQLException a) {
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
            sc.skip("\n");
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
