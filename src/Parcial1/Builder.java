/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Parcial1;

/**
 *
 * @author Ricardo
 */
public abstract class Builder 
{
    protected Aplicacion aplicacion;
    
    public Aplicacion getAplicacion()
    {
        return aplicacion;
    }
    
    public void createAplicacion()
    {
        aplicacion = new Aplicacion();
    }
    
    abstract void buildMarca();
    abstract void buildNombre();
    abstract void buildNumSerie();
    abstract void buildEstructura();
    abstract void buildInterfaz();
    abstract void buildSocial();
    abstract void buildDescripcion();
    abstract void imprime();
}
