package com.jack.murphy.route;

import org.apache.camel.builder.RouteBuilder;
import com.jack.murphy.processor.MyProcessor;

public class SimpleRouteBuilder extends RouteBuilder	{

	@Override
	public void configure() throws Exception {
		from("file:/Users/JMurph/Desktop/input?noop=true")
		.process(new MyProcessor())
		.to("file:/Users/JMurph/Desktop/output");
		
	}
	
}
