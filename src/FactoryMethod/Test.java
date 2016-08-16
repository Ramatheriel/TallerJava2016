/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package FactoryMethod;

/**
 *
 * @author Ramatheriel
 */
public class Test 
{
    public static void main (String[] args)
    {
        ConcreteFactory cf = ConcreteFactory.getInstance();
        Laptop l = (Laptop)cf.createCompu("laptop");
        Desktop d = (Desktop)cf.createCompu("desktop");
        Netbook n = (Netbook)cf.createCompu("netbook");
    }
}
