/*
Ricardo Meneses Pardo 77148
 */
package Singleton;

public class TestSingleton
{
    public static void main(String[] args)
    {
        Clock s1, s2, s3;
        s1 = Clock.getInstance();
        s2 = Clock.getInstance();
        s3 = Clock.getInstance();
        if((s1 == s3)&&(s1==s2))
        {
            System.out.println("si");
            s1.getTime();
        }
        else
            System.out.println("no");
        
        Clock c1, c2, c3;
        c1 = Clock.getInstance();
        c2 = Clock.getInstance();
        c3 = Clock.getInstance();
        
        
        if((c1 == c3)&&(c1==c2))
        {
            System.out.println("si");
            c1.getTime();
        }
        else
            System.out.println("no");
    }
}
