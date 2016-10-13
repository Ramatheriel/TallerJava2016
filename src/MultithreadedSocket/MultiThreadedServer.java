/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package MultithreadedSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Ricardo
 */
public class MultiThreadedServer 
{
    public static final int port = 1999;
    
    public static void main(String[] args)
    {
        try {
            ServerSocket ss = new ServerSocket(port);
            Socket connection;
            while(true)
            {
                System.out.println("Servidor esperando conexiones");
                connection = ss.accept();
                System.out.println("el servidor recibió una petición");
                ProcessRequest request = new ProcessRequest(connection);
                Thread t = new Thread(request);
                t.start();
            }
        } catch (IOException ex) 
        {
            
        }
        
        
    }
    
}
