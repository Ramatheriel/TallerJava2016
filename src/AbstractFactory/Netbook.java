/*
Ricardo Meneses Pardo 77148
 */
package AbstractFactory;

public class Netbook extends Computadora
{

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
