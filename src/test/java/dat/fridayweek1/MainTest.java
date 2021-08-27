/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.fridayweek1;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mathiasjensen
 */
public class MainTest {

    public MainTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void userNamesOnlyTest() throws SQLException, ClassNotFoundException {

        ArrayList<String> expected = new ArrayList<>();
        expected.add("Henning");
        expected.add("Hannah");
        expected.add("Amin");
        expected.add("Harun");
        ArrayList<String> actual = Main.getAllUserNames();
        assertEquals(expected, actual);
    }
    
    @Test
    public void userDetailsTest() throws ClassNotFoundException{
        
        User user = new User(1, "Henning", "Dahl", "sdfw333", "+4540949403", "Rolighedsvej 22, 2100 Kbh Ø");
        
        String expected = Integer.toString(user.getId()) + " " + user.getFname() + " " + user.getLname() + " " + user.getPw() + " " + user.getPhone() + " " + user.getAddress();
        String actual = Main.userDetails(1).toString();
        assertEquals(expected, actual);
    }
    
    @Test
    public void editOwnDetailsTest() throws ClassNotFoundException, SQLException {
        
        String info = "lname";
        String update = "Thomsen";
        String expected = "Jensen";
        String actual = Main.editDetails(info, update, 1);
        assertEquals(expected, actual);
    }

}
