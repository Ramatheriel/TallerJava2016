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
public class Director 
{
    Builder builder;
    
    public void buildAvion()
    {
        builder.createAvion();
        builder.buildAlas();
        builder.buildMotor();
        builder.buildMarca();
        builder.buildModelo();
        builder.buildNumSer();
    }

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }
    
    public Avion getAvion() {
        return builder.getAvion();
    }
    
    
}
