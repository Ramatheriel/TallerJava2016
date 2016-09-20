/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Monitores;

import java.util.Random;
/**
 *
 * @author Ricardo
 */
public class Producer extends Thread {
    protected Store store;

    public Producer(Store store) {
        this.store = store;
    }
            
    @Override
    public void run() {
        try
        {
            while(true)
            {
                store.produce();
                Random r = new Random();            
                int temp = r.nextInt()%20000+19000;
                sleep(temp>=0 ? temp : (temp*-1));
            }   
        }catch(InterruptedException e)
        {
            System.out.println(e.toString());
        }        
    }    
}