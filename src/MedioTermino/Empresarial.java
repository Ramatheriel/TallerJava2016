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
public class Empresarial extends Cajero
{
    public Empresarial(String tipo)
    {
        this.tipo = tipo;
    }

    @Override
    public void operacion(int idCliente) 
    {
        System.out.println("Cajero Tipo: Empresarial");
        System.out.println("Cliente: " + idCliente);
        try {
            sleep((long) (Math.random()%540000 + 320000));
        } catch (InterruptedException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Operación Concluida");
    }
    
}
