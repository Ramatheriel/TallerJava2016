/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package MedioTermino;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
public class Test
{
    public static void main(String[] args)
    {
        String[] results = new String[4];
        ImprimeThread i1 = new ImprimeThread(99, results);
        CyclicBarrier barrier = new CyclicBarrier(5,i1);

        Conversores c1 = new Conversores(1, 99, barrier,results);
        Conversores c2 = new Conversores(2, 99, barrier,results);
        Conversores c3 = new Conversores(3, 99, barrier,results);
        Conversores c4 = new Conversores(4, 99, barrier,results);
        
        Thread h1 = new Thread (c1);
        Thread h2 = new Thread (c2);
        Thread h3 = new Thread (c3);
        Thread h4 = new Thread (c4);
        
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        try {
            barrier.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Semaphore semGeneral = new Semaphore(5);        
        Semaphore semEmpresarial = new Semaphore(3);
        Cajero cajero = new General("general");
        Cajero cajero2 = new Empresarial("empresarial");
        
        Cliente[] usuariosGeneral = new Cliente[100];
        for (int i = 0; i < 100; i++) {
            usuariosGeneral[i] = new Cliente(i, semGeneral, semEmpresarial, cajero, "general");
            usuariosGeneral[i].start();
        }
        Cliente[] usuariosEmpresarial = new Cliente[50];
        for (int j = 0; j < 50; j++) {
            usuariosEmpresarial[j] = new Cliente(j, semGeneral, semEmpresarial, cajero2, "empresarial");
            usuariosEmpresarial[j].start();
        }
    }
    
}
