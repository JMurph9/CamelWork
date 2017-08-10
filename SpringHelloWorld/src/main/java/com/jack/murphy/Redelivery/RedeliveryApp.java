package com.jack.murphy.Redelivery;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RedeliveryApp		{
    public static void main(String[] args)	{
    	AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-camel.xml");
    	ctx.start();
    	System.out.println("Aplication context started");
    	
    	try { 
    		Thread.sleep(5 * 60 * 1000);
    	} catch(Exception e)	{
    		e.printStackTrace();
    	}
    	ctx.stop();
    	ctx.close();
  
    }
}
