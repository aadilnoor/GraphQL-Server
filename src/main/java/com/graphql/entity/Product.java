package com.graphql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String category;

	private float price;

	private int stock;

	
	  public Product(String name, String category, Float price, int stock) {
	  super();
	  
	  this.name = name; this.category = category; this.price = price; this.stock =
	  stock; }
	 

}
