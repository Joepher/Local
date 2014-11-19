package com.joepher.beanInject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
	public static void main(String[] args)
	{
		String XMLPath = "/com/joepher/beanInject/Beans.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(XMLPath);

		TextEditor te = (TextEditor) context.getBean("textEditor");
		te.spellCheck();
	}

}
