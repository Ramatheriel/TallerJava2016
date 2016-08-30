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
public class BuilderIdiomas extends Builder {

    @Override
    void buildMarca() 
    {
        aplicacion.setMarca("Ninshi");
    }

    @Override
    void buildNombre() {
        aplicacion.setNombre("Japones");
    }

    @Override
    void buildNumSerie() {
        aplicacion.setNumSerie(123458);
    }

    @Override
    void buildEstructura() {
        Estructura estructura = new Estructura();
        estructura.setTipo("Aprendizaje");
        estructura.setPlataforma("Windows Phone");
        estructura.setNumSerie(123458);
        
        aplicacion.setEstructura(estructura);
    }

    @Override
    void buildInterfaz() {
        Interfaz interfaz = new Interfaz();
        interfaz.setNumBotones(10);
        interfaz.setNumFormularios(50);
        interfaz.setNumSerie(123458);
        
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
        aplicacion.setDescripcion("App para aprender Japones");
    }
    
    @Override
    void imprime() {
        System.out.println("Marca: " + aplicacion.getMarca());
        System.out.println("Nombre: " + aplicacion.getNombre());
        System.out.println("Descripcion: " + aplicacion.getDescripcion());
    }
}
