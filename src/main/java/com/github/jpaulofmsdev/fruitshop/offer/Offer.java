package com.github.jpaulofmsdev.fruitshop.offer;

import java.math.BigDecimal;

import com.github.jpaulofmsdev.fruitshop.product.entity.Product;

public class Offer {

	private Long id;
	
	private Product buyProduct;
	
	private BigDecimal buyAmount;
	
	private BigDecimal buyPrice;
	
	private Product offerProduct;
	
	private BigDecimal offerAmount;
	
	private BigDecimal offerDiscount;
}
