package com.joepher.beanDefineInheritance;

public class HelloChild
{
	private String message1;
	private String message2;
	private String message3;

	public void getMessage1()
	{
		System.out.println("Child Message1: " + message1);
	}

	public void setMessage1(String message1)
	{
		this.message1 = message1;
	}

	public void getMessage2()
	{
		System.out.println("Child Message2: " + message2);
	}

	public void setMessage2(String message2)
	{
		this.message2 = message2;
	}

	public void getMessage3()
	{
		System.out.println("Child Message3: " + message3);
	}

	public void setMessage3(String message3)
	{
		this.message3 = message3;
	}

	public void init()
	{
		System.out.println("Bean is going through init.");
	}

	public void destroy()
	{
		System.out.println("Bean will destroy now.");
	}
}
