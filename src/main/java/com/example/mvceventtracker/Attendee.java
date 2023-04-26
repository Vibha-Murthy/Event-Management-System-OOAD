package com.example.mvceventtracker;

import org.springframework.data.mongodb.core.mapping.Document;


// import javax.persistence.Entity;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

@Document("attendees")
public class Attendee {
	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)

	// private Long id;
	private String name;
	private String phno;
    private String eventname;
	
	//Getter Functions
	public String getName() {
		return name;
	}
	public String getPhno() {
		return phno;
	}
	public String getEventname() {
		return eventname;
	}

	//Setter Functions
	public void setName(String name) {
		this.name = name;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
}
