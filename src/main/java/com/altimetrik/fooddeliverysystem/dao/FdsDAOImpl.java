package com.altimetrik.fooddeliverysystem.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.altimetrik.fooddeliverysystem.entity.FoodItemEntity;
import com.altimetrik.fooddeliverysystem.entity.HotelEntity;
import com.altimetrik.fooddeliverysystem.entity.OrderDetailsEntity;
import com.altimetrik.fooddeliverysystem.model.FilterHotelRequest;
import com.altimetrik.fooddeliverysystem.model.FilterHotelResponse;
import com.altimetrik.fooddeliverysystem.model.FoodItemRequest;
import com.altimetrik.fooddeliverysystem.model.FoodItemResponse;
import com.altimetrik.fooddeliverysystem.model.GetOrderDetailsRequest;
import com.altimetrik.fooddeliverysystem.model.OrderDetailsResponse;
import com.altimetrik.fooddeliverysystem.model.OrderFoodItemRequest;
import com.altimetrik.fooddeliverysystem.model.OrderFoodItemResponse;
import com.altimetrik.fooddeliverysystem.repository.FoodItemsRepository;
import com.altimetrik.fooddeliverysystem.repository.HotelRepository;
import com.altimetrik.fooddeliverysystem.repository.OrderDetailsRepository;

@Repository
public class FdsDAOImpl implements FdsDAO {
	
	@Autowired
	private FoodItemsRepository foodItemsRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Override
	public FoodItemResponse retriveFoodItems(FoodItemRequest foodItemRequest) {
		FoodItemResponse foodItemResponse = new FoodItemResponse();
		try {
			List<FoodItemEntity> foodItemList = new ArrayList<>();
			if(!StringUtils.isEmpty(foodItemRequest.getHotelName())) {
					HotelEntity hotelEntity = hotelRepository.findByHotelNameIgnoreCase(foodItemRequest.getHotelName());
					int hotelId = hotelEntity.getHotelId();
					foodItemList = foodItemsRepository.findByHotelId(hotelId);
			} else {
				foodItemList = foodItemsRepository.findAll();
			}
			if(foodItemList.isEmpty()) {
				foodItemResponse.setStatus("No Food items available");
				foodItemResponse.setStatusCode(-1);
				return foodItemResponse;
			}
			foodItemResponse.setFoodItemList(foodItemList);
			foodItemResponse.setStatus("Food items retrieved successfully");
			foodItemResponse.setStatusCode(0);
		} catch(Exception e) {
			foodItemResponse.setStatus("Exception while retrieving food items " + e);
			foodItemResponse.setStatusCode(-1);
		}
		return foodItemResponse;
	}
	
	@Override
	public OrderFoodItemResponse orderFoodItems(OrderFoodItemRequest orderFoodItemRequest) {
		OrderFoodItemResponse orderFoodItemResponse = new OrderFoodItemResponse();
		Integer totalPrice=0;
		Integer qtyPrice=0;
		try {
			HotelEntity hotelEntity = hotelRepository.findByHotelId(orderFoodItemRequest.getHotelId());
			FoodItemEntity fiEntity = foodItemsRepository.findByItemNameIgnoreCaseAndHotelId(orderFoodItemRequest.getItemName(),orderFoodItemRequest.getHotelId()); 
			qtyPrice = fiEntity.getPrice() * orderFoodItemRequest.getQty();
			totalPrice += qtyPrice;
			OrderDetailsEntity orderEntity = new OrderDetailsEntity();
			orderEntity.setAddress(orderFoodItemRequest.getAddress());
			orderEntity.setCustomerId(orderFoodItemRequest.getCustomerId());
			orderEntity.setHotelId(orderFoodItemRequest.getHotelId());
			orderEntity.setHotelName(hotelEntity.getHotelName());
			orderEntity.setItemName(orderFoodItemRequest.getItemName());
			orderEntity.setNotes(orderFoodItemRequest.getNotes());
			orderEntity.setOrderStatus(orderFoodItemRequest.getOrderStatus());
			orderEntity.setPaymentMode(orderFoodItemRequest.getPaymentMode());
			orderEntity.setPrice(totalPrice.toString());
			orderEntity.setQty(orderFoodItemRequest.getQty());
			orderEntity.setOrderTime(new Date());
			orderEntity.setItemId(fiEntity.getItemId());
			orderDetailsRepository.save(orderEntity);
			
			orderFoodItemResponse.setStatus("Order placed succeddfully");
			orderFoodItemResponse.setStatusCode(0);
			
		} catch(Exception e) {
			orderFoodItemResponse.setStatus("Exception while ordering the food " + e);
			orderFoodItemResponse.setStatusCode(-1);
		}
		
		return orderFoodItemResponse;
	}

