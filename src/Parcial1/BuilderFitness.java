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
public class BuilderFitness extends Builder {

    @Override
    void buildMarca() 
    {
        aplicacion.setMarca("Samsung");
    }

    @Override
    void buildNombre() {
        aplicacion.setNombre("Fitness");
    }

    @Override
    void buildNumSerie() {
        aplicacion.setNumSerie(123457);
    }

    @Override
    void buildEstructura() {
        Estructura estructura = new Estructura();
        estructura.setTipo("Estatica");
        estructura.setPlataforma("iOS");
        estructura.setNumSerie(123457);
        
        aplicacion.setEstructura(estructura);
    }

    @Override
    void buildInterfaz() {
        Interfaz interfaz = new Interfaz();
        interfaz.setNumBotones(20);
        interfaz.setNumFormularios(10);
        interfaz.setNumSerie(123457);
        
        aplicacion.setInterfaz(interfaz);
    }

    @Override
    void buildSocial() {
        Social social = new Social();
        social.setPlat1("Facebook");
        social.setPlat2("Twitter");
        social.setPlat3("Google");
        
        aplicacion.setSocial(social);
    }
    
    @Override
    void buildDescripcion() {
        aplicacion.setDescripcion("App para hacer ejercicio");
    }
    
    @Override
    void imprime() {
        System.out.println("Marca: " + aplicacion.getMarca());
        System.out.println("Nombre: " + aplicacion.getNombre());
        System.out.println("Descripcion: " + aplicacion.getDescripcion());
    }
    
}
