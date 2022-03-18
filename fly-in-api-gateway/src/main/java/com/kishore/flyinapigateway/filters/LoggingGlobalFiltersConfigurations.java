package com.kishore.flyinapigateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

@Configuration
public class LoggingGlobalFiltersConfigurations {

	final Logger log = LoggerFactory.getLogger(LoggingGlobalFiltersConfigurations.class);

	@Bean
	public GlobalFilter postGlobalFilter() {
		return (exchange, chain) -> {
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				log.info("Global Post Filter executed");
			}));
		};
	}

}
