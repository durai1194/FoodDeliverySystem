package com.altimetrik.fooddeliverysystem.controller;

import java.io.IOException;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.altimetrik.fooddeliverysystem.model.FilterHotelRequest;
import com.altimetrik.fooddeliverysystem.model.FilterHotelResponse;
import com.altimetrik.fooddeliverysystem.model.FoodItemRequest;
import com.altimetrik.fooddeliverysystem.model.FoodItemResponse;
import com.altimetrik.fooddeliverysystem.model.GetOrderDetailsRequest;
import com.altimetrik.fooddeliverysystem.model.OrderDetailsResponse;
import com.altimetrik.fooddeliverysystem.model.OrderFoodItemRequest;
import com.altimetrik.fooddeliverysystem.model.OrderFoodItemResponse;
import com.altimetrik.fooddeliverysystem.service.FdsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/fds")
@Api(value = "FoodDeliverySystemController", tags={"Food Delivery System Controller"}, description="To Consume API endpoints in Food Delivery System Controller")
public class FdsController {
	
	@Autowired
	private FdsService fdsService;
	
	@ApiOperation(value = "RetriveFoodItems", notes = "Requires hotel name", response = FoodItemResponse.class)
	@ApiResponses({@ApiResponse(code = 200, response = FoodItemResponse.class, message = "Food Item details retrieved successfully") })
	@PostMapping("/getFoodItems")
	public  @ResponseBody FoodItemResponse retriveFoodItems(@RequestBody FoodItemRequest foodItemRequest){
		return  fdsService.retriveFoodItems(foodItemRequest);
	}
	
	@ApiOperation(value = "OrderFood", notes = "Requires food item details, customer id, address, qty", response = OrderFoodItemResponse.class)
	@ApiResponses({@ApiResponse(code = 200, response = OrderFoodItemResponse.class, message = "Food Item ordered successfully") })
	@PostMapping("/orderFoodItems")
	public  @ResponseBody OrderFoodItemResponse orderFoodItems(@RequestBody OrderFoodItemRequest orderFoodItemRequest){
		return  fdsService.orderFoodItems(orderFoodItemRequest);
	}
	
	@ApiOperation(value = "RetriveOrderDetails", notes = "Requires order id or customer id", response = OrderDetailsResponse.class)
	@ApiResponses({@ApiResponse(code = 200, response = OrderDetailsResponse.class, message = "Order details retrieved successfully") })
	@PostMapping("/getOrderDetails")
	public  @ResponseBody OrderDetailsResponse retriveOrderDetails(@RequestBody GetOrderDetailsRequest getOrderDetailsRequest){
		return  fdsService.retriveOrderDetails(getOrderDetailsRequest);
	}
	
	@ApiOperation(value = "FilterHotels", notes = "Requires Rating and filter by", response = FilterHotelResponse.class)
	@ApiResponses({@ApiResponse(code = 200, response = FilterHotelResponse.class, message = "Order details retrieved successfully") })
	@PostMapping("/filterHotels")
	public  @ResponseBody FilterHotelResponse filterHotels(@RequestBody FilterHotelRequest filterHotelRequest){
		return  fdsService.filterHotels(filterHotelRequest);
	}
}
