package com.excelr.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.entity.Catagory;

@Repository
public interface CatagoryRepository extends JpaRepository<Catagory, Long>{

	Page<Catagory> findAll(Pageable p);
}
