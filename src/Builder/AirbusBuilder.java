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
public class AirbusBuilder extends Builder
{

    @Override
    void buildAlas()
    {
        Alas alas = new Alas();
        
        alas.setHiper(5);
        alas.setMarca("Croissant");
        alas.setNumSerie(987654);
        alas.setSpoiler(4);
        avion.setAlas(alas);
    }

    @Override
    void buildMotor()
    {
        Motor motor = new Motor();
        
        motor.setNumSer(98765);
        motor.setPotencia(1450);
        avion.setMotor(motor);
        
    }

    @Override
    void buildMarca()
    {
        avion.setMarca("Airbus");
    }

    @Override
    void buildNumSer()
    {
        avion.setNumSerie(887766);
    }

    @Override
    void buildModelo()
    {
        avion.setModelo("A380");
    }
    
    
}