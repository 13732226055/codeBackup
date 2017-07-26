package com.spring.helloworld;

import java.util.HashMap;

import com.spring.model.City;

public interface HelloWorld {
	public void sayHello();
	public abstract HashMap findCity(String province);
	public abstract void deleteAll(String province);
}


