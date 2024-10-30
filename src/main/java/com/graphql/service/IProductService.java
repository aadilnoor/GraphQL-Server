package com.graphql.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import com.graphql.entity.Product;

public interface IProductService {

	List<Product> getAllProducts();
	
	List<Product> getProductByCategory(String category);
	
	Product updateStock(int id , int stock) throws AttributeNotFoundException;
	
	Product updateProductStockShipment(int id , int stock);
	
	void deleteProductById(int id);
}
