package com.github.jpaulofmsdev.fruitshop.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.jpaulofmsdev.fruitshop.order.entity.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

	void deleteByOrderId(Long orderId);
}
