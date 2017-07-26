package com.spring.springmvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	@RequestMapping("/hello")
	public ModelAndView hello(Model model){
		model.addAttribute("greeting","hello spring mvc");
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("helloworld");
        
        //设置返回结果
        //modelAndView.addObject("monitorName", monitor.get("name"));
        //modelAndView.addObject("infos", infoList);
        modelAndView.addObject("greeting", "hello string mvc");
		System.out.println(this.getClass().getResource("/"));
		System.out.println(model.getClass().getName());
		return modelAndView;
	}
	public static void test1(){  
        ApplicationContext ctx=new ClassPathXmlApplicationContext("com/spring/springmvc/.xml");  
        System.out.println(ctx.containsBean("person0"));  
    }  
}
