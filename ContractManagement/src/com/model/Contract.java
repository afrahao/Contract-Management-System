package com.ruanko.model;

import java.util.Date;



public class Contract {

	//私有属性
	private int id;//ID
	private int userId;//
	private String customer;//
	private String num;//
	private String name;//
	private Date beginTime;
	private Date endTime;
	private String content;
	private int del;
	
	//无参构造方法
	public Contract(){
		this.id = 0;
		this.userId = 0;
		this.del = 0;
		
		this.customer="";
		this.num="";
		this.name="";
		this.content="";
		
		this.beginTime=new Date();
		this.endTime=new Date();
		
		
	}

	
	
	//set,get方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}
	
	
}
