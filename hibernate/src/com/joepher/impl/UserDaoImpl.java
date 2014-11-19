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
			System.out.println("�Ѵ��ڸ��û�����һ���û������ԡ�����");
		else
		{
			try
			{
				session.save(user);
				tx.commit();
				System.out.println("��ӳɹ���");
			}
			catch (Exception e)
			{
				tx.rollback();
				System.out.println("���ʧ�ܣ�");
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
				System.out.println("�����ڸü�¼���޷�����ɾ����");
			else
			{
				session.delete((User) session.get(User.class, user.getId()));
				tx.commit();
				System.out.println("ɾ���ɹ�");
			}
		}
		catch (Exception e)
		{
			tx.rollback();
			System.out.println("ɾ��ʧ�ܣ�");
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
				System.out.println("�����ڸü�¼���޷������޸Ĳ�����");
			else
			{
				User newUser = (User) session.get(User.class, oldUser.getId());
				newUser.setUsername(user.getUsername());
				newUser.setPassword(user.getPassword());
				newUser.setAge(user.getAge());

				session.update(newUser);
				tx.commit();
				System.out.println("�޸ĳɹ���");
			}
		}
		catch (Exception e)
		{
			tx.rollback();
			System.out.println("�޸�ʧ�ܣ�");
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
			System.out.println("���޴˼�¼��");
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
			System.out.println("���޴˼�¼��");
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
			System.out.println("���޴˼�¼��");
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
			System.out.println("���޼�¼��");
			return null;
		}
	}

	public void findPrimaryKey()
	{
		ClassMetadata metadata = HibernateSessionFactory.getSessionFactory()
				.getClassMetadata(User.class);
		String entityName = metadata.getEntityName();
		String pkName = metadata.getIdentifierPropertyName();

		System.out.println("����Ϊ��entityName = " + entityName + " ,pkName = " + pkName);
	}

}
