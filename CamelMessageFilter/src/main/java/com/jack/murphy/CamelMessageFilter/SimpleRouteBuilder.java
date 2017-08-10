package com.jack.murphy.CamelMessageFilter;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder	{

	@Override
	public void configure() throws Exception {
		from("file:/Users/JMurph/Desktop/input?noop=true")
		.split()
		.tokenize("\n")
		.to("direct:test");
		
		//configure content to be filtered
		from("direct:test")
		.filter(body()
		.contains("jack"))
		.to("jms:queue:MessageFilter");
	}

}
