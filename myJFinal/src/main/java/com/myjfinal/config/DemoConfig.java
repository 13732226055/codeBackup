package com.myjfinal.config;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.myjfinal.controller.HelloController;
public class DemoConfig extends JFinalConfig {
	public void configConstant(Constants me) {
		me.setDevMode(true);
	}
	public void configRoute(Routes me) {
		me.add("/hello", HelloController.class);
	}
	public void configPlugin(Plugins me) {}
	public void configInterceptor(Interceptors me) {}
	public void configHandler(Handlers me) {}
	
}