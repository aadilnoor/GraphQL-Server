package com.graphql.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.dtos.OrderDTO;
import com.graphql.entity.Order;
import com.graphql.entity.User;
import com.graphql.repository.OrderRepository;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private IUserService userService;

	@Override
	public Order saveOrder(OrderDTO orderDTO, int userId) {

		User user = userService.findUserById(userId); // Fetch user by ID
		Order order = new Order();

		order.setOrderDetails(orderDTO.getOrderDetails());
		order.setAddress(orderDTO.getAddress());
		order.setPrice(orderDTO.getPrice());
		order.setUser(user);

		return orderRepository.save(order);
	}

	@Override
	public List<Order> getOrdersByUserId(int userId) {
		List<Order> orders = orderRepository.findByUser_UserId(userId);
		return orders;
	}

	@Override
	public Order getOrdersByOrderId(int orderId) throws AttributeNotFoundException {
		return orderRepository.findById(orderId)
				.orElseThrow(() -> new AttributeNotFoundException("Order not found with id :" + orderId));
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

}
