package com.oneclick.productservice;

import org.springframework.boot.SpringApplication;

public class TestProductserviceApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProductserviceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
