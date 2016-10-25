/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package JDBC;

import java.lang.Integer;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
public class FirstConnection 
{
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            
            con = Driver.Manager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            Statement s = con.CreteStatement();
            ResultSet rs = s.executeQuery("select * from personas");
            
            while(rs.next())
            {
                System.out.println("id: " + rs.getInt(1));
                System.out.println("Nombre: " + rs.getString(2));
                System.out.println("Apellido: " + rs.getString(3));
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("class not found exception ");
        } catch (InstantiationException ex) {
            System.out.println("instantiation exception");
        } catch (IllegalAccessException ex) {
            System.out.println("illegal access exception");
        }
        catch(SQLException ex)
        {
            System.out.println(ex.toString());
        }
    }
    
}
