/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
public class SocketServer 
{
    public static ServerSocket server;
    public static Socket connection;
    protected final static int port = 19999;
    public static StringBuffer mensaje;
    
    public static void main(String[] args) 
    {
        int caracter;
        System.out.println("Soy el server y estoy esperando un cliente");
        try {            
            server = new ServerSocket(port);
            while(true)
            {
                connection = server.accept();
                System.out.println("Acepte una conexion");
                BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
                InputStreamReader isr = new InputStreamReader(bis);
                
                mensaje = new StringBuffer();
                
                while((caracter = isr.read())!= 13)
                {
                    mensaje.append((char)caracter);
                }
                System.out.println("Mensaje recibido: " + mensaje);
                String mensajeRetorno = "El servidor leyó tu mensaje: " + mensaje + (char)13;
                
                BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
                OutputStreamWriter osw = new OutputStreamWriter(bos);
                osw.write(mensajeRetorno);
                osw.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
