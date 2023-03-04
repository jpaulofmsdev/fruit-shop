package com.github.jpaulofmsdev.fruitshop.product;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import com.github.jpaulofmsdev.fruitshop.exception.FruitShopException;
import com.github.jpaulofmsdev.fruitshop.product.dto.CreateOrUpdateProductDTO;

public class ProductValidator {

	public static void validade(CreateOrUpdateProductDTO dto) throws FruitShopException {
		if(!StringUtils.hasText(dto.getName())) {
			throw new FruitShopException(HttpStatus.BAD_REQUEST, "Product name must not be empty");
		}
		
		if(dto.getPrice() == null || dto.getPrice().compareTo(BigDecimal.ZERO) < 1) {
			throw new FruitShopException(HttpStatus.BAD_REQUEST, "Product price must be bigger than zero");
		}
	}
}
