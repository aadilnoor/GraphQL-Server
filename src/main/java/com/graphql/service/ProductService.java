package com.graphql.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql.dtos.ProductDTO;
import com.graphql.entity.Product;
import com.graphql.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ObjectMapper mapper;

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
		int addStock = stock + stock2;
		product.setStock(addStock);
		return productRepository.save(product);
	}

	@Override
	public void deleteProductById(int id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found with id :" + id));

		productRepository.delete(product);

	}

	@Override
	public Product createProduct(ProductDTO productDTO) {
		
		Product product = new Product();
		
		product.setName(productDTO.getName());
		product.setCategory(productDTO.getCategory());
		product.setPrice(productDTO.getPrice());
		product.setStock(productDTO.getStock());
		
		return productRepository.save(product);
		
	}

	@Override
	public Product updateProduct(ProductDTO productDTO, int id) throws AttributeNotFoundException {
		Product product = productRepository.findById(id)
		.orElseThrow(() -> new AttributeNotFoundException("Product not found with id : "+id));
		
		/*
		 * product.setName(productDTO.getName());
		 * product.setCategory(productDTO.getCategory());
		 */
		product.setPrice(productDTO.getPrice());
		product.setStock(productDTO.getStock());
	return	productRepository.save(product);
	}

}
