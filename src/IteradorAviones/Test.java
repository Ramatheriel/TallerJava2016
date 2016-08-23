/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package IteradorAviones;

import Iterator.*;
import Builder.*;
import java.util.Vector;

/**
 *
 * @author Ricardo
 */
public class Test {
    
    public static void main(String[] args)
    {
        Director d = new Director();
        d.setBuilder(new BoeingBuilder());
        d.buildAvion();
        Avion miAvionBoeing = d.getAvion();
        
        d.setBuilder(new AirbusBuilder());
        d.buildAvion();
        Avion miAvionAirbus = d.getAvion();
        ListaDeAviones listaAviones = new ListaDeAviones();
        
        listaAviones.add(miAvionBoeing);
        listaAviones.add(miAvionAirbus);
        
        for (Iterator i = listaAviones.createIterator() ; i.isDone(); )
        {
            System.out.println("Avion: " + i.next());
        }
        
        //Forma 2 de acceder al iterador
        
        Iterator ii = listaAviones.createIterator();
        while(ii.isDone())
        {
            System.out.println("Avion: " + ii.next());
        
        }
        
        //Con un vector de cosas
        Vector<Avion> miVectorDeAviones = new Vector();
        miVectorDeAviones.add(miAvionBoeing);
        miVectorDeAviones.add(miAvionAirbus);
        
        for(java.util.Iterator<Avion> i = miVectorDeAviones.iterator(); i.hasNext();)
        {
            System.out.println("Vector: " + i.next());
        }
    }
}
