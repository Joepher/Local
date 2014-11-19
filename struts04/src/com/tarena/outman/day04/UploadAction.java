package com.tarena.outman.day04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.IOUtils;

import com.tarena.outman.BaseAction;

public class UploadAction extends BaseAction
{
	private File some;
	private String someFileName;
	private String someContentType;
	private String imagePath;

	public String execute() throws Exception
	{
		System.out.println(some);
		System.out.println(some.length());
		System.out.println(someFileName);
		System.out.println(someContentType);

		// 随机生成文件名
		String imageName = "file_" + System.currentTimeMillis()
				+ someFileName.substring(someFileName.lastIndexOf("."));

		System.out.println(imageName);

		/*
		 * 上传文件的相对路径 链接的时候使用
		 */
		imagePath = "upload_image/" + imageName;

		/*
		 * 上传文件的绝对路径 写文件时使用
		 */
		// toRealPath()方法定义在BaseAction中
		String realImagePath = toRealPath(imagePath);
		System.out.println(realImagePath);

		// 从缓存中读取图片文件
		BufferedInputStream is = new BufferedInputStream(new FileInputStream(
				some));
		BufferedOutputStream os = new BufferedOutputStream(
				new FileOutputStream(realImagePath));
		IOUtils.copy(is, os);
		is.close();
		os.close();

		return "success";
	}

	public File getSome()
	{
		return some;
	}

	public void setSome(File some)
	{
		this.some = some;
	}

	public String getSomeFileName()
	{
		return someFileName;
	}

	public void setSomeFileName(String someFileName)
	{
		this.someFileName = someFileName;
	}

	public String getSomeContentType()
	{
		return someContentType;
	}

	public void setSomeContentType(String someContentType)
	{
		this.someContentType = someContentType;
	}

	public String getImagePath()
	{
		return imagePath;
	}

	public void setImagePath(String imagePath)
	{
		this.imagePath = imagePath;
	}

}
