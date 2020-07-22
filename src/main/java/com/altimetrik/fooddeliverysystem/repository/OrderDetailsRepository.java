package com.altimetrik.fooddeliverysystem.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetrik.fooddeliverysystem.entity.OrderDetailsEntity;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Serializable>  {
	OrderDetailsEntity findByOrderId(Integer orderId);
	OrderDetailsEntity findByOrderIdAndCustomerId(Integer orderId, Integer customerId);
	List<OrderDetailsEntity> findByCustomerId(Integer customerId);

}
