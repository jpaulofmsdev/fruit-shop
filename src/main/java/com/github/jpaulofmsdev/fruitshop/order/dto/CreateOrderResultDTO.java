package com.github.jpaulofmsdev.fruitshop.order.dto;

import java.math.BigDecimal;
import java.util.List;

public class CreateOrderResultDTO {

	private Long id;
	
	private BigDecimal totalAmount;
	
	private List<CreateOrderLineResultDTO> lines;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<CreateOrderLineResultDTO> getLines() {
		return lines;
	}

	public void setLines(List<CreateOrderLineResultDTO> lines) {
		this.lines = lines;
	}
}
