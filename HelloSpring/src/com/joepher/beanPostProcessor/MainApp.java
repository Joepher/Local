package com.joepher.beanPostProcessor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
	public static void main(String[] args)
	{
		String XMLPath = "/com/joepher/beanPostProcessor/Beans.xml";
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(XMLPath);

		HelloWorld obj = (HelloWorld) context.getBean("postProcessor");
		obj.getMessage();

		context.registerShutdownHook();
	}
}
