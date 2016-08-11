/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Ricardo
 */
public class Clock
{
    private static Clock clock;
    private static Date date;
    
    private Clock()
    {
        date = new Date();
    }
    static Clock getInstance()
    {
        if(clock == null)
            clock = new Clock();
        
        return clock;
    }
    
    static Date getTime()
    {
        if(date == null)
        {
            Calendar c = Calendar.getInstance();
            date = c.getTime();
        }
        else
        {
            System.out.println("La Fecha y Hora son:");
            System.out.println(date.toString());
        }
        
        return date;
        
    }
    
}
