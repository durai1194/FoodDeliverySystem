package com.altimetrik.fooddeliverysystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.altimetrik.fooddeliverysystem.dao.FdsDAO;
import com.altimetrik.fooddeliverysystem.model.FilterHotelRequest;
import com.altimetrik.fooddeliverysystem.model.FilterHotelResponse;
import com.altimetrik.fooddeliverysystem.model.FoodItemRequest;
import com.altimetrik.fooddeliverysystem.model.FoodItemResponse;
import com.altimetrik.fooddeliverysystem.model.GetOrderDetailsRequest;
import com.altimetrik.fooddeliverysystem.model.OrderDetailsResponse;
import com.altimetrik.fooddeliverysystem.model.OrderFoodItemRequest;
import com.altimetrik.fooddeliverysystem.model.OrderFoodItemResponse;

@Service
public class FdsServiceImpl implements FdsService {

	@Autowired
	private FdsDAO fdsDao;
	
	@Override
	public FoodItemResponse retriveFoodItems(FoodItemRequest foodItemRequest) {
		FoodItemResponse foodItemResponse = new FoodItemResponse();
		
		foodItemResponse = fdsDao.retriveFoodItems(foodItemRequest);
		
		return foodItemResponse;
	}

	@Override
	public OrderFoodItemResponse orderFoodItems(OrderFoodItemRequest orderFoodItemRequest) {
		OrderFoodItemResponse orderFoodItemResponse = new OrderFoodItemResponse();
		if(StringUtils.isEmpty(orderFoodItemRequest.getCustomerId()) || StringUtils.isEmpty(orderFoodItemRequest.getItemName()) || orderFoodItemRequest.getHotelId()==0
				|| StringUtils.isEmpty(orderFoodItemRequest.getOrderStatus()) || StringUtils.isEmpty(orderFoodItemRequest.getPaymentMode())
				|| StringUtils.isEmpty(orderFoodItemRequest.getAddress()) || orderFoodItemRequest.getQty()==0){
					orderFoodItemResponse.setStatusCode(-1);
					orderFoodItemResponse.setStatus("Customer id, food item name, qty, hotel id/name, order status,payment mode,address fields are mandtory");
					return orderFoodItemResponse;
		} else {
			orderFoodItemResponse = fdsDao.orderFoodItems(orderFoodItemRequest);
		}
		return orderFoodItemResponse;
	}
	
	@Override
	public OrderDetailsResponse retriveOrderDetails(GetOrderDetailsRequest getOrderDetailsRequest) {
		OrderDetailsResponse orderDetails = new OrderDetailsResponse();
		if(getOrderDetailsRequest.getOrderId()==0 && getOrderDetailsRequest.getCustomerId()==0) {
			orderDetails.setStatus("Order id or customer id is mandatory");
			orderDetails.setStatusCode(-1);
			return orderDetails;
		}
		orderDetails = fdsDao.retriveOrderDetails(getOrderDetailsRequest);
		
		return orderDetails;
	}
	
	@Override
	public FilterHotelResponse filterHotels(FilterHotelRequest filterHotelRequest) {
		FilterHotelResponse filterHotelResponse = new FilterHotelResponse();
		if(StringUtils.isEmpty(filterHotelRequest.getFilterBy())) {
			filterHotelResponse.setStatus("Filter by field is mandatory");
			filterHotelResponse.setStatusCode(-1);
			return filterHotelResponse;
		}
		filterHotelResponse = fdsDao.filterHotels(filterHotelRequest);
		
		return filterHotelResponse;
	}

}
