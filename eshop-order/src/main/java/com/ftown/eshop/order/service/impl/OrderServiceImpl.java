package com.ftown.eshop.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ftown.eshop.order.mapper.OrderMapper;
import com.ftown.eshop.order.model.OrderInfo;
import com.ftown.eshop.order.model.UserInfo;
import com.ftown.eshop.order.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	public String addOrder(OrderInfo order) {
		orderMapper.addOrder(order);
		//再次插入一条数据
		OrderInfo other = new OrderInfo();
		other.setDescri("abcd");
		orderMapper.addOrder(other);
		return "success";
	}
	
	public String addRateList(int hotelId) {
		//先更新 再插入
		orderMapper.updateRateList(hotelId);
		orderMapper.addRateList(hotelId);
		return "success";
	}

	public List<UserInfo> findOrderInfo(int orderId,int start,int end) {
		return orderMapper.selectOrderInfo(orderId,start,end);
	}

	@Override
	public String addUser(UserInfo user) {
		orderMapper.addUser(user);
		return "success";
	}


}
