package com.graphql.service;

import java.util.List; 

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.entity.Product;
import com.graphql.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		return productRepository.findByCategory(category);
	}

	@Override
	public Product updateStock(int id, int stock) throws AttributeNotFoundException {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Product not found with id :" + id));
		product.setStock(stock);
		return productRepository.save(product);
	}

	@Override
	public Product updateProductStockShipment(int id, int stock) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found with id :" + id));
		
		int stock2 = product.getStock();
		int addStock = stock+stock2;
		product.setStock(addStock);
		return productRepository.save(product);
	}

	@Override
	public void deleteProductById(int id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found with id :"+id));
		
		productRepository.delete(product);
		
	}

}
