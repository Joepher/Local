package com.joepher.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitHelloWorld implements BeanPostProcessor
{
	public Object postProcessBeforeInitialization(Object bean, String beanNum) throws BeansException
	{
		System.out.println("BeforeInitialization: " + beanNum);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanNum) throws BeansException
	{
		System.out.println("AfterInitialization: " + beanNum);
		return bean;
	}

}
