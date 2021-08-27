/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.fridayweek1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathiasjensen
 */
public class Main {

    public static void main(String[] args) {

    }

    public static ArrayList<String> getAllUserNames() throws SQLException, ClassNotFoundException {

        ArrayList<String> users = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String sql = "SELECT fname FROM usertable;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            

            while (rs.next()) {
                String name = rs.getString("fname");
                users.add(name);
            }
            return users;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
