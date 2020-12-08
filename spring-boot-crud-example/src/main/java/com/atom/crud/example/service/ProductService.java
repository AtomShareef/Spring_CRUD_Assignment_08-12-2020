package com.atom.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atom.crud.example.entity.Product;
import com.atom.crud.example.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	//save single product
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	//save multiple product
	public List<Product> saveProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}
	
	//find all
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	//find by Id
	public Product getProductById(int id) {
		return productRepository.findById(id).orElse(null);
	}
	
	//find by name
	public Product getProductByName(String name) {
		return productRepository.findByName(name);
	}
	
	//delete product by id
	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "Product "+id+" removed... !";
	}
	
	//update product by object
	public Product updateProduct(Product product) {
		Product existingProduct = productRepository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		
		return productRepository.save(existingProduct);
	}
	
	
	
	
	
	
	
}
