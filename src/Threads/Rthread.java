/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Threads;

/**
 *
 * @author Ricardo
 */
public class Rthread implements Runnable
{
    private int id;

    public Rthread(int id)
    {
        this.id = id;
    }
    

    @Override
    public void run() 
    {
        System.out.println("Soy el hilo: " + id);
    }
    
    public static void main(String[] args)
    {
        Rthread t1 = new Rthread(1);
        Rthread t2 = new Rthread(2);
        Rthread t3 = new Rthread(3);
        Rthread t4 = new Rthread(4);
        
        Thread h1 = new Thread (t1);
        Thread h2 = new Thread (t2);
        Thread h3 = new Thread (t3);
        Thread h4 = new Thread (t4);
        
        h1.start();
        h2.start();
        h3.start();
        h4.start();
    }
}
