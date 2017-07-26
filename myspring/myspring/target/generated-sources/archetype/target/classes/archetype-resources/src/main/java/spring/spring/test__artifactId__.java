#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.spring.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ${package}.spring.server.${artifactId};
import ${package}.spring.server.${artifactId}service;

public class test${artifactId} {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context =
	              new ClassPathXmlApplicationContext("applicationContext.xml");
		
		${artifactId}service mss = (${artifactId}service)context.getBean("${artifactId}service");
		${artifactId} ms			=	mss.get${artifactId}();
		String result		=	ms.read("test");
		if(ms.updata("test")>0){
			System.out.println("Updata!");
		}
		ms.function();
	}

}
