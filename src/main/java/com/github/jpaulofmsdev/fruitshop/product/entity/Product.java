package com.github.jpaulofmsdev.fruitshop.product.entity;

import java.math.BigDecimal;

import com.github.jpaulofmsdev.fruitshop.product.dto.CreateOrUpdateProductDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private BigDecimal price;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product fromDTO(CreateOrUpdateProductDTO dto) {
		setName(dto.getName());
		setPrice(dto.getPrice());
		return this;
	}
}
