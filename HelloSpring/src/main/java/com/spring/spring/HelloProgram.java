package com.spring.spring;
import com.spring.helloworld.*;
import com.spring.impl.*;
import com.spring.model.City;

import java.beans.DefaultPersistenceDelegate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class HelloProgram {
	public static void main(String[] args) {
        
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("beans.xml");
		ApplicationContext context =
              new ClassPathXmlApplicationContext("applicationContext.xml");
		
        HelloWorldService service =
             (HelloWorldService) context.getBean("helloWorldService");
        System.out.println("service bean: " + service); 
        
        HelloWorld hw= service.getHelloWorld();
        
        hw.sayHello();
        //hw.deleteAll("Zhejiang2");
        HashMap ci = hw.findCity("Zhejiang2");
        System.out.println(ci.toString());
      
        
        HashMap ci2 = hw.findCity("Zhejiang2");
        //System.out.println(ci2.toString());
        
        //hw.deleteAll("Zhejiang2");
        
        HashMap ci3 = hw.findCity("Zhejiang2");
        //System.out.println(ci2.toString());
    }
	
}
