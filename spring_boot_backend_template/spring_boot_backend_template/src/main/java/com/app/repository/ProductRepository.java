package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.ProductDto;
import com.app.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findAllByOrderByPriceAsc();

    List<Product> findAllByOrderByPriceDesc();
	
}
