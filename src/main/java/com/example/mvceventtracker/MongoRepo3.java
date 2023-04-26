package com.example.mvceventtracker;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepo3 extends MongoRepository <Speaker,String>{
	public List<Speaker> findAll();
	public void deleteByName(String name);
}
