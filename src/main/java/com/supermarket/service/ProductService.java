package com.supermarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.supermarket.entity.ProductEntity;
import com.supermarket.exception.EmptyDb;
import com.supermarket.exception.NoUser;
import com.supermarket.pojo.Product;
import com.supermarket.repo.ProductRepository;
import com.supermarket.utility.beanConv;

@Service
@Transactional
public class ProductService {

	private static final Logger logger_service = LoggerFactory.getLogger(ProductService.class);	


	@Autowired
	private ProductRepository repo;

	public List<Product> listAll() {
		logger_service.debug("/service ---listAll --- debug level");
		List<ProductEntity> lp = repo.findAll();
		if(lp.isEmpty()){
			logger_service.error("No products---------listAll");
			throw new EmptyDb("No products");

		}

		return lp.stream().map(beanConv::entityToBean).collect(Collectors.toList());
	}

	
	public Product save(Product product) {
		logger_service.trace("/service ---save --- debug level");
        ProductEntity productEntity = beanConv.beanToEntity(product);
        ProductEntity entity = repo.save(productEntity);
        return beanConv.entityToBean(entity);
		
	}
	
	public Product findByName(String name){
        logger_service.trace("service layer hit inside findBy method");
        Optional<ProductEntity> entity = repo.findByName(name);
        return entity.map(beanConv::entityToBean).orElseThrow(() ->new NoUser("No product found"));
    }

	
	public Product get(Integer id) {
		logger_service.debug("/service ---listById --- debug level");
		Optional<ProductEntity> productEntity = repo.findById(id);
		return productEntity.map(beanConv::entityToBean).orElseThrow(() ->new NoUser("No prodcut found"));
	}

	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
