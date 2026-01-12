package com.example.SpringJdbcCrud.model;

public class Course {

	private int id;
	private String name;
	private String duration;
	private double fees;
	
	public Course() {
		
	}

	public Course(int id, String name, String duration, double fees) {
		
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.fees = fees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}
	
	
}
