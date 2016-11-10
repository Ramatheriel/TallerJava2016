/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package SegundoParcial;

/**
 *
 * @author Ricardo
 */
public class Producto {
    
    String nombre;
    String ram;
    String hdd;
    String procesador;
    String precio;

    public Producto(String nombre, String ram, String hdd, String procesador, String precio) {
        this.nombre = nombre;
        this.ram = ram;
        this.hdd = hdd;
        this.procesador = procesador;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
    public String imprime()
    {
        return ("Producto: " + this.nombre + "\n"
                + "Cantidad de Ram: " + this.ram + "\n"
                + "Disco Duro: " + this.hdd + "\n"
                + "Procesador: " + this.procesador + "\n"
                + "Precio: " + this.precio + "\n");
    }
    
}
