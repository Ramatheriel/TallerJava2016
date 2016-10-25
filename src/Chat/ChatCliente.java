/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JEditorPane;

/**
 *
 * @author Ricardo
 */
public class ChatCliente implements Runnable
{
    
    private Socket cliente;
    private DataInputStream in;
    private DataOutputStream out;
    private int puerto = 2027;
    private String host = "localhost";
    private String mensajes = "";
    JEditorPane panel;
    
    public ChatCliente(JEditorPane panel)
    {
        this.panel = panel;
        try {
            cliente = new Socket(host,puerto);
            in = new DataInputStream(cliente.getInputStream());
            out = new DataOutputStream(cliente.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void run() {
        try{
            while(true){
                mensajes += in.readUTF();
                panel.setText(mensajes);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void enviarMsg(String msg)
    {
        try
        {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
