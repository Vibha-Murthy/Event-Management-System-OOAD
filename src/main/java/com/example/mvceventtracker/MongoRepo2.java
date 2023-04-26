package com.example.mvceventtracker;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepo2 extends MongoRepository <Attendee,String>{
	public List<Attendee> findAll();
	public void deleteByName(String name);
}
