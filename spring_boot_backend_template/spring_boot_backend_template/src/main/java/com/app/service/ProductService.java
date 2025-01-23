package com.app.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ProductDto;
import com.app.entity.Product;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product addProduct(Product product) {
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        return productRepository.save(product);
    }
	
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}
	
	public Product updateProduct(Long id, Product updatedProduct) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setCategory(updatedProduct.getCategory());
        return productRepository.save(product);
    }
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	
	public List<Product> sortProductsByPriceAsc() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    public List<Product> sortProductsByPriceDesc() {
        return productRepository.findAllByOrderByPriceDesc();
    }
}
