package com.blueyonder.ecommerce_configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EcommerceConfigserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceConfigserviceApplication.class, args);
	}

}
