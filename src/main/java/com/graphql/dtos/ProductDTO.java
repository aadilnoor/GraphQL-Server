package com.graphql.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {

	private String name;

	private String category;

	private float price;

	private int stock;
}
