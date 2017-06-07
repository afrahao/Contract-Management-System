package com.ruanko.model;

import java.util.Date;

public class ConState {

	//参数定义
	private int id;
	private int con_id;
	private int type;
	private int del;
	
	private Date time;
	
	//无参构造函数
	public ConState(){
		this.id=0;
		this.con_id=0;
		this.type=0;
		this.del=0;
		
		this.time=new Date();
	}

	
	
	//get set 方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCon_id() {
		return con_id;
	}

	public void setCon_id(int con_id) {
		this.con_id = con_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
}
