package com.github.jpaulofmsdev.fruitshop.order;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.jpaulofmsdev.fruitshop.exception.FruitShopException;
import com.github.jpaulofmsdev.fruitshop.order.dto.CreateOrderLineDTO;
import com.github.jpaulofmsdev.fruitshop.order.dto.CreateOrderResultDTO;

@RestController
@RequestMapping("/order")
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	public ResponseEntity<CreateOrderResultDTO> create(@RequestBody List<CreateOrderLineDTO> dtos) {
		try {
			CreateOrderResultDTO result = orderService.createOrder(dtos);
			return new ResponseEntity<CreateOrderResultDTO>(result, HttpStatus.CREATED);
		} catch (FruitShopException e) {
			throw new ResponseStatusException(e.getStatusCode(),e.getMessage());
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		try {
			orderService.deleteOrder(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (FruitShopException e) {
			throw new ResponseStatusException(e.getStatusCode(),e.getMessage());
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
