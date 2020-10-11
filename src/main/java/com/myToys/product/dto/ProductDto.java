package com.myToys.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDto {

	@JsonProperty("id")
	public Long id;

	@JsonProperty("name")
	public String name;

	@JsonProperty("price")
	public double price;

	@JsonProperty("oldPrice")
	public double oldPrice;

	@JsonProperty("stock")
	public Long stock;

	@JsonProperty("brand")
	public String brand;

	public ProductDto() {
	}

	public ProductDto(Long id, String name, double price, double oldPrice, Long stock, String brand) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.oldPrice = oldPrice;
		this.stock = stock;
		this.brand = brand;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", price=" + price + ", oldPrice=" + oldPrice + ", stock="
				+ stock + ", brand=" + brand + "]";
	}

	
}
