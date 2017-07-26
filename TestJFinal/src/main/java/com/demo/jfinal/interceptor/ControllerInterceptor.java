package com.demo.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

/**
 * @author jack.song
 * @time 2014年12月29日
 */
public class ControllerInterceptor implements Interceptor {

	public void intercept(ActionInvocation arg0) {
		System.out.println("Controller： before you action");
		arg0.invoke();
		System.out.println("Controller：after you action");
	}

}
