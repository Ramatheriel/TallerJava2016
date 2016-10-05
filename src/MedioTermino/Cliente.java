/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package MedioTermino;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
public class Cliente extends Thread
{
    int id;
    int idcajero;
    Semaphore cajeroGeneral;
    Semaphore cajeroEmpresarial;
    String operacion;
    Cajero personaCajero;

    public Cliente(int id, Semaphore cajeroGeneral, Semaphore cajeroEmpresarial, Cajero personaCajero, String operacion)
    {
        this.id = id;
        this.cajeroGeneral = cajeroGeneral;
        this.cajeroEmpresarial = cajeroEmpresarial;
        this.personaCajero = personaCajero;
        this.operacion = operacion;
    }        

    void realizarOperacion() throws InterruptedException
    {
        System.out.println("ID Cliente: " + id);
        System.out.println("Tipo operacion: " + operacion);
        personaCajero.operacion(id);
        
    }

    
    @Override
    public void run()
    {
        String tipo = personaCajero.tipo;
        boolean tryAcquire = false;
        
        if(tipo.equals("general"))
        {
            try {
                int bandera = 0;
                do 
                {
                    try
                    {
                        tryAcquire = cajeroGeneral.tryAcquire(10, TimeUnit.SECONDS);
                        if(!tryAcquire)
                        {
                            tryAcquire = cajeroEmpresarial.tryAcquire(10, TimeUnit.SECONDS);
                            bandera = 1;
                        }
                        
                    } catch (InterruptedException ex) {
                        
                    }
                }while(!tryAcquire);
                realizarOperacion();
                if(bandera == 1)
                    cajeroEmpresarial.release();
                else
                    cajeroGeneral.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            try {
                cajeroEmpresarial.acquire();
                realizarOperacion();
                cajeroEmpresarial.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
    
}
