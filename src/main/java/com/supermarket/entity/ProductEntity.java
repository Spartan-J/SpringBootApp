package com.supermarket.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
 
@Entity
public class ProductEntity {
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotEmpty(message="Provide product name")
    @Size(min = 2 ,message = "Name should have min 2 character")
    private String name;
    
    
    
    @Range(min = 1,message = "Enter correct price" )
    private Integer price;
 
    public ProductEntity() {
    }
 
    public ProductEntity(Integer id, String name, Integer price) {
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