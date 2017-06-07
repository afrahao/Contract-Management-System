package com.ruanko.utils;

public class AppExceptionTest {

	public static void execute(String a)throws AppException{
		if("false".equals(a)){
			throw new AppException(
					"com.ruanko.utils.AppExceptionTest.execute:Parameter cannot be false");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			execute("false");
		}catch(AppException e){
			e.printStackTrace();
		}
	}

}
