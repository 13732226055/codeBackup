package com.demo.jfinal.interceptor;

import com.jfinal.aop.InterceptorStack;

/**
 * @author jack.song
 * @time 2014年12月29日
 */
public class ActionInterceptorStack extends InterceptorStack{

	@Override
	public void config() {
		addInterceptors(new ActionInterceptor(),new Action2Interceptor());	
	}

}
