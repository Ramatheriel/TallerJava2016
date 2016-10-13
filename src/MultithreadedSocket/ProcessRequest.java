/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package MultithreadedSocket;

import java.io.BufferedInputStream;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
class ProcessRequest implements Runnable
{
    Socket connection;
    StringBuffer sb;

    public ProcessRequest(Socket connection) {
        this.connection = connection;
        sb = new StringBuffer();
    }

    @Override
    public void run() 
    {
        try
        {
            BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
            InputStreamReader isr = new InputStreamReader(bis);
            
            BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
            OutputStreamWriter osw = new OutputStreamWriter(bos);
            
            int caracter;
            while((caracter = isr.read()) != (char)13)
            {
                sb.append((char)caracter);
            }
            System.out.println("el servidor recibió: "+ sb);
            
            sb.delete(0,sb.length());
            sb.append("el servidor dice: traigan un verdadero admin" + (char)13);
            osw.write(sb.toString());
            osw.flush();
            connection.close();
            
        } catch (IOException ex) {
            
        }
    }
    
    
    
}
