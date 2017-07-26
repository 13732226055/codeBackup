package com.demo.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

/**
 * @author jack.song
 * @time 2014年12月29日
 */
public class Action2Interceptor implements Interceptor {

	public void intercept(ActionInvocation arg0) {
		System.out.println("Action2: before you action");
		arg0.invoke();
		System.out.println("Action2: after you action");
	}

}
