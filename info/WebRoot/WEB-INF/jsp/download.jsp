<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.net.URLEncoder"%>

<%
	String fileName = "党员信息统计.xls";
	String fileDisplayName = URLEncoder.encode(fileName, "UTF-8");
	String filePath = "E:/MyEclipseWorkSpace/info/WebRoot/WEB-INF/file/";
	byte[] buffer = new byte[1024 * 1024];
	int n = 0;

	out.clear();
	response.reset();
	response.setHeader("Content-Disposition", "attachment;filename=" + fileDisplayName);
	response.setContentType("application/x-download");

	OutputStream os = response.getOutputStream();
	try
	{
		FileInputStream input = new FileInputStream(new File(filePath + fileName));
		try
		{
			while ((n = input.read(buffer)) != -1)
			{
				os.write(buffer, 0, n);
			}
		}
		finally
		{
			input.close();
		}
	}
	finally
	{
		os.close();
	}
%>