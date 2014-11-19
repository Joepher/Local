package com.joepher.beanScope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
	public static void main(String[] args)
	{
		String XMLPath = "/com/joepher/beanScope/Beans.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(XMLPath);

		HelloWorld obj_singleton_1 = (HelloWorld) context.getBean("singleton");
		obj_singleton_1.setMessage("I'm Object obj_singleton_1");
		obj_singleton_1.getMessage();

		HelloWorld obj_singleton_2 = (HelloWorld) context.getBean("singleton");
		// obj_singleton_2.setMessage("I'm Object obj_singleton_2");
		obj_singleton_2.getMessage();

		HelloWorld obj_prototype_1 = (HelloWorld) context.getBean("prototype");
		obj_prototype_1.setMessage("I'm Object obj_prototype_1");
		obj_prototype_1.getMessage();

		HelloWorld obj_prototype_2 = (HelloWorld) context.getBean("prototype");
		// obj_prototype_2.setMessage("I'm Object obj_prototype_2");
		obj_prototype_2.getMessage();
	}

}
