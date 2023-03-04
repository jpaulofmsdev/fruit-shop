package com.github.jpaulofmsdev.fruitshop.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.github.jpaulofmsdev.fruitshop.exception.FruitShopException;
import com.github.jpaulofmsdev.fruitshop.order.dto.CreateOrderLineDTO;
import com.github.jpaulofmsdev.fruitshop.order.dto.CreateOrderLineResultDTO;
import com.github.jpaulofmsdev.fruitshop.order.dto.CreateOrderResultDTO;
import com.github.jpaulofmsdev.fruitshop.order.entity.Order;
import com.github.jpaulofmsdev.fruitshop.order.entity.OrderLine;
import com.github.jpaulofmsdev.fruitshop.product.ProductRepository;
import com.github.jpaulofmsdev.fruitshop.product.entity.Product;

@Service
public class OrderService implements IOrderService {

	private OrderRepository orderRepository;
	
	private OrderLineRepository orderLineRepository;
	
	private ProductRepository productRepository;
	
	public OrderService(OrderRepository orderRepository, OrderLineRepository orderLineRepository, ProductRepository productRepository) {
		this.orderRepository = orderRepository;
		this.orderLineRepository = orderLineRepository;
		this.productRepository = productRepository;
	}

	@Override
	public CreateOrderResultDTO createOrder(List<CreateOrderLineDTO> dtos) throws FruitShopException {
		
		List<OrderLine> orderLines = new ArrayList<>();
		for(CreateOrderLineDTO dto : dtos) {
			
			Optional<Product> product = productRepository.findById(dto.getProductId());
			if(!product.isPresent()) {
				throw new FruitShopException(HttpStatus.NOT_FOUND, "Product " + dto.getProductId() + " not found");
			}
			
			if(dto.getAmount() == null || dto.getAmount().compareTo(BigDecimal.ZERO) < 1) {
				throw new FruitShopException(HttpStatus.BAD_REQUEST, "Amount must be greater than zero");
			}
			
			OrderLine orderLine = new OrderLine();
			orderLine.setProduct(product.get());
			orderLine.setAmount(dto.getAmount());
			
			orderLines.add(orderLine);
		}
		
		Order order = new Order();
		order.setTotalAmount(orderLines.stream()
				.map(line -> line.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add));
		
		Order orderDB = orderRepository.save(order);
		
		orderLines.stream().forEach(line -> line.setOrder(orderDB));
		
		orderLineRepository.saveAll(orderLines);
		
		
		CreateOrderResultDTO result = new CreateOrderResultDTO();
		result.setId(orderDB.getId());
		result.setTotalAmount(orderDB.getTotalAmount());
		result.setLines(orderLines.stream().map(line -> {
			return new CreateOrderLineResultDTO(line.getProduct().getName(), line.getAmount(), line.getPrice());
		}).collect(Collectors.toList()));
		
		return result;
	}

	@Override
	public void deleteOrder(Long id) throws FruitShopException {
		
		Optional<Order> order = orderRepository.findById(id);
		if(!order.isPresent()) {
			throw new FruitShopException(HttpStatus.NOT_FOUND, "Order not found");
		}
		
		orderLineRepository.deleteByOrderId(id);
		orderRepository.deleteById(id);
		
	}
	
}
