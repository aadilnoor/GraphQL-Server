package com.graphql.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.graphql.dtos.ProductDTO;
import com.graphql.entity.Product;
import com.graphql.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@MutationMapping
	public Product createProduct(@Argument ProductDTO productDTO) {

		return productService.createProduct(productDTO);
	}

	@QueryMapping
	public List<Product> getAllProducts() {
		List<Product> allProducts = productService.getAllProducts();
		return allProducts;
	}

	@QueryMapping
	public List<Product> getProductByCategory(@Argument String category) {

		List<Product> productByCategory = productService.getProductByCategory(category);
		return productByCategory;
	}

	@MutationMapping
	public Product updateStock(@Argument int id, @Argument int stock) throws AttributeNotFoundException {
		return productService.updateStock(id, stock);
	}

	@MutationMapping
	public Product updateStockShipment(@Argument int id, @Argument int stock) {
		return productService.updateProductStockShipment(id, stock);
	}

	@MutationMapping
	public String deleteProductById(@Argument int id) {
		productService.deleteProductById(id);
		return "Product Deleted...";
	}

	@MutationMapping
	public Product updateProduct(@Argument ProductDTO productDTO, @Argument int id) throws AttributeNotFoundException {
		Product updateProduct = productService.updateProduct(productDTO, id);
		return updateProduct;
	}

}
