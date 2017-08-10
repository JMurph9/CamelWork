package com.jack.murphy.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import com.jack.murphy.exception.CamelCustomException;

public class MyProcessor implements Processor {
	
	public void process(Exchange exchange) throws Exception	{
		System.out.println("Exception thrown!");
		throw new CamelCustomException();
	}
}
