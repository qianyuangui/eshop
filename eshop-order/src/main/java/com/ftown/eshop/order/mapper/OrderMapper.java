package com.ftown.eshop.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ftown.eshop.order.model.OrderInfo;
import com.ftown.eshop.order.model.UserInfo;

@Repository
public interface OrderMapper {

	public int addOrder(OrderInfo order);
	
	public int addUser(UserInfo user);
	
	public int addRateList(@Param("hotelId") int hotelId);
	
	public void updateRateList(@Param("hotelId")int hotelId);
	
	public List<UserInfo> selectOrderInfo(@Param("orderId")int id,@Param("start")int start,@Param("end")int end);
}
