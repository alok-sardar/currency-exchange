package com.currency.exchange.Resilience;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class CircuitBreakerConfiguration {
    @Bean
    public CircuitBreakerConfig circuitBreakerConfig(){
        return CircuitBreakerConfig.custom()
                .minimumNumberOfCalls(5)
                .maxWaitDurationInHalfOpenState(Duration.ofSeconds(10))
                .waitDurationInOpenState(Duration.ofSeconds(10))
                .failureRateThreshold(10)
                .build();
    }
    @Bean
    public CircuitBreakerRegistry returnRegistry(){
        return CircuitBreakerRegistry.of(circuitBreakerConfig());
    }
}
