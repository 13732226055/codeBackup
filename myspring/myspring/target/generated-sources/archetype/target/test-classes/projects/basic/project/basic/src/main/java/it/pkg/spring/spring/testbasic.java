package it.pkg.spring.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.pkg.spring.server.basic;
import it.pkg.spring.server.basicservice;

public class testbasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context =
	              new ClassPathXmlApplicationContext("applicationContext.xml");
		
		basicservice mss = (basicservice)context.getBean("basicservice");
		basic ms			=	mss.getbasic();
		String result		=	ms.read("test");
		if(ms.updata("test")>0){
			System.out.println("Updata!");
		}
		ms.function();
	}

}
