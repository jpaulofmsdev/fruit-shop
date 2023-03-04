package com.github.jpaulofmsdev.fruitshop.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.jpaulofmsdev.fruitshop.exception.FruitShopException;
import com.github.jpaulofmsdev.fruitshop.product.dto.CreateOrUpdateProductDTO;

@RestController
@RequestMapping("/product")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public ResponseEntity<Product> create(@RequestBody CreateOrUpdateProductDTO dto) {
		try {
			Product product = productService.createProduct(dto);
			return new ResponseEntity<Product>(product, HttpStatus.CREATED);
		} catch (FruitShopException e) {
			throw new ResponseStatusException(e.getStatusCode(),e.getMessage());
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable("id") Long id, @RequestBody CreateOrUpdateProductDTO dto) {
		try {
			Product product = productService.updateProduct(id, dto);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (FruitShopException e) {
			throw new ResponseStatusException(e.getStatusCode(),e.getMessage());
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		try {
			productService.deleteProduct(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (FruitShopException e) {
			throw new ResponseStatusException(e.getStatusCode(),e.getMessage());
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
