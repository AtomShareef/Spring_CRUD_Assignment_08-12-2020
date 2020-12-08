package com.atom.crud.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atom.crud.example.entity.Product;
import com.atom.crud.example.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
//-----------------------------------------------------------------------	
	//post mapping
	@PostMapping("/add-product")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@PostMapping("/add-products")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return productService.saveProducts(products);
	}
//-----------------------------------------------------------------------	
	//get mapping
	@GetMapping("/products")
	public List<Product> findAllProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/productById/{id}")
	public Product findProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/productByName/{name}")
	public Product findProductByName(@PathVariable String name) {
		return productService.getProductByName(name);
	}
//-----------------------------------------------------------------------	
	//put mapping - update
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
//-----------------------------------------------------------------------	
	//delete mapping - delete
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return productService.deleteProduct(id);
	}
//-----------------------------------------------------------------------	
	
	
	
	
}
