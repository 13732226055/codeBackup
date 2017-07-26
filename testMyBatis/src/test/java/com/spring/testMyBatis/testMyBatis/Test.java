package com.spring.testMyBatis.testMyBatis;

import java.io.Reader;
import java.lang.reflect.Field;
import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.builder.annotation.MapperAnnotationBuilder;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.spring.testMyBatis.testMyBatis.mappers.*;
import com.spring.testMyBatis.testMyBatis.model.Article;
import com.spring.testMyBatis.testMyBatis.model.User;

public class Test {
	
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static{
        try{
            reader    = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	public static void main(String[] args) {
        Test t = new Test();
        java.util.Date utildate = new java.util.Date();
    	Date time = new Date(utildate.getTime());	
        //t.getUserList("%");// %为sql中的通配符
    }
	
	//连表查询
	public void getUserArticles(int id) throws IllegalArgumentException, IllegalAccessException{
		SqlSession session = sqlSessionFactory.openSession();
		try{
			userMapper mapper = session.getMapper(userMapper.class);
			List<Article> result = mapper.getUserArticles(id);
			List<Article> articles = result;
            for(Article article:articles){
                System.out.println(article.getId()+":"+article.getTitle()+":"+article.getContent()+
                        ":作者是:"+article.getUser().getName()+":时间:"+
                         article.getUser().getTime());
            }
//			for(Article article : result){
//				Field fields[] = article.getClass().getDeclaredFields();
//				 for (int i = 0; i < fields.length; i++) {
//			            String filedName = fields[i].getName();
//			            // AccessibleTest类中的成员变量为private,故必须进行此操作
//			            fields[i].setAccessible(true);
//			            System.out.println(fields[i].getType()+" "+fields[i].getName()+" "+fields[i].get(article));
//				 }
//			       
//			}
		}finally {
			session.close();
		}
	}
	public void createTable(){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			userMapper mapper = session.getMapper(userMapper.class);
			String sql="Drop TABLE IF EXISTS `article`;" 
					+"Create TABLE `article` (`id` int(11) NOT NULL auto_increment,"
					+"userid` int(11) NOT NULL,`title` varchar(100) NOT NULL,"
					+"`content` text NOT NULL,PRIMARY KEY  (`id`)) "
					+"ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;";
			sql="delete from users where id = 3;";
			mapper.createTable(sql);
			session.commit();
			System.out.println("create Tabel!");
		}finally {
			session.close();
		}
	}
	
	//删除操作
	public void deleteUser(int id){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			userMapper mapper = session.getMapper(userMapper.class);
			mapper.deleteUser(id);
			session.commit();
			System.out.println("删除"+id+"用户");
		}finally {
			session.close();
		}
	}
	//更新操作
	public void updateUser(int id, String name, Date time){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setTime(time);
			
			userMapper mapper = session.getMapper(userMapper.class);
			mapper.updateUser(user);
			session.commit();
			System.out.println("为用户"+id+"修改数值："+name+","+time);
		}finally{
			session.close();
		}
	}
	//获取一条记录
	public void getUser(int id){ 
		SqlSession session = sqlSessionFactory.openSession();
        try {
            userMapper userMapper=session.getMapper(userMapper.class);
            User user = userMapper.selectUserById(1);
            
            System.out.println(user.getTime());
            System.out.println(user.getName());
            System.out.println(user.getId());
           
        } finally {
            session.close();
        }
	}
	//插入操作
    public void addUser(int id, String name) throws PersistenceException{
    	java.util.Date utildate = new java.util.Date();
    	//SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
    	Date time = new Date(utildate.getTime());
        User user=new User();
        user.setTime(time);
        user.setName(name);
        user.setId(id);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            userMapper userOperation=session.getMapper(userMapper.class);
            userOperation.addUser(user);
            session.commit();
            System.out.println("当前增加的用户 id为:"+user.getId());
        }
        finally {
            session.close();
        }
     }
    //获取多条记录
	public void getUserList(String name){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            userMapper userOperation=session.getMapper(userMapper.class);           
            List<User> users = userOperation.selectUsers(name);
            for(User user:users){
                System.out.println(user.getId()+":"+user.getName()+":"+user.getTime());
            }
            
        } finally {
            session.close();
        }
    }
}
