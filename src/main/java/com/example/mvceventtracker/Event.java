package com.example.mvceventtracker;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

// import javax.persistence.Entity;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

@Document("events")
public class Event {
	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)

	// private Long id;
	private String name;
	private String description;
	private String speaker;
	private int date;
	private int capacity;
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
	public String getDescription() {
		return description;
	}
	public String getSpeaker() {
		return speaker;
	}
	public int getDate() {
		return date;
	}
	public int getCapacity() {
		return capacity;
	}

	//Setter Functions
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
