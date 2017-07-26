package com.spring.impl;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.spring.helloworld.*;
import com.spring.model.City;
public class SpringHelloWorld implements HelloWorld{
	public void sayHello(){
		System.out.println(">Spring say hello");
	}

	@Cacheable("cityCache")
	public HashMap findCity(String province) {
		// TODO Auto-generated method stub
		City ci = new City();
		ci.setCityname("Hangzhou");
		System.out.println("Find");
		return ci.getCity();
	}

	@CacheEvict(value = { "cityCache"}, allEntries = true) 
	public void deleteAll(String province) {
		// TODO Auto-generated method stub
		System.out.println("Delete");
	}
}
