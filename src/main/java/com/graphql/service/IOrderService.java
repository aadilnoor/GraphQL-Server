package com.graphql.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import com.graphql.dtos.OrderDTO;
import com.graphql.entity.Order;

public interface IOrderService {

	Order saveOrder(OrderDTO orderDTO, int userId);

	List<Order> getOrdersByUserId(int userId);
	
	Order getOrdersByOrderId(int orderId) throws AttributeNotFoundException;
	
	List<Order> getAllOrders();
}
