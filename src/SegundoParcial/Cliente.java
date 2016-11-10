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
public class Cliente {
    
    String nombre;
    String apellidoP;
    String apellidoM;
    String telefono;

    public Cliente(String nombre, String apellidoP, String apellidoM, String telefono) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String imprime()
    {
        return ("Nombre: " + this.nombre + "\n"
                + "Apellido Paterno: " + this.apellidoP + "\n"
                + "Apellido Materno: " + this.apellidoM + "\n"
                + "Telefono: " + this.telefono + "\n");
    }
    
}
