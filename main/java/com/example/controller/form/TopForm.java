package com.example.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TopForm {

	private Integer productId;
	
	@NotBlank //(message="product_nameは必須です。  ")
	private String name;

	@NotNull //(message="priceは必須です。  ")
	private Integer price;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
