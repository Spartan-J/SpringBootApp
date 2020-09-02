package com.supermarket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.supermarket.service.ProductService;

@SpringBootApplication
public class ProductMApplication_excp {
	private static final Logger logger_root = LoggerFactory.getLogger(ProductMApplication_excp.class);

	public static void main(String[] args) {
		SpringApplication.run(ProductMApplication_excp.class, args);
		
		logger_root.debug("---------App started-------");
	}

}
