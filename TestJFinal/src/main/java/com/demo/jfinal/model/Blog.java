package com.demo.jfinal.model;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

/**
 * @author jack.song
 * @time 2014年12月26日
 */
public class Blog extends Model<Blog> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Blog me = new Blog();
	
	public Page<Blog> getBlogPage(int start,int size){
		return paginate(start, size, "select * ", " from blog order by id desc");
	}
}
