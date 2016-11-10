/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author administrador1
 */
public class ThreadRecibe implements Runnable{
    Socket connection;
    final Principal main;

    String mensaje;
    ObjectInputStream entrada;
    
    
    public ThreadRecibe(Socket connection, Principal main) {
        this.connection = connection;
        this.main = main;
    }           
    
    @Override
    public void run() {
        try {
            entrada = new ObjectInputStream(connection.getInputStream());
            do
            {
                mensaje = (String)entrada.readObject();
                main.mostrarMensaje(mensaje + "\n");
            }while(!mensaje.equals("Server-> terminate"));
        } catch (IOException ex) {
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThreadRecibe.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entrada.close();
            connection.close();
        } catch (IOException ex) {
            
        }
        
    }
}