/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundoParcial;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author administrador1
 */
public class ClientePrincipal extends JFrame{
    JTextField campoTexto;
    JTextArea areaTexto;    
    static Socket connection;
    static int port = 19999;
    
    static ClientePrincipal main;

    public ClientePrincipal() 
    {
        super("Cliente");
        this.setTitle("Cliente");
        campoTexto = new JTextField();
        add(campoTexto, BorderLayout.NORTH);        
        
        areaTexto = new JTextArea();
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        
        setSize(300, 300);
        setVisible(true);
    }
    
    public void mostrarMensaje(String mensaje)
    {
        areaTexto.append(mensaje);
    }
       
    public static void main(String[] args) {
       main = new ClientePrincipal();       
        ExecutorService executor = Executors.newCachedThreadPool();
        try {            
            main.mostrarMensaje("buscando servidor");            
            connection = new Socket(InetAddress.getByName("10.20.3.127"), port);
            main.mostrarMensaje("conectado a " + connection.getInetAddress().getHostName()+"\n");
            executor.execute(new ClienteRecibe(connection, main));
            executor.execute(new ClienteEnvia(connection, main));
            
        } catch (IOException ex) {

        }
        executor.shutdown();
    }
}