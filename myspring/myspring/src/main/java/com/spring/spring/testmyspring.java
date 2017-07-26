package com.spring.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.server.myspring;
import com.spring.server.myspringservice;

public class testmyspring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context =
	              new ClassPathXmlApplicationContext("applicationContext.xml");
		
		myspringservice mss = (myspringservice)context.getBean("myspringservice");
		myspring ms			=	mss.getmyspring();
		String result		=	ms.read("test");
		if(ms.updata("test")>0){
			System.out.println("Updata!");
		}
		ms.function();
	}

}
