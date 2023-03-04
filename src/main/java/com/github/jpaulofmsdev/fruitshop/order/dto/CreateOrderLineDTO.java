package com.github.jpaulofmsdev.fruitshop.order.dto;

import java.math.BigDecimal;

public class CreateOrderLineDTO {

	private Long productId;
	private BigDecimal amount;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
