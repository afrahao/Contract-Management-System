package com.ruanko.model;

public class User {

	//参数定义
	private int id;
	private int del;
	
	private String name;
	private String password;
	
	//无参构造函数
	public User(){
		this.id=0;
		this.del=0;
		
		this.name="";
		this.password="";
	}

	
	
	//get set方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
