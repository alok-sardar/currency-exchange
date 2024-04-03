package com.currency.exchange.Resilience;

import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BulkHeadConfiguration {
    @Bean
    public BulkheadConfig bulkheadConfiguration(){
        return BulkheadConfig.custom()
                .maxConcurrentCalls(10).build();

    }
    @Bean
    public BulkheadRegistry bulkheadRegistry(){
        return BulkheadRegistry.of(bulkheadConfiguration());
    }
}
