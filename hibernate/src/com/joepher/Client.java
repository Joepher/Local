package com.joepher;

import com.joepher.bean.*;
import com.joepher.dao.*;
import com.joepher.impl.*;

public class Client
{
	public static void main(String[] args)
	{
		UserDao userDao = new UserDaoImpl();

		userDao.add(new User("XF", "123456", 20));// 插入新数据

		userDao.delete("newtest");// 删除记录

		userDao.modify("test", new User("XJP", "CNXJP001", 61));// 修改记录

		userDao.findUser("XJP", "CNXJP002");

		userDao.findByUsername("Lucifer");// 查找用户

		userDao.findByID(1);// 查找ID为1的用户

		userDao.findAll();// 查找全部用户

		userDao.findPrimaryKey();// 查找主键
	}
}
