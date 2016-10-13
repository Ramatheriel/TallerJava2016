/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package MultithreadedSocket;

import Sockets.SocketClient;
import java.io.*;
import java.net.*;

/**
 *
 * @author Ricardo
 */
public class TestServerMultipleRequest
{
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++)
        {
            Runnable r = new Runnable()
            {
                @Override
                public void run() {
                    try {
            String host = "localhost";
            int port = 19999;
            
            StringBuffer mensaje = new StringBuffer();
            
            InetAddress ia = InetAddress.getByName(host);
            Socket connection = new Socket(ia, port);
            
            BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
            OutputStreamWriter osw = new OutputStreamWriter(bos);
            
            osw.write("soy el cliente 1, halp pl0x "+(char)13);
            osw.flush();
            
            BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
            InputStreamReader isr = new InputStreamReader(bis);
            
            int caracter;
            while ((caracter = isr.read()) != 13)
            {
                mensaje.append(caracter);
            }
            System.out.println(mensaje);
            connection.close();
            
        } catch (UnknownHostException ex) {
            
        } catch (IOException ex) {
            
        }
                }
                
            };
            Thread t = new Thread(r);
            t.start();
            
        }
    }
    
}
