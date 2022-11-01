package com.example.demo.models;

public class Expense {
	private int id;
	private String name;
	private double cost;
	private String description;

	public Expense() {
		super();
	}

	public Expense(int id, String name, double cost, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.description = desc;
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", name=" + name + ", cost=" + cost + ", desc=" + description + "]";
	}

}
