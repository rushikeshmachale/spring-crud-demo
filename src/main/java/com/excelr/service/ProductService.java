package com.excelr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.excelr.entity.Catagory;
import com.excelr.entity.Product;
import com.excelr.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository pr;
	
	
	public List<Product> getProducts() {
		return pr.findAll();
	}
	
	public Optional<Product> getProductById(@PathVariable Long id) {

			return pr.findById(id);	
	}
	
	 public Page<Product> getPaginatedProducts(Pageable p) {
	        return pr.findAll(p);
	    }

	public Product addProduct(@RequestBody Product p) {
		return pr.save(p);
	}
	
	public Product updateProduct(@PathVariable Long id,@RequestBody Product p) {
		Product prod = new Product();
		if(pr.existsById(id)) {
			prod.setId(id);
			prod.setName(p.getName());
			prod.setPrice(p.getPrice());
			prod.setCategory(p.getCatagory());
		}
			return prod;
	}
	
	public String deleteProduct(@PathVariable Long id) {
		if(pr.existsById(id)) {
			pr.deleteById(id);
		}
		return "deleted";
	}
	
}
