package com.demo.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

/**
 * @author jack.song
 * @time 2014年12月29日
 */
public class GlobalInterceptor implements Interceptor {

	public void intercept(ActionInvocation arg0) {
		System.out.println("Global: before you action");
		System.out.println("getViewPath: "+arg0.getViewPath());
		arg0.invoke();
		System.out.println("Global: after you action");
	}

}
