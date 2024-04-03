package com.currency.exchange.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/currency-exchange")
@Slf4j
public class CircuitBreakerController {
    @GetMapping("/circuit-breaker")
    @Retry(name="retryConfig",fallbackMethod = "hardCodedResponse")
    @CircuitBreaker(name="circuitBreakerConfig",fallbackMethod = "hardCodedResponse")
    @RateLimiter(name="rateLimitConfig",fallbackMethod = "hardCodedResponse")
    @Bulkhead(name="bulkheadConfiguration",fallbackMethod = "hardCodedResponse")
    public String sampleApi(){
        log.info("Sample Api Call received");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity("http://localhost:8080/dummy", String.class).getBody();
    }
    public String hardCodedResponse(Exception exception){
        return "Hard Coded";
    }
}
