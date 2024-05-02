package com.excelr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Catagory;
import com.excelr.entity.Product;
import com.excelr.service.ProductService;

@RestController
@RequestMapping
public class ProductController {

	@Autowired
	ProductService ps;
	
	@GetMapping("/get")
	private List<Product> getProduct() {
		return ps.getProducts();
	}
	

	@GetMapping("/find/{id}")
	private Optional<Product> getProductbyid(Long id) {
		return ps.getProductById(id);
	}
	

    @GetMapping("/pagin")
    public ResponseEntity<Page<Product>> getProds(Pageable p) {
    	Page<Product> c= ps.getPaginatedProducts(p);
        return ResponseEntity.ok(c);
    }
	
	@PostMapping("/add")
	private Product addProduct(Product p) {
		return ps.addProduct(p);
	}
	
	
}
