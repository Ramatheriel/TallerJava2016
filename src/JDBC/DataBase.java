/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author administrador1
 */
public class DataBase {
    public static void main(String[] args) {
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost/test:3306", "ariel", "lucien");
            
            /*Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from personas");
            while(rs.next())
            {
                System.out.println(rs.getInt(0) + rs.getString(1));
            } */           
        } catch (ClassNotFoundException ex) {
            System.out.println("class not found");
        } catch (InstantiationException ex) {
            System.out.println("instantiation exce");
        } catch (IllegalAccessException ex) {
            System.out.println("illegaraccess");
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }            
}