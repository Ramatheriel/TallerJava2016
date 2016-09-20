/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Monitores;

/**
 *
 * @author Ricardo
 */
public class Test 
{
    public static void main(String[] args) {
        Store store = new Store();
        Thread [] p = new Producer[10];
        Thread [] c = new Consumer[10];
        for (int i = 0; i < 10; i++) {
            p[i] = new Producer(store);
            c[i] = new Consumer(store);
            p[i].start();
            c[i].start();
        }
    }    
}
