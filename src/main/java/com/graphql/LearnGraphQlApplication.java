package com.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnGraphQlApplication {

	/*
	 * @Autowired private ProductRepository productRepository;
	 */

	public static void main(String[] args) {
		SpringApplication.run(LearnGraphQlApplication.class, args);
		System.err.println("Application is Up now.....");
	}
	/*
	 * @PostConstruct public void initDB() { // Creating 10 products with updated
	 * fields and integer stock List<Product> products = Stream.of( new
	 * Product("Laptop", "Electronics", 80000.0f, 10), new Product("Mobile Phone",
	 * "Electronics", 50000.0f, 15), new Product("Refrigerator", "Appliances",
	 * 30000.0f, 5), new Product("Washing Machine", "Appliances", 25000.0f, 0), new
	 * Product("Headphones", "Accessories", 3000.0f, 20), new Product("Smart Watch",
	 * "Electronics", 15000.0f, 30), new Product("Television", "Electronics",
	 * 40000.0f, 7), new Product("Microwave", "Appliances", 10000.0f, 12), new
	 * Product("Air Conditioner", "Appliances", 35000.0f, 0), new
	 * Product("Gaming Console", "Electronics", 45000.0f, 25)
	 * ).collect(Collectors.toList());
	 * 
	 * // Save all products to the repository productRepository.saveAll(products); }
	 */
}
