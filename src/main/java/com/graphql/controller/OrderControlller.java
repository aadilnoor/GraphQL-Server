package com.graphql.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.graphql.dtos.OrderDTO;
import com.graphql.entity.Order;
import com.graphql.service.IOrderService;

@Controller
@RequestMapping("/order")
public class OrderControlller {

	@Autowired
	private IOrderService orderService;

	@MutationMapping
	public Order saveOrder(@Argument OrderDTO orderDTO) {
		// Get user ID from OrderDTO
		int userId = orderDTO.getUserID();
		return orderService.saveOrder(orderDTO, userId);
	}

	@QueryMapping
	public List<Order> getOrdersByUserId(@Argument int userId) {
		return orderService.getOrdersByUserId(userId);
	}

	@QueryMapping
	public Order getOrdersByOrderId(@Argument int orderId) throws AttributeNotFoundException {
		return orderService.getOrdersByOrderId(orderId);
	}

	@QueryMapping
	public List<Order> getAllOrders(){
		 List<Order> allOrders = orderService.getAllOrders();
		 return allOrders;
	}
}
