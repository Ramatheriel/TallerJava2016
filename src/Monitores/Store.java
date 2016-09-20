/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Monitores;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
        
/**
 *
 * @author Ricardo
 */
public class Store {
    Lock lock;
    Condition isFull;
    Condition isEmpty;
    Vector<Integer> v;
    int count = 0;

    public Store() 
    {
        lock = new ReentrantLock();
        isFull = lock.newCondition();
        isEmpty = lock.newCondition();
        
        v = new Vector<Integer>();
        v.setSize(10);
    }
    
    public void produce()
    {
        lock.lock();
        //este el código que sólo puede ejecutar un hilo bajo ciertas condiciones
        try
        {
            while(count == 10)
            {
                isFull.await();
            }
            Random r = new Random();
            Integer temp = new Integer(r.nextInt()%100+1);
            v.add(temp);
            System.out.println("se produjo un: " + temp.toString());
            count++;
            isEmpty.signal();            
        }catch(InterruptedException e)
        {
            System.out.println(e.toString());
        }
        finally
        {
            lock.unlock();
        }                               
    }
  
    public Integer consume()
    {
        Integer temp = 0;
        lock.lock();
        try
        {
            while(count==0)
            {
                isEmpty.await();
            }
            temp = v.lastElement();
            System.out.println("consumidor consumió un: " + temp);
            v.remove(count);            
            count--;
            isFull.signal();
        }catch(InterruptedException e)
        {
            System.out.println(e.toString());
        }
        finally
        {
            lock.unlock();
            return temp;
        }
    }
    
    
}
