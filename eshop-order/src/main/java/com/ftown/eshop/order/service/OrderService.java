package com.ftown.eshop.order.service;

import java.util.List;

import com.ftown.eshop.order.model.OrderInfo;
import com.ftown.eshop.order.model.UserInfo;

public interface OrderService {

	public String addOrder(OrderInfo order);
	
	public String addUser(UserInfo user);
	
	public String addRateList(int hotelId);
	
	public List<UserInfo> findOrderInfo(int orderId,int start,int end);
}
