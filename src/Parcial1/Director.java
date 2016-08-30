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
public class Director 
{
    private static Director director;
    Builder builder;
    
    private Director()
    {
        
    }
    
    static Director getDirector()
    {
        if (director == null)
        {
            director = new Director();            
        }
        return director;
    }
    
    public void buildAplicacion()
    {
        builder.createAplicacion();
        builder.buildNombre();
        builder.buildNumSerie();
        builder.buildMarca();
        builder.buildEstructura();
        builder.buildInterfaz();
        builder.buildSocial();
        builder.buildDescripcion();
    }

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }
    
    public Aplicacion getAplicacion()
    {
        return builder.getAplicacion();
    }
    
}
