package com.comp5541.ConcordiaEats.model;

public class CartItemInfo {
    private Product product;
    private Integer quantity;

    // Constructor
    public CartItemInfo(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

    // Getters and setters
    // ...
}
