package com.joepher.beanLifeCycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
	public static void main(String[] args)
	{
		String XMLPath = "/com/joepher/beanLifeCycle/Beans.xml";
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(XMLPath);

		HelloWorld obj_1 = (HelloWorld) context.getBean("lifeCycle_1");
		obj_1.getMessage();

		HelloWorld obj_2 = (HelloWorld) context.getBean("lifeCycle_2");
		obj_2.getMessage();

		context.registerShutdownHook();
	}
}
