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
public class BuilderJuegos extends Builder {

    @Override
    void buildMarca() 
    {
        aplicacion.setMarca("Niantic");
    }

    @Override
    void buildNombre() {
        aplicacion.setNombre("Juego");
    }

    @Override
    void buildNumSerie() {
        aplicacion.setNumSerie(123456);
    }

    @Override
    void buildEstructura() {
        Estructura estructura = new Estructura();
        estructura.setTipo("Dinamica");
        estructura.setPlataforma("Android");
        estructura.setNumSerie(123456);
        
        aplicacion.setEstructura(estructura);
    }

    @Override
    void buildInterfaz() {
        Interfaz interfaz = new Interfaz();
        interfaz.setNumBotones(50);
        interfaz.setNumFormularios(5);
        interfaz.setNumSerie(123456);
        
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
        aplicacion.setDescripcion("App para jugar Pokemon Go");
    }
    
    @Override
    void imprime() {
        System.out.println("Marca: " + aplicacion.getMarca());
        System.out.println("Nombre: " + aplicacion.getNombre());
        System.out.println("Descripcion: " + aplicacion.getDescripcion());
    }
    
}
