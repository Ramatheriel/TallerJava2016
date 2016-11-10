/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Barriers;

import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author administrador1
 */
public class Test {
    public static void main(String[] args) {
        CyclicBarrier barrera1;
        CyclicBarrier barrera2;
        
        Runnable accionArealizar = new Runnable() {
            @Override
            public void run() {
                System.out.println("la barrera uno fue completada con éxito");
            }
        };
        
        Runnable accionArealizar2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("la barrera dos fue completada con éxito");
            }
        };
        
        barrera1 = new CyclicBarrier(3, accionArealizar);
        barrera2 = new CyclicBarrier(3, accionArealizar2);
        
        Barrier h1 = new Barrier(1, barrera1, barrera2);        
        Barrier h2 = new Barrier(2, barrera1, barrera2);        
        Barrier h3 = new Barrier(3, barrera1, barrera2);        
        
        new Thread(h1).start();
        new Thread(h2).start();
        new Thread(h3).start();
        
    }
 
}