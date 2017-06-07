package com.ruanko.model;

public class Customer {

	//参数定义
	private int id;
	private int del;
	
	private String num;
	private String name;
	private String address;
	private String tel;
	private String fax;
	private String code;
	private String bank;
	private String account;
	
	//无参构造函数
	public Customer(){
		this.id=0;
		this.del=0;
		
		this.num="";
		this.name="";
		this.address="";
		this.tel="";
		this.fax="";
		this.code="";
		this.bank="";
		this.account="";
		
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
}
