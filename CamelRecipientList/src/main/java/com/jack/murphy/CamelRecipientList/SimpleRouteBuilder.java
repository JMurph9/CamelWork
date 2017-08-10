package com.jack.murphy.CamelRecipientList;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.ValueBuilder;

public class SimpleRouteBuilder extends RouteBuilder	{
	@Override
	public void configure() throws Exception	{
		from("file:/Users/JMurph/Desktop/input?noop=true")
		.split()
		.tokenize("\n")
		.to("direct:test");
		
		//set recipient list by creating the queue name at runtime
		
		from("direct:test")
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception	{
				String recipient = exchange.getIn().getBody().toString();
				String recipientQueue = "jms:queue" + recipient;
				exchange.getIn().setHeader("queue", recipientQueue);
			}
		}).recipientList(header("queue"));
	}

}
