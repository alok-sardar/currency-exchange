package com.currency.exchange.Resilience;

import io.github.resilience4j.core.IntervalFunction;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetryConfiguration {

    private static final long INITIAL_INTERVAL = 200;
    private static final double MULTIPLIER = 2.5;

    @Bean
    public RetryConfig retryConfig() {
        IntervalFunction intervalFn =
                IntervalFunction.ofExponentialBackoff(INITIAL_INTERVAL, MULTIPLIER);
        return RetryConfig.custom()
                .maxAttempts(5)
                .intervalFunction(intervalFn)
                .retryOnException(e -> e instanceof Exception)
                .failAfterMaxAttempts(true)
                .build();
    }
    @Bean
    public RetryRegistry retryRegistry() {
        return RetryRegistry.of(retryConfig());
    }
}
