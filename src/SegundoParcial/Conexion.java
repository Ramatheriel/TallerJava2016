/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundoParcial;

import JDBC.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.lang.Integer;
import java.util.Scanner;


/**
 *
 * @author administrador1
 */
public class Conexion 
{
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            Statement s = con.createStatement();
            
            
            
            s.execute("insert into personas (id,nombre) values (1, 'ariel')");
            
            ResultSet rs = s.executeQuery("select * from personas");
            
            while(rs.next())
            {
                System.out.println("id: "+ rs.getInt(1));
                System.out.println("nombre: " + rs.getString(2));
                
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            System.out.println("class not found exception");
        } catch (InstantiationException ex) {
            System.out.println("instatiantion exception");
        } catch (IllegalAccessException ex) {
            System.out.println("IllegalAccessException");
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Cliente altaUsuario(Scanner scanner)
    {
        String nombre;
        String apellidoP;
        String apellidoM;
        String telefono;
        
        System.out.println("Ha seleccionado dar de alta un nuevo usuario");
        System.out.println("Nombre: ");
        nombre = scanner.nextLine();
        System.out.println("");
        System.out.println("Apellido Paterno: ");
        apellidoP = scanner.nextLine();
        System.out.println("");
        System.out.println("Apellido Materno: ");
        apellidoM = scanner.nextLine();
        System.out.println("");
        System.out.println("Telefono: ");
        telefono = scanner.nextLine();
        System.out.println("");
        
        Cliente cliente = new Cliente(nombre, apellidoP, apellidoM, telefono);
        
        return cliente;
    }
    
    public Producto altaProducto(Scanner scanner)
    {
        String nombre;
        String ram;
        String hdd;
        String precio;
        String procesador;
        
        System.out.println("Ha seleccionado dar de alta un nuevo producto");
        System.out.println("Nombre: ");
        nombre = scanner.nextLine();
        System.out.println("");
        System.out.println("Cantidad de Memoria Ram: ");
        ram = scanner.nextLine();
        System.out.println("");
        System.out.println("Cantidad de Disco Duro: ");
        hdd = scanner.nextLine();
        System.out.println("");
        System.out.println("Procesador: ");
        procesador = scanner.nextLine();
        System.out.println("");
        System.out.println("Precio: ");
        precio = scanner.nextLine();
        System.out.println("");
        
        Producto producto = new Producto(nombre, ram, hdd, procesador, precio);
        
        return producto;
    }
    
    public String buscaUsuario(Scanner scanner)
    {
        String criterio = null;
        int flag;
                
        System.out.println("Busqueda de Usuario");
        System.out.println("1. Busqueda por Nombre");
        System.out.println("2. Busqueda por Apellido");
        System.out.println("3. Busqueda por Telefono");
        flag = scanner.nextInt();
        
        switch(flag)
        {
            case 1:
                System.out.println("Busqueda por Nombre ");
                System.out.println("Nombre: ");
                criterio = scanner.nextLine();
                System.out.println("");
                break;
            case 2:
                System.out.println("Busqueda por Nombre ");
                System.out.println("Nombre: ");
                criterio = scanner.nextLine();
                System.out.println("");
                break;
            case 3:
                System.out.println("Busqueda por Nombre ");
                System.out.println("Nombre: ");
                criterio = scanner.nextLine();
                System.out.println("");
                break;
            default:
                System.out.println("No se encontro criterio de búsqueda");
        }
        
        return criterio;
        
    }
    
    public String buscaProducto(Scanner scanner)
    {
        String criterio;
        
        System.out.println("Busqueda de Producto");
        System.out.println("Nombre de producto: ");
        criterio = scanner.nextLine();
        
        return criterio;
        
    }
    
    public Venta registraVenta(Scanner scanner)
    {
        int id_trans;
        String nombreCliente;
        String nombreProducto;
        int cantidad;
        String total;
        
        System.out.println("Nueva Venta");
        System.out.println("ID transaccion: ");
        id_trans = scanner.nextInt();
        System.out.println("");
        System.out.println("Nombre : ");
        nombreCliente = scanner.nextLine();
        System.out.println("");
        System.out.println("Cantidad de Memoria Ram: ");
        nombreProducto = scanner.nextLine();
        System.out.println("");
        System.out.println("Cantidad: ");
        cantidad = scanner.nextInt();
        System.out.println("");
        System.out.println("Total: ");
        total = scanner.nextLine();
        System.out.println("");
        
        Venta venta = new Venta(id_trans, nombreCliente, nombreProducto, cantidad, total);
        
        return venta;
    }
}