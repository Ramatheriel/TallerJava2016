/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Threads;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
public class Ethread extends Thread
{
    private int id;

    public Ethread(int id)
    {
        this.id = id;
    }
    
    

    @Override
    public void run() 
    {
        Random r1 = new Random();
        System.out.println("Soy el hilo  " + id + " y tengo prioridad " + this.getPriority());
        try 
        {
            System.out.println("Hilo " + id + " esperando");
            int tiempo = r1.nextInt(29000)+1000;
            System.out.println("Tiempo " + tiempo);
            sleep(tiempo);
            System.out.println("Hilo " + id + " finalizo");
        } catch (InterruptedException ex) 
        {
            
        }
    }
    
    public static void main(String[] args)
    {
        Thread t100 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("Soy un hilo");
                try
                {
                    sleep(5000);
                    System.out.println("Finaliza");
                }
                catch (InterruptedException ex)
                {
                    
                }
            }
        });
        Thread t1 = new Ethread(1);
        t1.setPriority(MAX_PRIORITY);
        Thread t2 = new Ethread(2);
        Thread t3 = new Ethread(3);
        Thread t4 = new Ethread(4);
        
        t1.setDaemon(true);
        t100.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        
    }
}
