/*
Ricardo Meneses Pardo 77148
 */
package Singleton;

public class Singleton 
{
    private Singleton()
    {
        
    }
    static Singleton getInstance()
    {
        if(singleton == null)
            singleton = new Singleton();
        
        return singleton;
    }
    
    private static Singleton singleton;
}
