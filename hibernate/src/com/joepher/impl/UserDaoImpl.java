package com.joepher.impl;

import java.util.List;
import org.hibernate.*;
import org.hibernate.metadata.ClassMetadata;
import com.joepher.bean.*;
import com.joepher.dao.UserDao;
import com.joepher.db.HibernateSessionFactory;

public class UserDaoImpl implements UserDao
{
	public void add(User user)
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		if (this.findByUsername(user.getUsername()) != null)
			System.out.println("已存在该用户，换一个用户名试试。。。");
		else
		{
			try
			{
				session.save(user);
				tx.commit();
				System.out.println("添加成功！");
			}
			catch (Exception e)
			{
				tx.rollback();
				System.out.println("添加失败！");
				e.printStackTrace();
			}
			finally
			{
				session.close();
			}
		}
	}

	public void delete(String username)
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		try
		{
			User user = this.findByUsername(username);

			if (user == null)
				System.out.println("不存在该记录，无法进行删除！");
			else
			{
				session.delete((User) session.get(User.class, user.getId()));
				tx.commit();
				System.out.println("删除成功");
			}
		}
		catch (Exception e)
		{
			tx.rollback();
			System.out.println("删除失败！");
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}

	public void modify(String username, User user)
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		try
		{
			User oldUser = this.findByUsername(username);

			if (oldUser == null)
				System.out.println("不存在该记录，无法进行修改操作！");
			else
			{
				User newUser = (User) session.get(User.class, oldUser.getId());
				newUser.setUsername(user.getUsername());
				newUser.setPassword(user.getPassword());
				newUser.setAge(user.getAge());

				session.update(newUser);
				tx.commit();
				System.out.println("修改成功！");
			}
		}
		catch (Exception e)
		{
			tx.rollback();
			System.out.println("修改失败！");
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public User findUser(String username, String password)
	{
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User where username = " + "'" + username + "' and password = " + "'"
				+ password + "'";
		List<User> users = (List<User>) session.createQuery(hql).list();

		if (users.size() > 0)
		{
			User user = users.get(0);
			System.out.println("ID\tUsername\t\tPassword\t\tAge");

			System.out.println(user.getId() + "\t" + user.getUsername() + "\t" + user.getPassword()
					+ "\t" + user.getAge());

			return user;
		}
		else
		{
			System.out.println("查无此记录！");
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public User findByUsername(String username)
	{
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User where username = " + "'" + username + "'";
		List<User> users = (List<User>) session.createQuery(hql).list();

		if (users.size() > 0)
		{
			User user = users.get(0);
			System.out.println("ID\tUsername\t\tPassword\t\tAge");

			System.out.println(user.getId() + "\t" + user.getUsername() + "\t" + user.getPassword()
					+ "\t" + user.getAge());

			return user;
		}
		else
		{
			System.out.println("查无此记录！");
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public User findByID(Integer id)
	{
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User where id = " + "'" + id + "'";
		List<User> users = (List<User>) session.createQuery(hql).list();

		if (users.size() > 0)
		{
			User user = users.get(0);
			System.out.println("ID\tUsername\t\tPassword\t\tAge");
			System.out.println(user.getId() + "\t" + user.getUsername() + "\t" + user.getPassword()
					+ "\t" + user.getAge());

			return user;
		}
		else
		{
			System.out.println("查无此记录！");
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll()
	{
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User";
		List<User> users = session.createQuery(hql).list();

		if (users.size() > 0)
		{
			System.out.println("ID\tUsername\t\tPassword\t\tAge");
			for (int i = 0; i < users.size(); i++)
			{
				User user = users.get(i);
				System.out.println(user.getId() + "\t" + user.getUsername() + "\t" + user.getPassword()
						+ "\t" + user.getAge());
			}

			return users;
		}
		else
		{
			System.out.println("暂无记录！");
			return null;
		}
	}

	public void findPrimaryKey()
	{
		ClassMetadata metadata = HibernateSessionFactory.getSessionFactory()
				.getClassMetadata(User.class);
		String entityName = metadata.getEntityName();
		String pkName = metadata.getIdentifierPropertyName();

		System.out.println("主键为：entityName = " + entityName + " ,pkName = " + pkName);
	}

}
