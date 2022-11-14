package com.cognixia.jump.model;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {

	@Id
	private String id;
	
	@NotBlank
	private String user_id;
	
	@NotBlank
	private List<Purchaces> purchaces;
	
	@NotBlank
	private double price;
	
	public Order() {
		
	}

	public Order(String id, @NotBlank String user_id, @NotBlank List<Purchaces> purchaces, @NotBlank double price) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.purchaces = purchaces;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public List<Purchaces> getPurchaces() {
		return purchaces;
	}

	public void setPurchaces(List<Purchaces> purchaces) {
		this.purchaces = purchaces;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", purchaces=" + purchaces + ", price=" + price + "]";
	}
	
}
