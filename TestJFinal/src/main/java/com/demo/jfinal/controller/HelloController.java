package com.demo.jfinal.controller;

import com.demo.jfinal.interceptor.ActionInterceptor;
import com.demo.jfinal.interceptor.ActionInterceptorStack;
import com.demo.jfinal.interceptor.ControllerInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.aop.ClearInterceptor;
import com.jfinal.aop.ClearLayer;
import com.jfinal.core.Controller;

/**
 * @author jack.song
 * @time 2014年12月26日
 */
@Before(ControllerInterceptor.class)//controller级别拦截器
public class HelloController extends Controller {

	@Before(ActionInterceptor.class)
	@ClearInterceptor
	public void index(){
		render("/index.ftl");
		return;
	}
	
	@Before(ActionInterceptorStack.class)
	public void testInterceptorStack(){
		render("/index.ftl");
		return;
	}
	
	@ClearInterceptor(ClearLayer.ALL)
	public void testJson(){
		int a = getParaToInt("a");
		String b = getPara("b");
		System.out.println(a+"--"+b);
		setAttr("a", a);
		setAttr("b", b);
		renderJson();
		return;
	}
}
