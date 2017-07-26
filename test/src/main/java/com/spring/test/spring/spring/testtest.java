package com.spring.test.spring.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.test.spring.server.test;
import com.spring.test.spring.server.testservice;

public class testtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context =
	              new ClassPathXmlApplicationContext("applicationContext.xml");
		
		testservice mss = (testservice)context.getBean("testservice");
		test ms			=	mss.gettest();
		String result		=	ms.read("test");
		if(ms.updata("test")>0){
			System.out.println("Updata!");
		}
		ms.function();
	}

}
