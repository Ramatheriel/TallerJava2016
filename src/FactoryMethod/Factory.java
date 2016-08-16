/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package FactoryMethod;

/**
 *
 * @author Ricardo
 */
public abstract class Factory
{    
    public abstract Computadora factoryMethod(String tipoCompu);
    
    public Computadora createCompu(String tipoCompu)
    {
        Computadora c = factoryMethod(tipoCompu);
        c.configurar();
        c.ensamblar();
        c.instSoft();
        c.embalar();
        
        return c;
        
    }
}
