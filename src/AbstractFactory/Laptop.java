/*
Ricardo Meneses Pardo 77148
 */
package AbstractFactory;

public class Laptop extends Computadora
{

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
