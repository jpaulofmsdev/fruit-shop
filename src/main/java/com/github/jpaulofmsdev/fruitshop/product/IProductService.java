package com.github.jpaulofmsdev.fruitshop.product;

import com.github.jpaulofmsdev.fruitshop.exception.FruitShopException;
import com.github.jpaulofmsdev.fruitshop.product.dto.CreateOrUpdateProductDTO;

public interface IProductService {

	Product createProduct(CreateOrUpdateProductDTO dto) throws FruitShopException;
	
	Product updateProduct(Long id, CreateOrUpdateProductDTO dto) throws FruitShopException;
	
	void deleteProduct(Long id) throws FruitShopException;
}
