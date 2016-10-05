/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package MedioTermino;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
public class General extends Cajero
{

    public General(String tipo)
    {
        this.tipo = tipo;
    }

    @Override
    public void operacion(int idCliente) 
    {
        System.out.println("Cajero Tipo: General");
        System.out.println("Cliente: " + idCliente);
        try {
            sleep((long) (Math.random()%42000 + 24000));
        } catch (InterruptedException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Operación Concluida");
    }
   
    
}
