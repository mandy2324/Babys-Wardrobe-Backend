package com.cognixia.jump.model;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Clothes {

	@Id
	private String id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String type;
	
	@NotBlank
	private char gender;
	
	@NotBlank
	private int age;
	
	@NotBlank
	private List<String> color;
	
	@NotBlank
	private double price;
	
	public Clothes() {
		
	}

	public Clothes(String id, @NotBlank String name, @NotBlank String type, @NotBlank char gender, @NotBlank int age,
			@NotBlank List<String> color, @NotBlank double price) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.gender = gender;
		this.age = age;
		this.color = color;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getColor() {
		return color;
	}

	public void setColor(List<String> color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Clothes [id=" + id + ", name=" + name + ", type=" + type + ", gender=" + gender + ", age=" + age
				+ ", color=" + color + ", price=" + price + "]";
	}
	
}
