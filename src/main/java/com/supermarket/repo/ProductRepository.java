package com.supermarket.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.entity.ProductEntity;
import com.supermarket.pojo.Product;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
	Optional<ProductEntity> findByName(String name);
 
}