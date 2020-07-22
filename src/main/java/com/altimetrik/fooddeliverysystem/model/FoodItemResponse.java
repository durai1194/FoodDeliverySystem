package com.altimetrik.fooddeliverysystem.model;

import java.util.List;

import com.altimetrik.fooddeliverysystem.entity.FoodItemEntity;

public class FoodItemResponse {
	private List<FoodItemEntity> foodItemList;
	private String status;
	private Integer statusCode;

	public List<FoodItemEntity> getFoodItemList() {
		return foodItemList;
	}

	public void setFoodItemList(List<FoodItemEntity> foodItemList) {
		this.foodItemList = foodItemList;
	}

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
	
}
