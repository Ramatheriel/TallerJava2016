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
public abstract class Builder
{
    protected Avion avion;

    public Avion getAvion() {
        return avion;
    }
    
    public void createAvion()
    {
        avion = new Avion();
    }
    
    abstract void buildAlas();
    abstract void buildMotor();
    abstract void buildMarca();
    abstract void buildNumSer();
    abstract void buildModelo();
    
}
