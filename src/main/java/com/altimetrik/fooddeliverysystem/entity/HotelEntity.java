package com.altimetrik.fooddeliverysystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotel_details")
public class HotelEntity {
	@Id
	@Column(name = "hotel_id")
	private Integer hotelId;
	@Column(name = "hotel_name")
	private String hotelName;
	@Column(name = "ratings")
	private Integer ratings;
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Integer getRatings() {
		return ratings;
	}
	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}
	
	

}
