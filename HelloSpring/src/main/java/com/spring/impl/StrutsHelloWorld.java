package com.spring.impl;



import com.spring.helloworld.HelloWorld;
import com.spring.model.City;

public class StrutsHelloWorld implements HelloWorld{
	public void sayHello(){
		System.out.println("Struts say hello");
	}

	@Override
	public City findCity(String province) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(String province) {
		// TODO Auto-generated method stub
		
	}
	

}
