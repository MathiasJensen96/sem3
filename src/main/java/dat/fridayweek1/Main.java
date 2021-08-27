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

    public static User userDetails(int id) throws ClassNotFoundException {

        User user = null;
        try {
            Connection con = Connector.connection();

            String sql = "SELECT * FROM usertable WHERE id = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getString("pw"), rs.getString("phone"), rs.getString("address"));

            }

        } catch (SQLException e) {

        }
        return user;
    }

    public static String editDetails(String info, String update, int id) throws ClassNotFoundException, SQLException {

        String updatedInfo = "";
        try (Connection con = Connector.connection()) {
            String sql = "UPDATE usertable SET ? = ? WHERE id = ?;";

            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, info);
                ps.setString(2, update);
                ps.setInt(3, id);
                ps.executeUpdate();
            } catch (SQLException ex) {

            }
            try {
                String sql2 = "SELECT ? FROM usertable WHERE id = ?;";
                PreparedStatement ps = con.prepareStatement(sql2);
                ps.setString(1, info);
                ps.setInt(2, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    updatedInfo = rs.getString(info);
                }

            } catch (SQLException e) {
            }
        }
        return updatedInfo;
    }
}