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
public class BuilderMusica extends Builder {

    @Override
    void buildMarca() 
    {
        aplicacion.setMarca("Spotify");
    }

    @Override
    void buildNombre() {
        aplicacion.setNombre("Musica");
    }

    @Override
    void buildNumSerie() {
        aplicacion.setNumSerie(123459);
    }

    @Override
    void buildEstructura() {
        Estructura estructura = new Estructura();
        estructura.setTipo("Administracion");
        estructura.setPlataforma("Multiple");
        estructura.setNumSerie(123459);
        
        aplicacion.setEstructura(estructura);
    }

    @Override
    void buildInterfaz() {
        Interfaz interfaz = new Interfaz();
        interfaz.setNumBotones(15);
        interfaz.setNumFormularios(2);
        interfaz.setNumSerie(123459);
        
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
        aplicacion.setDescripcion("App para escuchar musica");
    }
    
    @Override
    void imprime() {
        System.out.println("Marca: " + aplicacion.getMarca());
        System.out.println("Nombre: " + aplicacion.getNombre());
        System.out.println("Descripcion: " + aplicacion.getDescripcion());
    }
}
