package com.joepher.beanFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
	public static void main(String[] args)
	{
		String XMLPath = "/com/joepher/beanFactory/Beans.xml";
		
		ApplicationContext context = new ClassPathXmlApplicationContext(XMLPath);
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

		// XmlBeanFactory factory = new XmlBeanFactory(newClassPathResource(xMLPath));
		// HelloWorld obj=(HelloWorld)factory.getBean("helloWorld");

		obj.getMessage();
	}
}
