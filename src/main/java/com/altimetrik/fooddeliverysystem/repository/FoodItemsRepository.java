package com.altimetrik.fooddeliverysystem.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.fooddeliverysystem.entity.FoodItemEntity;

@Repository
public interface FoodItemsRepository extends JpaRepository<FoodItemEntity, Serializable> {
	
	List<FoodItemEntity> findByHotelId(Integer hotelId);
	List<FoodItemEntity> findByOrderByPriceAsc();
	List<FoodItemEntity> findByOrderByPriceDesc();
	FoodItemEntity findByItemNameIgnoreCaseAndHotelId(String itemName, Integer hotelId);
	

}
