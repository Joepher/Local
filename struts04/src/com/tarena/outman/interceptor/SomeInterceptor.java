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
		// ������д����ҵ��
		System.out.println("�Զ��������������á�����");
		return actionInvocation.invoke();
	}

}
