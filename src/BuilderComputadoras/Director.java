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
public class Director 
{
    Builder builder;
    
    void buildPC()
    {
        builder.createPC();
        builder.buildGabinete();
        builder.buildAccesorios();
        builder.buildMonitor();
        builder.buildMarca();
        builder.buildModelo();
    }

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }
    
    public PC getPC() {
        return builder.getPC();
    }
    
    
}