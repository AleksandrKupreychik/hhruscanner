package com.example.hhruscanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HhruScannerApplication {
	public static void main(String[] args) {
		SpringApplication.run(HhruScannerApplication.class, args);
	}
}
