package com.joepher.beanDefineInheritance;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
	public static void main(String[] args)
	{
		String XMLPath = "/com/joepher/beanDefineInheritance/Beans.xml";
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(XMLPath);

		HelloParent objParent = (HelloParent) context.getBean("parent");
		objParent.getMessage1();
		objParent.getMessage2();

		HelloChild objChild = (HelloChild) context.getBean("child");
		objChild.getMessage1();
		objChild.getMessage2();
		objChild.getMessage3();

		HelloChild objChildBean = (HelloChild) context.getBean("bean");
		objChildBean.getMessage1();
		objChildBean.getMessage2();
		objChildBean.getMessage3();

		context.registerShutdownHook();
	}
}
