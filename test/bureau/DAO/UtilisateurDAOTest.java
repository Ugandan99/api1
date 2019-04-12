/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau.DAO;

import static bureau.DAO.BureauDAOTest.dbConnect;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import messages.metier.Bureau;
import messages.metier.Utilisateur;
import bureau.DAO.UtilisateurDAO;
import myconnections.DBConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */
public class UtilisateurDAOTest {

    static Connection dbConnect;

    public UtilisateurDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("Erreur de connexion");
            System.exit(1);
        }
    }

    @AfterClass
    public static void tearDownClass() {
        DBConnection.closeConnection();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class UtilisateurDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        //Création d'un bureau
        Bureau obj = new Bureau(0, "TestSigle", "TestTel", "TestDesc");
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        Bureau result = instance.create(obj);
        //Création d'un employé dans ce bureau
        Utilisateur obj2 = new Utilisateur(0, "MatrTest", "TestNom", "TestPrenom", result.getIdbur());
        UtilisateurDAO instance2 = new UtilisateurDAO();
        instance2.setConnection(dbConnect);
        Utilisateur expResult2 = new Utilisateur(0, "MatrTest", "TestNom", "TestPrenom", result.getIdbur());
        Utilisateur result2 = instance2.create(obj2);
        assertEquals("Matricules différents", expResult2.getMatricule(), result2.getMatricule());
        assertEquals("Noms différents", expResult2.getNom(), result2.getNom());
        assertEquals("Prénoms différents", expResult2.getPrenom(), result2.getPrenom());
        assertEquals("Id du bureau différent", expResult2.getIdbur(), result2.getIdbur());
        assertNotEquals("Id non généré", expResult2.getIdemp(), result2.getIdemp());

        Utilisateur obj3 = new Utilisateur(0, "MatrTest", "TestNom2", "TestPrenom2", result.getIdbur());
        try {
            Utilisateur result3 = instance2.create(obj3);
            fail("Exception de matricule identique non déclenchée");
            instance2.delete(result3);
        } catch (SQLException e) {
        }

        Utilisateur obj4 = new Utilisateur(0, "MatrTest2", "TestNom", "TestPrenom", result.getIdbur());
        try {
            Utilisateur result4 = instance2.create(obj3);
            fail("Exception de doublon nom-prénom non déclenchée");
            instance2.delete(result4);
        } catch (SQLException e) {
        }
        instance2.delete(result2);
        instance.delete(result);
    }

    /**
     * Test of read method, of class UtilisateurDAO.
     */
    @Test
    public void testRead_int() throws Exception {
        System.out.println("read int");
        //Création d'un bureau
        Bureau obj = new Bureau(0, "TestSigle", "TestTel", "TestDesc");
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        Bureau result = instance.create(obj);
        //Création d'un employé dans ce bureau
        Utilisateur obj2 = new Utilisateur(0, "MatrTest", "TestNom", "TestPrenom", result.getIdbur());
        UtilisateurDAO instance2 = new UtilisateurDAO();
        instance2.setConnection(dbConnect);
        obj2 = instance2.create(obj2);
        int idutil = obj2.getIdemp();
        Utilisateur result2 = instance2.read(idutil);
        assertEquals("Matricules différents", result2.getMatricule(), result2.getMatricule());
        assertEquals("Noms différents", result2.getNom(), result2.getNom());
        assertEquals("Prénoms différents", result2.getPrenom(), result2.getPrenom());
        assertEquals("Id du bureau différent", result2.getIdbur(), result2.getIdbur());
        try {
            result = instance.read(0);
            fail("Exception d'id inconnu non généré");
        } catch (SQLException e) {
        }
        instance2.delete(obj2);
        instance.delete(result);
    }

    /**
     * Test of update method, of class UtilisateurDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        //Création d'un bureau
        Bureau obj = new Bureau(0, "TestSigle", "TestTel", "TestDesc");
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        Bureau result = instance.create(obj);
        //Création d'un employé dans ce bureau
        Utilisateur obj2 = new Utilisateur(0, "MatrTest", "TestNom", "TestPrenom", result.getIdbur());
        UtilisateurDAO instance2 = new UtilisateurDAO();
        instance2.setConnection(dbConnect);
        obj2 = instance2.create(obj2);
        obj2.setMatricule("MatrTest2");
        Utilisateur expResult = obj2;
        Utilisateur result2 = instance2.update(obj2);
        assertEquals(expResult.getMatricule(), result2.getMatricule());
        instance2.delete(obj2);
        instance.delete(result);

    }

    /**
     * Test of delete method, of class UtilisateurDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        //Création d'un bureau
        Bureau obj = new Bureau(0, "TestSigle", "TestTel", "TestDesc");
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        Bureau result = instance.create(obj);
        //Création d'un employé dans ce bureau
        Utilisateur obj2 = new Utilisateur(0, "MatrTest", "TestNom", "TestPrenom", result.getIdbur());
        UtilisateurDAO instance2 = new UtilisateurDAO();
        instance2.setConnection(dbConnect);
        obj2 = instance2.create(obj2);
        instance2.delete(obj2);
        try {
            instance2.read(obj2.getIdbur());
            fail("Exception de record introuvable non générée");
        } catch (SQLException e) {
        }
        instance.delete(result);
    }

    /**
     * Test of read method, of class UtilisateurDAO.
     */
    @Test
    public void testRead_String() throws Exception {
        System.out.println("read String");
        //Création d'un bureau
        Bureau obj = new Bureau(0, "TestSigle", "TestTel", "TestDesc");
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        Bureau result = instance.create(obj);
        //Création d'un employé dans ce bureau
        Utilisateur obj2 = new Utilisateur(0, "MatrTest", "TestNom", "TestPrenom", result.getIdbur());
        UtilisateurDAO instance2 = new UtilisateurDAO();
        instance2.setConnection(dbConnect);
        obj2 = instance2.create(obj2);
        String matricule = "MatrTest";
        Utilisateur result2 = instance2.read(matricule);
        assertEquals("Matricules différents", result2.getMatricule(), result2.getMatricule());
        assertEquals("Noms différents", result2.getNom(), result2.getNom());
        assertEquals("Prénoms différents", result2.getPrenom(), result2.getPrenom());
        assertEquals("Id du bureau différent", result2.getIdbur(), result2.getIdbur());
        instance2.delete(obj2);
        instance.delete(result);
    }

    /**
     * Test of search method, of class UtilisateurDAO.
     */
    @Test
    public void testSearch() throws Exception {
        //Création d'un bureau
        Bureau obj = new Bureau(0, "TestSigle", "TestTel", "TestDesc");
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        Bureau result = instance.create(obj);
        //Création d'un employé dans ce bureau
        Utilisateur obj2 = new Utilisateur(0, "MatrTest", "TestNom", "TestPrenom", result.getIdbur());
        UtilisateurDAO instance2 = new UtilisateurDAO();
        instance2.setConnection(dbConnect);
        obj2 = instance2.create(obj2);
        String siglerech = "TestSigle";
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        obj2 = instance2.create(obj2);
        List<Utilisateur> liste = instance2.search(siglerech);
        instance.delete(obj);
        instance2.delete(obj2);

        if (liste.indexOf(obj2) < 0) {
            fail("Record introuvable " + obj2);
        }
        if (liste.indexOf(obj) < 0) {
            fail("Record introuvable" + obj);
        }
    }

}
