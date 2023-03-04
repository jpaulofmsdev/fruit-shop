package com.github.jpaulofmsdev.fruitshop.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.jpaulofmsdev.fruitshop.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
