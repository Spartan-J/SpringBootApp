package com.supermarket.pojo;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
 

public class Product {

    private Integer id;
    
    private String name;
    
    private Integer price;
 
    public Product() {
    }
 
    public Product(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
 
    public Integer getId() {
        return id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}	