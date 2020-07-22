package com.altimetrik.fooddeliverysystem.model;

import java.util.List;

import com.altimetrik.fooddeliverysystem.entity.OrderDetailsEntity;

public class OrderDetailsResponse {
	private String status;
	private Integer statusCode;
	private List<OrderDetailsEntity> orderDetails;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public List<OrderDetailsEntity> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetailsEntity> orderDetails) {
		this.orderDetails = orderDetails;
	}
	

}
