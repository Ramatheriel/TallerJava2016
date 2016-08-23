/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package IteradorAviones;

import Builder.*;
import Iterator.*;

/**
 *
 * @author Ricardo
 */
public class ListaDeAviones implements Aggregate{

    private Avion[] aviones;
    private int numAviones;
    private int size = 10;
    
    public ListaDeAviones()
    {
        aviones = new Avion[size];
    }
    
    @Override
    public Iterator createIterator()
    {
        return new ConcreteIterator();
    }
    
    public void add(Avion avion)
    {
        aviones[numAviones++] = avion;
    }
    
    class ConcreteIterator implements Iterator
    {
        int index = 0;

        @Override
        public Object first() {
            
            return aviones[0];
        }

        @Override
        public Object next() {
            
            if(isDone())
            {
                return aviones[index++];
            }
            return null;
        }

        @Override
        public boolean isDone() { //hasNext()
            
            if(index >= numAviones)
            {
                return false;
            }
            return true;
        }

        @Override
        public Object currentItem() {
            
            return aviones[index];
        }
        
    }
    
}
