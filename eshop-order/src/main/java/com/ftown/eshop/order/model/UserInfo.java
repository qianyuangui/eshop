package com.ftown.eshop.order.model;

import java.util.Date;

public class UserInfo {

//	  `id` bigint(20) NOT NULL,
//	  `name` varchar(64) DEFAULT NULL COMMENT '名称',
//	  `city_id` int(12) DEFAULT NULL COMMENT '城市',
//	  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
//	  `phone` varchar(32) DEFAULT NULL COMMENT '电话',
//	  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
//	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
//	  `password` varchar(32) DEFAULT NULL COMMENT '密码',
	
	private long id;
	private String name;
	private int cityId;
	private int sex;
	private String phone;
	private String email;
	private Date createTime;
	private String password;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
