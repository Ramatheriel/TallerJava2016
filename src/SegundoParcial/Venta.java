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
public class Venta {
    
    int id_trans;
    String nombreCliente;
    String nombreProducto;
    int cantidad;
    String total;

    public Venta(int id_trans, String nombreCliente, String nombreProducto, int cantidad, String total) {
        this.id_trans = id_trans;
        this.nombreCliente = nombreCliente;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getId_trans() {
        return id_trans;
    }

    public void setId_trans(int id_trans) {
        this.id_trans = id_trans;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    public String imprime()
    {
        return ("ID transaccion: " + this.id_trans + "\n"
                + "Cliente: " + this.nombreCliente + "\n"
                + "Producto: " + this.nombreProducto + "\n"
                + "Cantidad vendida: " + this.cantidad + "\n"
                + "Total: " + this.total + "\n");
    }
}
