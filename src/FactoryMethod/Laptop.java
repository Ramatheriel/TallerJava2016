/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package FactoryMethod;

class Laptop extends Computadora
{
    private static Laptop laptop;
    
    private Laptop()
    {
        
    }
    
    static Laptop getInstance()
    {
        if(laptop == null)
            laptop = new Laptop();
        
        return laptop;
    }

    @Override
    public void configurar() 
    {
        System.out.println("Configurando Laptop");
    }

    @Override
    public void ensamblar() {
        System.out.println("Ensamblando Laptop");
    }

    @Override
    public void instSoft() {
        System.out.println("Instalando Software");
    }

    @Override
    public void embalar() {
        System.out.println("Embalando Laptop");
    }
    
    
}