	@Override
	public OrderDetailsResponse retriveOrderDetails(GetOrderDetailsRequest getOrderDetailsRequest) {
		OrderDetailsResponse orderDetails = new OrderDetailsResponse();
		try {
			List<OrderDetailsEntity> orderDetailsList = new ArrayList<>();
			if(getOrderDetailsRequest.getCustomerId()!=0 && getOrderDetailsRequest.getOrderId()==0) {
				orderDetailsList = orderDetailsRepository.findByCustomerId(getOrderDetailsRequest.getCustomerId());
			} else if(getOrderDetailsRequest.getCustomerId()==0 && getOrderDetailsRequest.getOrderId()!=0) {
				OrderDetailsEntity orderEntity = orderDetailsRepository.findByOrderId(getOrderDetailsRequest.getOrderId());
				orderDetailsList.add(orderEntity);
			} else if(getOrderDetailsRequest.getCustomerId()!=0 && getOrderDetailsRequest.getOrderId()!=0) {
				OrderDetailsEntity orderEntity = orderDetailsRepository.findByOrderIdAndCustomerId(getOrderDetailsRequest.getOrderId(),getOrderDetailsRequest.getCustomerId());
				orderDetailsList.add(orderEntity);
			}
			
			if(orderDetailsList.isEmpty()) {
				orderDetails.setStatus("No orders available");
				orderDetails.setStatusCode(-1);
				return orderDetails;
			}
			orderDetails.setOrderDetails(orderDetailsList);;
			orderDetails.setStatus("Order details retrieved successfully");
			orderDetails.setStatusCode(0);
		} catch(Exception e) {
			orderDetails.setStatus("Exception while retrieving order details " + e);
			orderDetails.setStatusCode(-1);
		}
		return orderDetails;
	}
	
	@Override
	public FilterHotelResponse filterHotels(FilterHotelRequest filterHotelRequest) {
		FilterHotelResponse filterHotelResponse = new FilterHotelResponse();
		try {
			List<HotelEntity> hotelList = new ArrayList<>();
			
			if("GREATER THAN EQUAL".equalsIgnoreCase(filterHotelRequest.getFilterBy().toUpperCase())) {
				hotelList = hotelRepository.findByRatingsGreaterThanEqual(filterHotelRequest.getRatings());
			} else if("LESSER THAN EQUAL".equalsIgnoreCase(filterHotelRequest.getFilterBy().toUpperCase())) {
				hotelList = hotelRepository.findByRatingsLessThanEqual(filterHotelRequest.getRatings());
			} else if("EQUAL".equalsIgnoreCase(filterHotelRequest.getFilterBy().toUpperCase())) {
				hotelList = hotelRepository.findByRatings(filterHotelRequest.getRatings());
			}
			
			if(hotelList.isEmpty()) {
				filterHotelResponse.setStatus("No hotels available");
				filterHotelResponse.setStatusCode(-1);
				return filterHotelResponse;
			}
			filterHotelResponse.setHotels(hotelList);
			filterHotelResponse.setStatus("Hotel details retrieved succuessfully");
			filterHotelResponse.setStatusCode(0);
		} catch(Exception e) {
			filterHotelResponse.setStatus("Exception while retrieving hotels " + e);
			filterHotelResponse.setStatusCode(-1);
		}
		return filterHotelResponse;
		
	}
}
