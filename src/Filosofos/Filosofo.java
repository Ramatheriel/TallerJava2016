/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Filosofos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Ricardo
 */
public class Filosofo extends Thread
{
    Semaphore tenedor;
    Semaphore cuchillo;
    Semaphore mesa;
    int id;

    public Filosofo(Semaphore mesa, Semaphore tenedor, Semaphore cuchillo, int id) 
    {
        this.mesa = mesa;
        this.tenedor = tenedor;
        this.cuchillo = cuchillo;
        this.id = id;
    }

    @Override
    public void run() {
        while(true)
        {
            try
            {
                mesa.acquire();
                System.out.println("Soy el filosofo: " + id + "y me senté en la mesa");
                cuchillo.acquire();
                System.out.println("Soy el filosofo: " + id + "y tengo un cuchillo");
                tenedor.acquire();
                System.out.println("Soy el filosofo: " + id + "y tengo un tenedor");
                comer();         
                tenedor.release();
                cuchillo.release();
                mesa.release();
                
            }
            catch(InterruptedException ex)
            {
                System.out.println("Excepcion " + ex.toString());
            }
        }
    }

    private void comer() 
    {
        try {
            System.out.println("Soy el filosofo: " + id + "y estoy comiendo");
            sleep((long) (Math.random()%15000 + 15000));
            System.out.println("Soy el filosofo: " + id + "y termine de comer");
        } catch (InterruptedException ex)
        {
            
        }
    }
    
    
    
    
    
}
