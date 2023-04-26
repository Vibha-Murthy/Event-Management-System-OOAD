package com.example.mvceventtracker;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepo1 extends MongoRepository <Product,String>{
	public List<Product> findAll();
	public void deleteByName(String name);
}
