package com.graphql.dtos;

import com.graphql.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {

	private String orderDetails ;
	private String address;
	private float price;
	private User user;
	private int userID;
}
