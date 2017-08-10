package com.jack.murphy.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.jack.murphy.exception.CamelCustomException;
import com.jack.murphy.processor.MyProcessor;

public class SimpleRouteBuilder extends RouteBuilder	{

	@Override
	public void configure() throws Exception {
		from("file:/Users/JMurph/Desktop/input?noop=true")
		.doTry()
		.process(new MyProcessor())
		.to("file:/Users/JMurph/Desktop/output")
		.doCatch(CamelCustomException.class).process(new Processor()	{
			
			public void process(Exchange exchange) throws Exception	{
				System.out.println("Handling exception");
			}
		}).log("Received body ${body}");
		
	}
	
}
