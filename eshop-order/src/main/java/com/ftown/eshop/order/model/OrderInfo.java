package com.ftown.eshop.order.model;

public class OrderInfo {

	private int orderId;
	
	private String descri;
	
	private double price;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescri() {
		return descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", desc=" + descri + ", price="
				+ price + "]";
	}
}
