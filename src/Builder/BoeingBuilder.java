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
public class BoeingBuilder extends Builder
{

    @Override
    void buildAlas()
    {
        Alas alas = new Alas();
        
        alas.setHiper(5);
        alas.setMarca("Windsore");
        alas.setNumSerie(123456);
        alas.setSpoiler(10);
        avion.setAlas(alas);
    }

    @Override
    void buildMotor()
    {
        Motor motor = new Motor();
        
        motor.setNumSer(12345);
        motor.setPotencia(1450);
        avion.setMotor(motor);
        
    }

    @Override
    void buildMarca()
    {
        avion.setMarca("Boeing");
    }

    @Override
    void buildNumSer()
    {
        avion.setNumSerie(9890903);
    }

    @Override
    void buildModelo()
    {
        avion.setModelo("747");
    }
    
    
}
