package com.example.mvceventtracker;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepo extends MongoRepository <Event,String>{
	public List<Event> findAll();
	public void deleteByName(String name);
}
