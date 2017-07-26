package com.test1111.mappers;

import java.util.List;

import com.test1111.model.*;

public interface userMapper {
	public User selectUserById(int id);
	public List<User> selectUsers(String name);
	public void addUser(User user);  
	public void updateUser(User user);
	public void deleteUser(int id);
	public void createTable(String sqlstring);
	public List<Article> getUserArticles(int id);
}
