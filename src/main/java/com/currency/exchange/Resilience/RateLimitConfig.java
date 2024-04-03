package com.currency.exchange.Resilience;

import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class RateLimitConfig {
    @Bean
    public RateLimiterConfig returnRateLimit(){
        return RateLimiterConfig.custom()
                .limitForPeriod(1)
                .limitRefreshPeriod(Duration.ofSeconds(3))
                .build();
    }
    @Bean
    public RateLimiterRegistry rateLimiterRegistry(){
        return RateLimiterRegistry.of(returnRateLimit());
    }
}
