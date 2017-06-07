package com.ruanko.model;

public class Role {

	//参数定义
	private int id;
	private int del;
	
	private String name;
	private String description;
	private String function_ids;
	
	//无参构造函数
	public Role(){
		this.id=0;
		this.del=0;
		
		this.name="";
		this.description="";
		this.function_ids="";
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFunction_ids() {
		return function_ids;
	}

	public void setFunction_ids(String function_ids) {
		this.function_ids = function_ids;
	}
}
