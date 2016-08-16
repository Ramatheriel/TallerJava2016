/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package FactoryMethod;

public class Netbook extends Computadora
{
    private static Netbook netbook;
    
    private Netbook()
    {
        
    }
    
    static Netbook getInstance()
    {
        if(netbook == null)
            netbook = new Netbook();
        
        return netbook;
    }

    @Override
    public void configurar() 
    {
        System.out.println("Configurando Netbook");
    }

    @Override
    public void ensamblar() {
        System.out.println("Ensamblando Netbook");
    }

    @Override
    public void instSoft() {
        System.out.println("Instalando Software");
    }

    @Override
    public void embalar() {
        System.out.println("Embalando Netbook");
    }
    
    
}
