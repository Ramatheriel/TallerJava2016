/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Parcial1;

/**
 *
 * @author Ricardo
 */
public class ConcreteAggregate implements Aggregate
{
    private Aplicacion[] aplicaciones;
    private int numAplicaciones;
    private int size = 4;
    
    public ConcreteAggregate()
    {
        aplicaciones = new Aplicacion[size];
    }
    
    @Override
    public Iterator createIterator()
    {
        return new ConcreteIterator();
    }
    
    public void add(Aplicacion aplicacion)
    {
        aplicaciones[numAplicaciones++] = aplicacion;
    }
    
    class ConcreteIterator implements Iterator
    {
        int index = 0;

        @Override
        public Object first() {
            
            return aplicaciones[0];
        }

        @Override
        public Object next() {
            
            if(isDone())
            {
                return aplicaciones[index++];
            }
            return null;
        }

        @Override
        public boolean isDone() { //hasNext()
            
            if(index >= numAplicaciones)
            {
                return false;
            }
            return true;
        }

        @Override
        public Object currentItem() {
            
            return aplicaciones[index];
        }
        
    }
    
}
