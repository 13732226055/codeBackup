package com.demo.jfinal.config;

import java.util.Properties;

import com.demo.jfinal.controller.BlogController;
import com.demo.jfinal.controller.HelloController;
import com.demo.jfinal.interceptor.GlobalInterceptor;
import com.demo.jfinal.model.Blog;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.FreeMarkerRender;
import com.jfinal.render.ViewType;

/**
 * @author jack.song
 * @time 2014年12月26日
 */
public class DemoConfig extends JFinalConfig{

	@Override
	public void configConstant(Constants arg0) {
		arg0.setDevMode(true);
		arg0.setBaseViewPath("template");
		arg0.setFreeMarkerViewExtension(".ftl");
	}

	@Override
	public void configHandler(Handlers arg0) {
		arg0.add(new ContextPathHandler("base"));
	}

	@Override
	public void configInterceptor(Interceptors arg0) {
		arg0.add(new GlobalInterceptor());
	}

	@Override
	public void configPlugin(Plugins me) {
		loadPropertyFile("common_config.txt");
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"),
		getProperty("user"), getProperty("password"));
		me.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("blog", Blog.class);
	}

	@Override
	public void configRoute(Routes arg0) {
		arg0.add("/", HelloController.class);
		arg0.add("/blog", BlogController.class);
	}
	
	public void afterJFinalStart() {
	  Properties p = loadPropertyFile("freemarker.properties");
	  FreeMarkerRender.setProperties(p);
	}
	/**
	 * 建议使用 JFinal 手册推荐的方式启动项目
	 * 运行此 main 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
	 */
	public static void main(String[] args) {
		JFinal.start("src/main/webapp", 80, "/", 5);
	}
}
