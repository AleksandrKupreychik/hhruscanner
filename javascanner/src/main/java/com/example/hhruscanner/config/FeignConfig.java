package com.example.hhruscanner.config;

import feign.Client;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    public Client feignClient() {
        return new feign.okhttp.OkHttpClient();
    }
}
