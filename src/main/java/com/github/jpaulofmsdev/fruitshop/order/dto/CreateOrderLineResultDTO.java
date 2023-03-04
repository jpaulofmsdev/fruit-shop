package com.github.jpaulofmsdev.fruitshop.order.dto;

import java.math.BigDecimal;

public class CreateOrderLineResultDTO {

	private String productName;
	
	private BigDecimal amount;
	
	private BigDecimal price;
	
	public CreateOrderLineResultDTO(String productName, BigDecimal amount, BigDecimal price) {
		this.productName = productName;
		this.amount = amount;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getPrice() {
		return price;
	}
}
