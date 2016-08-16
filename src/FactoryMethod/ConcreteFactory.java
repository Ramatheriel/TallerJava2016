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
public class ConcreteFactory extends Factory
{
    private static ConcreteFactory concreteFactory;
    
    private ConcreteFactory()
    {
        
    }
    
    static ConcreteFactory getInstance()
    {
        if(concreteFactory == null)
            concreteFactory = new ConcreteFactory();
        
        return concreteFactory;
    }
    
    @Override
    public Computadora factoryMethod(String tipoCompu)
    {
        Computadora c;
    
        switch (tipoCompu)
        {
                case "laptop":
                    c = Laptop.getInstance();
                    break;
                case "netbook":
                    c = Netbook.getInstance();
                    break;
                case "desktop":
                    c = Desktop.getInstance();
                    break;
                default :
                    c = null;
                    break;
        }
        return c;         
        
    }
    
}
