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
public class Test
{
    public static void main(String[] args)
    {
        Semaphore cuchillo;
        Semaphore tenedor;
        Semaphore mesa;
        
        cuchillo = new Semaphore(3);
        tenedor = new Semaphore(3);
        mesa = new Semaphore(4);
        
        Filosofo[] ps = new Filosofo[15];
        for (int i = 0; i < 15; i++) 
        {
            ps[i] = new Filosofo(mesa, cuchillo, tenedor, i+1);
            ps[i].start();
        }
    }
    
}
