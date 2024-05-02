package com.excelr.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.excelr.entity.Catagory;
import com.excelr.entity.Product;
import com.excelr.service.CatagoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/catagories")
public class CatagoryController {
    @Autowired
    private CatagoryService catagoryService;

    @GetMapping("/get")
    public List<Catagory> getAllCategories() {
        return catagoryService.getAllCategories();
    }

    @GetMapping("/find/{id}")
    public Optional<Catagory> getCategories(@PathVariable Long id) {
        return catagoryService.getAllCategories(id);
    }

    @GetMapping("/pagin")
    public ResponseEntity<Page<Catagory>> getCategory(Pageable p) {
    	Page<Catagory> c= catagoryService.getPagiCategories(p);
        return ResponseEntity.ok(c);
    }
        
    @PostMapping("/add")
    public Catagory addCatagory(@RequestBody Catagory c) {
    	return catagoryService.addCatagory(c);
    }
    
    public Catagory updateCatagory(@PathVariable Long id,@RequestBody Catagory c) {
    	return catagoryService.updateCatagory(id, c);
    }
    
    public String deleteCatagory(@PathVariable Long id) {
    	return catagoryService.deleteCatagory(id);
    }
}
