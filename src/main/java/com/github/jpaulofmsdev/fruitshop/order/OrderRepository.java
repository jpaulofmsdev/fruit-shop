package com.github.jpaulofmsdev.fruitshop.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.jpaulofmsdev.fruitshop.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
