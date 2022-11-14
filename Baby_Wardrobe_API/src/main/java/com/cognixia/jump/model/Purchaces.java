package com.cognixia.jump.model;

import javax.validation.constraints.NotBlank;

public class Purchaces {

	@NotBlank
	private String prod_id;
	
	@NotBlank
	private int qty;
	
	@NotBlank
	private double price;
	
	public Purchaces() {
		
	}

	public Purchaces(@NotBlank String prod_id, @NotBlank int qty, @NotBlank double price) {
		super();
		this.prod_id = prod_id;
		this.qty = qty;
		this.price = price;
	}

	public String getProd_id() {
		return prod_id;
	}

	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Purchaces [prod_id=" + prod_id + ", qty=" + qty + ", price=" + price + "]";
	}
	
}
