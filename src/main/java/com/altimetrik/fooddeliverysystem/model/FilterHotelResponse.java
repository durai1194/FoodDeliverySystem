package com.altimetrik.fooddeliverysystem.model;

import java.util.List;

import com.altimetrik.fooddeliverysystem.entity.HotelEntity;

public class FilterHotelResponse {
	
	private String status;
	private Integer statusCode;
	private List<HotelEntity> hotels;
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
	public List<HotelEntity> getHotels() {
		return hotels;
	}
	public void setHotels(List<HotelEntity> hotels) {
		this.hotels = hotels;
	}
	
	
}
