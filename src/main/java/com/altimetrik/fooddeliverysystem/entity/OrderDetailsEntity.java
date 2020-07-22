package com.altimetrik.fooddeliverysystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "order_details")
public class OrderDetailsEntity {
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="order_id_seq_gen")
	@SequenceGenerator(name="order_id_seq_gen", sequenceName="order_id_seq", allocationSize = 1)
	private Integer orderId;
	@Column(name = "hotel_id")
	private Integer hotelId;
	@Column(name = "hotel_name")
	private String hotelName;
	@Column(name = "address")
	private String address;
	@Column(name = "notes")
	private String notes;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "transaction_time")
	private Date orderTime;
	@Column(name = "customer_id")
	private Integer customerId;
	@Column(name = "payment_mode")
	private String paymentMode;
	@Column(name = "order_status")
	private String orderStatus;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "item_id")
	private Integer itemId;
	@Column(name = "qty")
	private Integer qty;
	@Column(name = "price")
	private String price;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	

}
