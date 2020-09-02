package com.supermarket.controller;

import java.util.*;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.supermarket.pojo.Product;
import com.supermarket.service.ProductService;



@RestController
public class ProductController {

	private static final Logger logger_controller = LoggerFactory.getLogger(ProductController.class);


	@Autowired
	private ProductService service;

	@GetMapping("/products")
	public List<Product> list() {
		logger_controller.debug("/products --- debug level");
		logger_controller.error("/products --- error level");
		logger_controller.info("/products --- info level");
		logger_controller.warn("/products --- warn level");
		return service.listAll();
	}


		@GetMapping("/products/{id}")
		public Product get(@PathVariable Integer id) {
			logger_controller.debug("/products/id --- debug level");
			return service.get(id); 

		}
		
		@GetMapping("/products/name/{name}")
		public Product getByName(@PathVariable String name) {
			logger_controller.debug("/products/id --- debug level");
			return service.findByName(name);
		}

		@PostMapping("/products/add")
		public Product add(@Valid @RequestBody Product product) {
			return  service.save(product);

		}


		@DeleteMapping("/products/del/{id}")
		public void delete(@PathVariable Integer id) {
			service.delete(id);
		}

	}
