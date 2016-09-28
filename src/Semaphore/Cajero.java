/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Semaphore;

import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author Ricardo
 */
public class Cajero {
    void depositar(int cantidad) throws InterruptedException
    {        
        System.out.println("El único cajero esta depositando " + cantidad);
        sleep((long) (Math.random()%20000));
        System.out.println("Terminé la operación depositar");
    }
    
    void retirar(int cantidad) throws InterruptedException
    {        
        System.out.println("El único cajero esta retirando " + cantidad);
        sleep((long) (Math.random()%20000));
        System.out.println("Terminé la operación retirar");
    }
    void getSaldo(int cuenta) throws InterruptedException
    {
        Random r = new Random();
        System.out.println("el saldo de la cuenta: " + cuenta + " es: " + r.nextInt()%1000 + 1);
        sleep((long) (Math.random()%20000));
        System.out.println("Terminé la operación obtener saldo");
    }
    void pagar(int cuenta, int cantidad) throws InterruptedException
    {   
        System.out.println("abonando "+ cantidad + " a la cuenta "+ cuenta);
        sleep((long) (Math.random()%20000));
        System.out.println("Terminé la operación pagar");
    }
}
