package com.altimetrik.fooddeliverysystem.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetrik.fooddeliverysystem.entity.HotelEntity;

public interface HotelRepository extends JpaRepository<HotelEntity, Serializable> {
	HotelEntity findByHotelNameIgnoreCase(String hotelName);
	HotelEntity findByHotelId(Integer hotelId);
	List<HotelEntity> findByRatingsGreaterThanEqual(Integer rating);
	List<HotelEntity> findByRatingsLessThanEqual(Integer rating);
	List<HotelEntity> findByRatings(Integer rating);

}
