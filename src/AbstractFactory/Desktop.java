/*
Ricardo Meneses Pardo 77148
 */
package AbstractFactory;

public class Desktop extends Computadora
{

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
