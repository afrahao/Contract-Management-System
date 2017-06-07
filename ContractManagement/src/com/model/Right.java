package com.ruanko.model;

public class Right {

	//参数定义
	private int id;
	private int user_id;
	private int role_id;
	private int del;
	
	private String description;
	
	//无参构造函数
	public Right(){
		this.id=0;
		this.user_id=0;
		this.role_id=0;
		this.del=0;
		
		this.description="";
	}

	
	//get set 方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
