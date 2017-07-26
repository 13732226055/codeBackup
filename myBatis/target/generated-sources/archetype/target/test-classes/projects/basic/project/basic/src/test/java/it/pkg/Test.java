package it.pkg;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import it.pkg.mappers.*;
import it.pkg.model.User;

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
        SqlSession session = sqlSessionFactory.openSession();
        try {
            userMapper userMapper=session.getMapper(userMapper.class);
            User user = userMapper.selectUserById(1);
            
            System.out.println(user.getTime());
            System.out.println(user.getName());
        } finally {
            session.close();
        }
    }
}
