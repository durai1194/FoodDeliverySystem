package com.altimetrik.fooddeliverysystem.dao;

import com.altimetrik.fooddeliverysystem.model.FilterHotelRequest;
import com.altimetrik.fooddeliverysystem.model.FilterHotelResponse;
import com.altimetrik.fooddeliverysystem.model.FoodItemRequest;
import com.altimetrik.fooddeliverysystem.model.FoodItemResponse;
import com.altimetrik.fooddeliverysystem.model.GetOrderDetailsRequest;
import com.altimetrik.fooddeliverysystem.model.OrderDetailsResponse;
import com.altimetrik.fooddeliverysystem.model.OrderFoodItemRequest;
import com.altimetrik.fooddeliverysystem.model.OrderFoodItemResponse;

public interface FdsDAO {
	public FoodItemResponse retriveFoodItems(FoodItemRequest foodItemRequest);
	public OrderFoodItemResponse orderFoodItems(OrderFoodItemRequest orderFoodItemRequest);
	public OrderDetailsResponse retriveOrderDetails(GetOrderDetailsRequest getOrderDetailsRequest);
	public FilterHotelResponse filterHotels(FilterHotelRequest filterHotelRequest);
}
