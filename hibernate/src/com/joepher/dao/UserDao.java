package com.joepher.dao;

import java.util.List;
import com.joepher.bean.*;

public interface UserDao
{
	public void add(User user);

	public void delete(String username);

	public void modify(String username, User user);

	public User findUser(String username, String password);

	public User findByUsername(String username);

	public User findByID(Integer id);

	public List<User> findAll();

	public void findPrimaryKey();
}
