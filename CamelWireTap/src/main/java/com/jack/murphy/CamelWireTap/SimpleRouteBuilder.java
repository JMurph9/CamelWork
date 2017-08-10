package com.jack.murphy.CamelWireTap;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder	{
	
	@Override
	public void configure() throws Exception {
		from("file:/Users/JMurph/Desktop/input?noop=true")
		.split()
		.tokenize("\n")
		.to("direct:test1");
		
		//If error occurs, send seperate copy to DeadLetterQ and directTest2
		from("direct:test1")
		.wireTap("jms:queue:DeadLetterQueue")
		.to("direct:test2");
		
		from("direct:test2")
		.process(new Processor() {
			public void process(Exchange arg0) throws Exception	{
				System.out.println(arg0.getIn().getBody().toString());
			}
		});
	}

}
