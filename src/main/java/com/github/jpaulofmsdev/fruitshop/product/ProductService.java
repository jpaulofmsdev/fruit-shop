package com.github.jpaulofmsdev.fruitshop.product;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.github.jpaulofmsdev.fruitshop.exception.FruitShopException;
import com.github.jpaulofmsdev.fruitshop.product.dto.CreateOrUpdateProductDTO;
import com.github.jpaulofmsdev.fruitshop.product.entity.Product;

@Service
public class ProductService implements IProductService {

	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product createProduct(CreateOrUpdateProductDTO dto) throws FruitShopException {

		ProductValidator.validade(dto);

		Product product = new Product();
		product.fromDTO(dto);

		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Long id, CreateOrUpdateProductDTO dto) throws FruitShopException {

		Optional<Product> result = productRepository.findById(id);
		if(!result.isPresent()) {
			throw new FruitShopException(HttpStatus.NOT_FOUND, "Product not found");
		}

		ProductValidator.validade(dto);

		Product product = result.get();

		product.fromDTO(dto);

		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Long id) throws FruitShopException {

		Optional<Product> result = productRepository.findById(id);
		if(!result.isPresent()) {
			throw new FruitShopException(HttpStatus.NOT_FOUND, "Product not found");
		}
		
		productRepository.deleteById(id);
		
	}


}
