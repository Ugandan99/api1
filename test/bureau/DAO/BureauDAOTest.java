/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import messages.metier.Bureau;
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
public class BureauDAOTest {

    static Connection dbConnect;

    public BureauDAOTest() {
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
     * Test of create method, of class BureauDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Bureau obj = new Bureau(0, "TestSigle", "TestTel", "TestDesc");
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        Bureau expResult = new Bureau(0, "TestSigle", "TestTel", "TestDesc");
        Bureau result = instance.create(obj);
        assertEquals("Sigles différents", expResult.getSigle(), result.getSigle());
        assertEquals("Tel différent", expResult.getTel(), result.getTel());
        assertEquals("Description différente", expResult.getDescription(), result.getDescription());
        assertNotEquals("Id non généré", expResult.getIdbur(), result.getIdbur());
        instance.delete(result);
    }

    /**
     * Test of read method, of class BureauDAO.
     */
    @Test
    public void testRead_int() throws Exception {
        System.out.println("read int");
        int idclient = 0;
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        Bureau obj = new Bureau(0, "TestSigle", "TestTel", "TestDesc");
        Bureau expResult = instance.create(obj);
        idclient = expResult.getIdbur();
        Bureau result = instance.read(idclient);
        assertEquals("Sigles différents", expResult.getSigle(), result.getSigle());
        assertEquals("Tel différent", expResult.getTel(), result.getTel());
        assertEquals("Description différente", expResult.getDescription(), result.getDescription());
        assertEquals("Id différents", expResult.getIdbur(), result.getIdbur());
        instance.delete(expResult);
        try {
            result = instance.read(0);
            fail("Exception d'id inconnu non généré");
        } catch (SQLException e) {
        }
    }

    /**
     * Test of update method, of class BureauDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Bureau obj = new Bureau(0, "TestSigle", "TestTel", "TestDesc");
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        obj.setSigle("TestSigle2");
        obj.setTel("TestTel2");
        obj.setDescription("TestDesc2");
        Bureau expResult = obj;
        Bureau result = instance.update(obj);
        assertEquals(expResult.getSigle(), result.getSigle());
        assertEquals(expResult.getTel(), result.getTel());
        assertEquals(expResult.getDescription(), result.getDescription());
        instance.delete(obj);

    }

    /**
     * Test of delete method, of class BureauDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Bureau obj = new Bureau(0, "TestSigle", "TestTel", "TestDesc");
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.read(obj.getIdbur());
            fail("Exception de record introuvable non générée");
        } catch (SQLException e) {
        }
        //TODO vérifier qu'on a bien une exception en cas de record parent de clé étrangère

    }

    /**
     * Test of read method, of class BureauDAO.
     */
    @Test
    public void testRead_String() throws Exception {

    }

    /**
     * Test of rechsigle method, of class BureauDAO.
     */
    @Test
    public void testRechsigle() throws Exception {
        System.out.println("rechSigle");
        Bureau obj1 = new Bureau(0, "TestSigle", "TestTel", "TestDesc");
        String nomrech = "TestSigle";
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        obj1 = instance.create(obj1);
        Bureau result = instance.rechsigle(nomrech);
        instance.delete(obj1);
        try {
            instance.read(result.getIdbur());
            fail("Exception record non trouvé non déclenchée");
        } catch (SQLException e) {
        }

    }

    /**
     * Test of search method, of class BureauDAO.
     */
    @Test
    public void testSearch() throws Exception {
        //Ne comprends pas le problème
        System.out.println("search");
        Bureau obj = new Bureau(0, "TestSigle", "TestTel", "TestDesc2");
        Bureau obj2 = new Bureau(0, "TestSigle2", "TestTel2", "TestDesc2");
        String descrech = "TestDesc2";
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        obj2 = instance.create(obj2);
        List<Bureau> result = instance.search(descrech);
        instance.delete(obj);
        instance.delete(obj2);

        for (Bureau bl : result) {
            System.out.println(bl);
        }
        if (result.indexOf(obj2) < 0) {
            fail("Record introuvable " + obj2);
        }
        if (result.indexOf(obj) < 0) {
            fail("Record introuvable" + obj);
        }
    }

}
