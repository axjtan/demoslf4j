package org.axjtan.demoslf4j.route;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TimerEndpointRoute extends RouteBuilder {

    private static final Logger slf4jLogger = LoggerFactory.getLogger(TimerEndpointRoute.class);

    @Override
    public void configure() {
        from("timer://SLF4JTimer?delay=5000&fixedRate=true&period=1000")
                .process(exchange -> {
                    slf4jLogger.info("Hello World");
                })
                .end();
    }
}
