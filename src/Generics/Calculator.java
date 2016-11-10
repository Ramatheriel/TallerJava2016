/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generics;
import java.lang.Integer;


/**
 *
 * @author administrador1
 */
public class Calculator {
    public <T extends Number>   T sum(T a, T b)
    {        
        if( a.getClass().equals(Integer.class) )                    
            return (T) new Integer(a.intValue() + b.intValue());        
        if(a.getClass().equals(Double.class))
            return (T) new Double(a.doubleValue() + b.doubleValue());
        if(a.getClass().equals(Float.class))
            return (T) new Float(a.floatValue() + b.floatValue());
        return null;
    }    
    
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        System.out.println("La suma es; " + calc.sum(5.3, 6));
    }
    
}