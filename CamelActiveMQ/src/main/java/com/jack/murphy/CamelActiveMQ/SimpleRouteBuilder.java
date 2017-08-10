package com.jack.murphy.CamelActiveMQ;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:/Users/JMurph/Desktop/input?noop=true")
		.split()
		.tokenize("\n")
		.to("jms:queue:Jack");
	}
	
}
