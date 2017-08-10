package com.jack.murphy.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.jack.murphy.exception.CamelCustomException;
import com.jack.murphy.processor.MyProcessor;
import com.jack.murphy.processor.RedeliveryProcessor;

public class SimpleRouteBuilder extends RouteBuilder	{

	@Override
	public void configure() throws Exception {
	
		onException(CamelCustomException.class).process(new Processor()	{
			
			public void process(Exchange exchange) throws Exception	{
				System.out.println("Handling exception");
			}
		}).onRedelivery(new RedeliveryProcessor()).redeliveryPolicyRef("testRedeliveryPolicyProfile")
		.log("Received body ${body}").handled(true);
		
		from("file:/Users/JMurph/Desktop/input?noop=true")
		.process(new MyProcessor())
		.to("file:/Users/JMurph/Desktop/output");

	}
	
}
