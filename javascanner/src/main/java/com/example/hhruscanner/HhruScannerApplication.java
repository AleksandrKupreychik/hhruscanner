package com.example.hhruscanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@AutoConfiguration
@EnableAsync
@EnableFeignClients
public class HhruScannerApplication {
	public static void main(String[] args) {
		SpringApplication.run(HhruScannerApplication.class, args);
	}
}
