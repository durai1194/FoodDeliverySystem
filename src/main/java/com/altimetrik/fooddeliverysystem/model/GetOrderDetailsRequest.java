package com.altimetrik.fooddeliverysystem.model;

public class GetOrderDetailsRequest {
	private Integer orderId;
	private Integer customerId;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	

}
