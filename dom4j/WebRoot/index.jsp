<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>Index</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		<!-- 
		<a href="/dom4j/IndexServlet">发布新通知</a>
		-->
		<table align="center">
			<tr height="200" align="center">
				<td width="100">
					<a href="IndexServlet" style="text-decoration: none"
						target="_blank">发布新通知</a>
				</td>
				<td width="100">
					<a href="PlacardEditServlet?action=query"
						style="text-decoration: none" target="_blank">查看通知</a>
				</td>
			</tr>
		</table>
	</body>
</html>
