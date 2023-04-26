package com.example.mvceventtracker;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
// import javax.persistence.Entity;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

@Document("products")
public class Product {
	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)

	// private Long id;
	private String name;
    private int pid;
	private String description;
	private int price;
	@Id
    private String id;

    // ... other fields and methods ...

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
	
	//Getter Functions
	public String getName() {
		return name;
	}
	public int getPid() {
		return pid;
	}
	public String getDescription() {
		return description;
	}
	public int getPrice() {
		return price;
	}
	

	//Setter Functions
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
