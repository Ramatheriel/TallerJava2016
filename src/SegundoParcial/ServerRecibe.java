/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundoParcial;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author administrador1
 */
public class ServerRecibe implements Runnable{
    Socket connection;
    final ServerPrincipal main;
    Statement s;

    String mensajeEntrada;
    String mensajeSalida;
    int flag;
    
    ObjectInputStream entrada;
    ObjectOutputStream salida;
    
    
    public ServerRecibe(Socket connection, ServerPrincipal main, Statement s) {
        this.connection = connection;
        this.main = main;
        this.s = s;
    }           
    
    @Override
    public void run() {
        try {
            entrada = new ObjectInputStream(connection.getInputStream());
            ResultSet rs;
            do
            {
                //Primera interacción
                main.mostrarMensaje("Bienvenido, escriba el comando deseado.");
                main.mostrarMensaje("1. Alta de Usuario");
                main.mostrarMensaje("2. Alta de Producto");
                main.mostrarMensaje("3. Busqueda de Usuario");
                main.mostrarMensaje("4. Busqueda de Producto");
                main.mostrarMensaje("5. Nueva Venta");
                main.mostrarMensaje("6. Consultas");
                
                flag = (int)entrada.readObject();
                main.mostrarMensaje(flag + "\n");
                
                //Segunda Interacción
                switch(flag)
                {
                    case 1:
                        Cliente cliente = altaUsuario();
                        s.execute("insert into cliente (" + cliente.getNombre()
                                + "," + cliente.getApellidoP()
                                + "," + cliente.getApellidoM()
                                + "," + cliente.getTelefono() + ")");
                        main.mostrarMensaje("Usuario Registrado");
                        break;
                    
                    case 2:
                        Producto producto = altaProducto();
                        s.execute("insert into producto (" + producto.getNombre()
                                + "," + producto.getRam()
                                + "," + producto.getHdd()
                                + "," + producto.getProcesador()
                                + "," + producto.getPrecio()+ ")");
                        main.mostrarMensaje("Producto Registrado");
                        break;
                        
                    case 3:
                        buscaUsuario();
                        break;
                        
                    case 4:
                        buscaProducto();
                        break;
                        
                    case 5:
                        Venta venta = registraVenta();
                        s.execute("insert into producto (" + venta.getNombreCliente()
                                + "," + venta.getNombreProducto()
                                + "," + venta.getCantidad()
                                + "," + venta.getTotal()+ ")");
                        main.mostrarMensaje("Venta Registrada");
                        break;
                        
                    case 6:
                        totales();
                        break;
                        
                    default: 
                        break;
                }
                
                salida = new ObjectOutputStream(connection.getOutputStream());
                salida.flush();
            }while(!mensajeEntrada.equals("Server-> terminate"));
        } catch (IOException ex) {
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerRecibe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        try {
            entrada.close();
            connection.close();
        } catch (IOException ex) {
            
        }
        
    }
    
    public Cliente altaUsuario()
    {
        String nombre = null;
        String apellidoP = null;
        String apellidoM = null;
        String telefono = null;
        
        try {          
            main.mostrarMensaje("Ha seleccionado dar de alta un nuevo usuario");
            main.mostrarMensaje("Nombre: ");
            nombre = (String)entrada.readObject();
            main.mostrarMensaje("Apellido Paterno: ");
            apellidoP = (String)entrada.readObject();
            main.mostrarMensaje("Apellido Materno: ");
            apellidoM = (String)entrada.readObject();
            main.mostrarMensaje("Telefono: ");
            telefono = (String)entrada.readObject();
        } catch (IOException ex) {
            System.out.println("IO exception");
        } catch (ClassNotFoundException ex) {
            System.out.println("class not found exception");
        }
        
        Cliente cliente = new Cliente(nombre, apellidoP, apellidoM, telefono);
        return cliente;
    }
    
    public Producto altaProducto()
    {
        String nombre = null;
        String ram = null;
        String hdd = null;
        String precio = null;
        String procesador = null;
        
        try {
            main.mostrarMensaje("Ha seleccionado dar de alta un nuevo producto");
            main.mostrarMensaje("Nombre: ");
            nombre = (String)entrada.readObject();
            main.mostrarMensaje("Cantidad de Memoria Ram: ");
            ram = (String)entrada.readObject();
            main.mostrarMensaje("Cantidad de Disco Duro: ");
            hdd = (String)entrada.readObject();
            main.mostrarMensaje("Procesador: ");
            procesador = (String)entrada.readObject();
            main.mostrarMensaje("Precio: ");
            precio = (String)entrada.readObject();
            
        } catch (IOException ex) {
            System.out.println("IO exception");
        } catch (ClassNotFoundException ex) {
            System.out.println("class not found exception");
        }
        
        Producto producto = new Producto(nombre, ram, hdd, procesador, precio);
        
        return producto;
    }
    
    public void buscaUsuario()
    {
        String criterio = null;
        int flag = 0;

        try {
            
            ResultSet rs;
            main.mostrarMensaje("Busqueda de Usuario");
            main.mostrarMensaje("1. Busqueda por Nombre");
            main.mostrarMensaje("2. Busqueda por Apellido");
            main.mostrarMensaje("3. Busqueda por Telefono");
            flag = (Integer)entrada.readObject();;

            switch(flag)
            {
                case 1:
                    main.mostrarMensaje("Busqueda por Nombre ");
                    main.mostrarMensaje("Nombre: ");
                    criterio = (String)entrada.readObject();
                    rs = s.executeQuery("select * from cliente where nombre = '" + criterio + "'");
                    break;
                case 2:
                    main.mostrarMensaje("Busqueda por Apellido ");
                    main.mostrarMensaje("Apellido: ");
                    criterio = (String)entrada.readObject();
                    rs = s.executeQuery("select * from cliente where (apellidoP = '" + criterio + "') OR (apellidoM = '" + criterio + "')");
                    break;
                case 3:
                    main.mostrarMensaje("Busqueda por Telefono ");
                    main.mostrarMensaje("Telefono: ");
                    criterio = (String)entrada.readObject();
                    rs = s.executeQuery("select * from cliente where telefono = '" + criterio + "'");
                    break;
                default:
                    main.mostrarMensaje("No se encontro criterio de búsqueda");
            }

        } catch (IOException ex) {
            System.out.println("IO exception");
        } catch (ClassNotFoundException ex) {
            System.out.println("class not found exception");
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
    }
    
    public void buscaProducto()
    {
        String criterio = null;
        
        try {
            ResultSet rs;
            
            main.mostrarMensaje("Busqueda de Producto");
            main.mostrarMensaje("Nombre de producto: ");
            criterio = (String)entrada.readObject();
            
            rs = s.executeQuery("select * from producto where nombre = '" + criterio + "'");
        
        } catch (IOException ex) {
            System.out.println("IO exception");
        } catch (ClassNotFoundException ex) {
            System.out.println("class not found exception");
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
    }
    
    public Venta registraVenta()
    {
        int id_trans = -1;
        String nombreCliente = null;
        String nombreProducto = null;
        int cantidad = -1;
        String total = null;
        
        try {
            
            main.mostrarMensaje("Nueva Venta");
            main.mostrarMensaje("ID transaccion: ");
            id_trans = (Integer)entrada.readObject();
            main.mostrarMensaje("Nombre : ");
            nombreCliente = (String)entrada.readObject();
            main.mostrarMensaje("Cantidad de Memoria Ram: ");
            nombreProducto = (String)entrada.readObject();
            main.mostrarMensaje("Cantidad: ");
            cantidad = (Integer)entrada.readObject();
            main.mostrarMensaje("Total: ");
            total = (String)entrada.readObject();
        
        } catch (IOException ex) {
            System.out.println("IO exception");
        } catch (ClassNotFoundException ex) {
            System.out.println("class not found exception");
        }
        
        Venta venta = new Venta(id_trans, nombreCliente, nombreProducto, cantidad, total);
        
        return venta;
    }
    
    public void totales()
    {
        try {
            
            ResultSet rs;
            int criterio = 0;
        
                main.mostrarMensaje("Bienvenido, escriba el comando deseado.");
                main.mostrarMensaje("1. Total de clientes");
                main.mostrarMensaje("2. Total de productos");
                main.mostrarMensaje("3. Total de ventas");
        
            switch(criterio)
            {
                case 1:
                    rs = s.executeQuery("select count(*) from personas");
                    break;

                case 2:
                    rs = s.executeQuery("select count(*) from producto");
                    break;

                case 3:
                    rs = s.executeQuery("select count(*) from ventas");
                    break;

                default:
                    main.mostrarMensaje("No se encontro criterio de búsqueda");
                    break;
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
}