/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Iterator;

/**
 *
 * @author Ricardo
 */
public class ConcreteAggregate implements Aggregate
{
    private String[] palabras;
    private int numPalabras;
    private int size = 10;
    
    public ConcreteAggregate()
    {
        palabras = new String[size];
    }
    
    @Override
    public Iterator createIterator()
    {
        return new ConcreteIterator();
    }
    
    public void add(String palabra)
    {
        palabras[numPalabras++] = palabra;
    }
    
    class ConcreteIterator implements Iterator
    {
        int index = 0;

        @Override
        public Object first() {
            
            return palabras[0];
        }

        @Override
        public Object next() {
            
            if(isDone())
            {
                return palabras[index++];
            }
            return null;
        }

        @Override
        public boolean isDone() { //hasNext()
            
            if(index >= numPalabras)
            {
                return false;
            }
            return true;
        }

        @Override
        public Object currentItem() {
            
            return palabras[index];
        }
        
    }
    
}

