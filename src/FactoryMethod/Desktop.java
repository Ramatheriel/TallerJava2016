/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package FactoryMethod;

public class Desktop extends Computadora
{
    private static Desktop desktop;
    
    private Desktop()
    {
        
    }
    
    static Desktop getInstance()
    {
        if(desktop == null)
            desktop = new Desktop();
        
        return desktop;
    }

    @Override
    public void configurar() 
    {
        System.out.println("Configurando Desktop");
    }

    @Override
    public void ensamblar() {
        System.out.println("Ensamblando Desktop");
    }

    @Override
    public void instSoft() {
        System.out.println("Instalando Software");
    }

    @Override
    public void embalar() {
        System.out.println("Embalando Desktop");
    }
    
    
}
