package com.tarena.outman.day04;

import java.util.*;

import com.tarena.outman.BaseAction;
import com.tarena.outman.entity.ProductOption;

public class UITagAction extends BaseAction
{
	private String username;
	private String password;
	private List<ProductOption> productOptions;

	public String form()
	{
		productOptions = new ArrayList<ProductOption>();
		productOptions.add(new ProductOption("ONE", 1));
		productOptions.add(new ProductOption("TWO", 2));
		productOptions.add(new ProductOption("THREE", 3));

		return "success";
	}

	public String submit()
	{
		return "success";
	}

	public String getUsername()
	{
		username = "Joepher";
		password = "123456";

		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public List<ProductOption> getProductOptions()
	{
		return productOptions;
	}

	public void setProductOptions(List<ProductOption> productOptions)
	{
		this.productOptions = productOptions;
	}

}
