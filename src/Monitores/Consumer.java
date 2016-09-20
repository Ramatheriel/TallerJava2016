/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Monitores;

import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author Ricardo
 */
public class Consumer extends Thread{
    protected Store store;

    public Consumer(Store store) {
        this.store = store;
    }
            
    @Override
    public void run() {
        try
        {
            while(true)
            {
                store.consume();
                Random r = new Random();
                int temp = r.nextInt()%10000+1000;
                sleep(temp>=0 ? temp : (temp*-1));
            }   
        }catch(InterruptedException e)
        {
            System.out.println(e.toString());
        }        
    }  
}
