package com.tarena.outman.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SomeInterceptor implements Interceptor
{
	private static final long serialVersionUID = -1981124197242909465L;

	public void destroy()
	{
	}

	public void init()
	{
	}

	public String intercept(ActionInvocation actionInvocation) throws Exception
	{
		// 在这里写拦截业务
		System.out.println("自定义拦截器被调用。。。");
		return actionInvocation.invoke();
	}

}
