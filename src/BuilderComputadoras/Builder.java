/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package BuilderComputadoras;

/**
 *
 * @author Ricardo
 */
public abstract class Builder
{
    protected PC pc;

    public PC getPC() {
        return pc;
    }
    
    public void createPC()
    {
        pc = new PC();
    }
    
    abstract void buildGabinete();
    abstract void buildAccesorios();
    abstract void buildMonitor();
    abstract void buildMarca();
    abstract void buildModelo();
    
}