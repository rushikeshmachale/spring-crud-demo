package com.excelr.entity; 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    @ManyToOne
    @JoinColumn(name = "catagory_id", nullable = false)
    private Catagory catagory;
    
    
    

	public Product() {
	}

	public Product(Long id, String name, double price, Catagory catagory) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.catagory = catagory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Catagory getCatagory() {
		return catagory;
	}

	public void setCategory(Catagory catagory) {
		this.catagory = catagory;
	}

    
    
    
}
