package com.github.jpaulofmsdev.fruitshop.order;

import java.util.List;

import com.github.jpaulofmsdev.fruitshop.exception.FruitShopException;
import com.github.jpaulofmsdev.fruitshop.order.dto.CreateOrderLineDTO;
import com.github.jpaulofmsdev.fruitshop.order.dto.CreateOrderResultDTO;

public interface IOrderService {

	CreateOrderResultDTO createOrder(List<CreateOrderLineDTO> dtos) throws FruitShopException;
	void deleteOrder(Long id) throws FruitShopException;
}
