/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Iterator;

/**
 *
 * @author Ricardo
 */
public interface Iterator {
    
    public Object first();
    public Object next();
    public boolean isDone();
    public Object currentItem();
}
