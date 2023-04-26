package com.example.mvceventtracker;

import org.springframework.data.mongodb.core.mapping.Document;
// import javax.persistence.Entity;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

@Document("speakers")
public class Speaker{
	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)

	// private Long id;
	private String name;
	private String phno;
    private String eventname;
    private String topic;
    private int slot;
	
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

    public String getTopic() {
		return topic;
	}

    public int getSlot() {
		return slot;
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
    public void setTopic(String topic) {
		this.topic = topic;
	}
    public void setSlot(int slot) {
		this.slot = slot;
	}
	private String audioFilePath;

	public String getAudioFilePath() {
		return audioFilePath;
	}

	public void setAudioFilePath(String audioFilePath) {
		this.audioFilePath = audioFilePath;
	}
}
