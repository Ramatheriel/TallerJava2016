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
public class AsusBuilder extends Builder
{

    @Override
    void buildGabinete() {
        Gabinete gabinete = new Gabinete();
        
        gabinete.setMarca("Asus");
        gabinete.setHd("1TB");
        gabinete.setMemoriaRam("16GB");
        gabinete.setProcesador("i7");
        gabinete.setMotherboard("Asus G5");
        gabinete.setVideo("gtx 1090");
        pc.setGabinete(gabinete);
    }

    @Override
    void buildAccesorios() {
        
        Accesorios accesorios = new Accesorios();
        
        accesorios.setAudifonos("Razer Kraken");
        accesorios.setTeclado("Razer Blackwidow");
        accesorios.setMouse("Razer Deathadder");
        pc.setAccesorios(accesorios);
        
    }

    @Override
    void buildMonitor() {
        
        Monitor monitor = new Monitor();
        
        monitor.setMarca("Asus");
        monitor.setModelo("RoG75w");
        monitor.setTam(19);
        pc.setMonitor(monitor);
    }

    @Override
    void buildMarca() {
        
        pc.setMarca("Asus");
    }

    @Override
    void buildModelo() {
        
        pc.setModelo("G75x");
    }
    
    
}
