/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Iterator;

import java.util.Vector;

/**
 *
 * @author Ricardo
 */
public class Test {
    
    public static void main(String[] args)
    {
        ConcreteAggregate listaPalabras = new ConcreteAggregate();
        
        listaPalabras.add("Libro");
        listaPalabras.add("Revista");
        listaPalabras.add("Periódico");
        listaPalabras.add("Manga");
        listaPalabras.add("Comic");
        
        for (Iterator i = listaPalabras.createIterator() ; i.isDone(); )
        {
            System.out.println("Palabra: " + i.next());
        }
        
        //Forma 2 de acceder al iterador
        
        Iterator ii = listaPalabras.createIterator();
        while(ii.isDone())
        {
            System.out.println("Palabra: " + ii.next());
        
        }
        
        //Con un vector de cosas
        Vector<String> miVectorDePalabras = new Vector();
        miVectorDePalabras.add("lista");
        miVectorDePalabras.add("cosas");
        
        for(java.util.Iterator<String> i = miVectorDePalabras.iterator(); i.hasNext();)
        {
            System.out.println("Vector: " + i.next());
        }
    }
}
