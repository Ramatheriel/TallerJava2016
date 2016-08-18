/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package BuilderComputadoras;


/**
 *
 * @author Ricardo
 */
public class TestBuilder 
{
    public static void main(String[] args)
    {
        Director d = new Director();
        d.setBuilder(new AsusBuilder());
        d.buildPC();
        PC miPCAsus = d.getPC();
        System.out.println("Marca del avion: " + miPCAsus.getMarca());
    }
    
}
