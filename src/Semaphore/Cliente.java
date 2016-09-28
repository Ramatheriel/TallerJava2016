/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
public class Cliente extends Thread{
    Semaphore cajero;
    Cajero personaCajero;

    public Cliente(Semaphore cajero, Cajero personaCajero) {
        this.cajero = cajero;
        this.personaCajero = personaCajero;
    }        

    void realizarOperacion() throws InterruptedException
    {
        Random r = new Random();
        float probabilidad = r.nextFloat();
        if(probabilidad < 0.25f)
        {
            personaCajero.depositar((int) (Math.random()%10000));
        }
        if((probabilidad >= 0.25f) && (probabilidad < 0.50f))
        {
            personaCajero.retirar((int) (Math.random()%10000));
        }
        if((probabilidad >= 0.50f) && (probabilidad < 0.75f))
        {
            personaCajero.getSaldo((int) (Math.random()%1000+1));
        }
        if((probabilidad >= 0.75f) && (probabilidad < 1.0f))
        {
            personaCajero.pagar((int) (Math.random()%1000+1), (int) (Math.random()%10000));
        }
    }

    
    @Override
    public void run(){
        try {
            cajero.acquire();
            realizarOperacion();            
            cajero.release();
        }catch(InterruptedException e)
        {
            
        }
    }
    
}
