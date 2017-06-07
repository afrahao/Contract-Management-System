package com.ruanko.utils;

/*
 * 
 * */

public class AppException extends Exception{

	//私有属性
	private int exceptionCode;//异常编号
	private String message;//异常内容
	
	/*构造方法
	 * 
	 * */
	public AppException(String message){
		this.message=message;
	}
	/*构造方法
	 * 
	 * */
	public AppException(String message,int exceptionCode){
		this.exceptionCode=exceptionCode;
		this.message=message;
	}
	//方法
	public int getExceptionCode(){
		return exceptionCode;
	}
	
	public String getMessage(){
		String detailMessage;
		detailMessage=exceptionCode+" "+message;
		return detailMessage;
	}
	
}
