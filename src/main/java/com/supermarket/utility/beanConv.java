package com.supermarket.utility;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supermarket.entity.ProductEntity;
import com.supermarket.pojo.Product;

public class beanConv {
	
	   private static ObjectMapper objectMapper = new ObjectMapper();

	public static ProductEntity beanToEntity(Product product) {
		return objectMapper.convertValue(product,ProductEntity.class);
		/*
		 * BeanUtils.copyProperties(product, productEntity); return productEntity;
		 */
	}

	public static Product entityToBean(ProductEntity productEntity) {
		return objectMapper.convertValue(productEntity,Product.class);
		/*
		 * BeanUtils.copyProperties(productEntity,Product.class); return product;
		 */

	}
}
