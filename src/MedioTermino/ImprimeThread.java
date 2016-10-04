/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package MedioTermino;

/**
 *
 * @author Ricardo
 */
public class ImprimeThread implements Runnable
{
    String[] results;
    private int num;

    public ImprimeThread(int num, String[] results) {
        this.num = num;
        this.results = results;
    }

    public String[] getResults() {
        return results;
    }

    public void setResults(String results,int pos) {
        this.results[pos] = results;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    

    @Override
    public void run() 
    {
        System.out.println("Decimal: " + num + " Binario: "+ results[0]);
        System.out.println("Decimal: " + num + " Cuaternario: "+ results[1]);
        System.out.println("Decimal: " + num + " Octal: "+ results[2]);
        System.out.println("Decimal: " + num + " Hexa: "+ results[3]);   
        
    }
    
}
