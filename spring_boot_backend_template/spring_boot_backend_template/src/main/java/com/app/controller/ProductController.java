package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Product;
import com.app.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		 return productService.addProduct(product);
	}
	
	@GetMapping("/all")
	public List<Product> viewAllProduct(){
		return productService.getAllProduct();
	}
	
	@PutMapping("/update/{id}")
	public Product updateProduct(@PathVariable Long id,@RequestBody Product product) {
		return productService.updateProduct(id, product);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
	
	 @GetMapping("/sort/asc")
	 public List<Product> sortProductsByPriceAsc() {
	    return productService.sortProductsByPriceAsc();
	 }

	 @GetMapping("/sort/desc")
	 public List<Product> sortProductsByPriceDesc() {
	    return productService.sortProductsByPriceDesc();
	 }
	
}

