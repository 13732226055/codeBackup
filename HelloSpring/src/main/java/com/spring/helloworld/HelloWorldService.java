package com.spring.helloworld;

public class HelloWorldService {
	  
    private HelloWorld helloWorld;
  
    public HelloWorldService() {
  
    }
    
    public void setHelloWorld(HelloWorld helloWorld) { //Spring通过set方法注入本类的依赖
        this.helloWorld = helloWorld;
    }
  
    public HelloWorld getHelloWorld() {
        return this.helloWorld;
    }

  
}