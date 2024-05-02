package com.excelr.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.excelr.entity.Catagory;
import com.excelr.repository.CatagoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CatagoryService {
    @Autowired
    private CatagoryRepository catagoryRepository;

    public List<Catagory> getAllCategories() {
        return catagoryRepository.findAll();
    }

    public Page<Catagory> getPagiCategories(Pageable p) {
        return catagoryRepository.findAll(p);
    }

    public Optional<Catagory> getAllCategories(Long id) {
        return catagoryRepository.findById(id);
    }
    
    public Catagory addCatagory(Catagory c) {
    	return catagoryRepository.save(c);
    }
    
    public Catagory updateCatagory( Long id, Catagory c) {
    	Catagory cat = new Catagory();
    	if(catagoryRepository.existsById(id)) {
    		cat.setId(id);
    		cat.setName(c.getName());
    		cat.setProducts(c.getProducts());
    		
    		catagoryRepository.save(cat);
    	}
    	
    	return cat;
    }
    public String deleteCatagory(@PathVariable Long id) {
    	if(catagoryRepository.existsById(id)) {
    		catagoryRepository.deleteById(id);
    	}
    	return "deleted";
    }
}
