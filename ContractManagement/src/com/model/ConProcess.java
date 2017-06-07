package com.ruanko.model;

import java.util.Date;

public class ConProcess {

	//声明变量
	private int id;
	private int con_id;
	private int user_id;
	private int type;
	private int state;
	private int del;
	
	private String content;
	
	private Date time;
	
	//无参构造函数
	public ConProcess(){
		this.id=0;
		this.con_id=0;
		this.user_id=0;
		this.type=0;
		this.state=0;
		this.del=0;
		
		this.content="";
		
		this.time=new Date();
	}

	
	//get set函数
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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
