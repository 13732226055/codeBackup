package com.demo.jfinal.controller;

import java.sql.SQLException;

import com.demo.jfinal.model.Blog;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.tx.Tx;

/**
 * @author jack.song
 * @time 2014年12月26日
 */
public class BlogController extends Controller {

	public void index(){
		setAttr("blogPage",getModel(Blog.class).getBlogPage(getParaToInt(0,1), 2));
		render("blogPage.ftl");
		return;
	}
	
	public void add() {
	}
	
	public void save() {
		getModel(Blog.class).save();
		redirect("/blog");
		return;
	}
	
	public void delete(){
		Blog.me.deleteById(getParaToInt(0));
		redirect("/blog");
		return;
	}
	
	public void edit(){
		setAttr("blog", Blog.me.findById(getParaToInt(0)));
		render("edit.ftl");
		return;
	}
	
	public void update(){
		getModel(Blog.class).update();
		setAttr("blog", Blog.me.findById(getPara("blog.id")));
		render("edit.ftl");
		return;
	}
	
	//测试事务
	public void testTx(){
		try {
			boolean flag = Db.tx(new IAtom() {
				public boolean run() throws SQLException {
					boolean b = getModel(Blog.class).findById(2).set("content", "test1"+System.currentTimeMillis()).update();
					int a = 1/0;
					return b;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		render("/index.ftl");
		return;
	}
	
	//测试事务
	@Before(Tx.class)
	public void testTxByAnnoation(){
		try {
			boolean b = getModel(Blog.class).findById(2).set("content", System.currentTimeMillis()).update();
			int a = 1/0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		render("/index.ftl");
		return;
	}
}
