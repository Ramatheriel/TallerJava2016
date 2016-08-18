/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Builder;

/**
 *
 * @author Ricardo
 */
public class TestBuilder 
{
    public static void main(String[] args)
    {
        Director d = new Director();
        d.setBuilder(new BoeingBuilder());
        d.buildAvion();
        Avion miAvionBoeing = d.getAvion();
        System.out.println("Marca del avion: " + miAvionBoeing.getMarca());
        
        d.setBuilder(new AirbusBuilder());
        d.buildAvion();
        Avion miAvionAirbus = d.getAvion();
        System.out.println("Marca del avion: " + miAvionAirbus.getModelo());
    }
    
}
