package com.blueyonder.shopservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "ShopService api", description = "Documentation shopService API v1.0"))
public class ShopserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopserviceApplication.class, args);
	}

}
