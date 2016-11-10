/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundoParcial;

import chatservidor.*;
import java.awt.BorderLayout;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author administrador1
 */
public class ServerPrincipal extends JFrame {
    JTextField campoTexto;
    JTextArea areaTexto;
    static ServerSocket server;
    static Socket connection;
    Connection con = null;
    static Statement s;
    static int port = 19999;
    
    static ServerPrincipal main;

    public ServerPrincipal() 
    {        
        super("Servidor");
        campoTexto = new JTextField();
        add(campoTexto, BorderLayout.NORTH);        
        
        areaTexto = new JTextArea();
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        
        setSize(300, 300);
        setVisible(true);
        
        try {
            conectar();
        } catch (InstantiationException ex) {
            System.out.println("instatiantion exception");
        } catch (IllegalAccessException ex) {
            System.out.println("IllegalAccessException");
        }
    }
    
    public void mostrarMensaje(String mensaje)
    {
        areaTexto.append(mensaje);
    }
       
    public static void main(String[] args) {
        main = new ServerPrincipal();       
        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            server = new ServerSocket(19999);
            main.mostrarMensaje("Servidor esperando cliente de chat");
            while (true) {
                connection = server.accept();
                main.mostrarMensaje("conectado a " + connection.getInetAddress().getHostName());
                executor.execute(new ServerRecibe(connection, main, s));
                executor.execute(new ServerEnvia(connection, main));
            }
        } catch (IOException ex) {

        }
        executor.shutdown();
    }
    
    public void conectar() throws InstantiationException, IllegalAccessException
    {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            Statement s = con.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("class not found exception");
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
    }
    
    
}