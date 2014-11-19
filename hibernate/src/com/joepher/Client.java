package com.joepher;

import com.joepher.bean.*;
import com.joepher.dao.*;
import com.joepher.impl.*;

public class Client
{
	public static void main(String[] args)
	{
		UserDao userDao = new UserDaoImpl();

		userDao.add(new User("XF", "123456", 20));// ����������

		userDao.delete("newtest");// ɾ����¼

		userDao.modify("test", new User("XJP", "CNXJP001", 61));// �޸ļ�¼

		userDao.findUser("XJP", "CNXJP002");

		userDao.findByUsername("Lucifer");// �����û�

		userDao.findByID(1);// ����IDΪ1���û�

		userDao.findAll();// ����ȫ���û�

		userDao.findPrimaryKey();// ��������
	}
}
