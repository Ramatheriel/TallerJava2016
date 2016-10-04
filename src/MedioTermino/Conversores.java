/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package MedioTermino;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
public class Conversores implements Runnable
{
    private CyclicBarrier barrier;
    private int num;
    private int id;
    private String[] results;
    private String bin;
    private String cuat;
    private String octa;
    private String hexa;
    
    public Conversores(int id, int num, CyclicBarrier barrier, String[] results)
    {
        this.id = id;
        this.num = num;
        this.barrier = barrier;
        this.results = results;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getCuat() {
        return cuat;
    }

    public void setCuat(String cuat) {
        this.cuat = cuat;
    }

    public String getOcta() {
        return octa;
    }

    public void setOcta(String octa) {
        this.octa = octa;
    }

    public String getHexa() {
        return hexa;
    }

    public void setHexa(String hexa) {
        this.hexa = hexa;
    }
        
    public void numBin()
    {
        bin = Integer.toBinaryString(num);
        results[0] = bin;
    }
    
    public void numCuat()
    {
        cuat = Integer.toString(num, 4);
        results[1] = cuat;
    }
    
    public void numOcta()
    {
        octa = Integer.toOctalString(num);
        results[2] = octa;
    }
    
    public void numHexa()
    {
        hexa = Integer.toHexString(num);
        results[3] = hexa;
    }

    @Override
    public void run() 
    {
        try {
            System.out.println("Hilo #: " + id);
            switch(id)
            {
                case 1:
                    numBin();
                    break;
                case 2:
                    numCuat();
                    break;
                case 3:
                    numOcta();
                    break;
                case 4:
                    numHexa();
                    break;
                default:
                    
                    break;
            }
            barrier.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Conversores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Conversores.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
}
