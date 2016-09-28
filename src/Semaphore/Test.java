/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Semaphore;

import java.util.concurrent.Semaphore;

/**
 *
 * @author administrador1
 */
public class Test { 
    public static void main(String[] args) {
        Semaphore semCajero;
        semCajero = new Semaphore(100);
        Cajero cajero = new Cajero();
        Cliente[] usuarios = new Cliente[100];
        for (int i = 0; i < 100; i++) {
            usuarios[i] = new Cliente(semCajero, cajero);
            usuarios[i].start();
        }                
    }
}