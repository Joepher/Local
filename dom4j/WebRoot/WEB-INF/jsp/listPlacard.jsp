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
		<title>listPlacard</title>
	</head>

	<body>
		<table align="center">
			<tr height="50" align="center">
				<td colspan="3">
					[${description}]${createTime}
				</td>
			</tr>

			<tr height="40" align="center" bgcolor="#CCFFFF">
				<td width="300">
					标题
				</td>
				<td width="50">
					修改
				</td>
				<td width="50">
					删除
				</td>
			</tr>

			<c:if test="${rssContent==null}">
				<tr height="30" align="center">
					<td colspan="3" bgcolor="#ffffff">
						暂无公告!
					</td>
				</tr>
			</c:if>

			<c:forEach var="form" items="${rssContent}">
				<tr height="30" bgcolor="#CCCCCC">
					<td>
						&nbsp;${form.title}
					</td>
					<td align="center">
						<a href="PlacardEditServlet?action=modify_query&id=${form.id}"
							style="text-decoration: none">修改 <!-- <img src="/WEB-INF/images/modify.gif" width="25" height="25" border="0" /> -->
						</a>
					</td>
					<td align="center">
						<a href="PlacardEditServlet?action=del&id=${form.id}"
							style="text-decoration: none">删除 <!-- <img src="/WEB-INF/images/del.gif" width="22" height="27" border="0" /> -->
						</a>
					</td>
				</tr>
			</c:forEach>

			<c:if test="${rssContent!=null}">
				<tr height="50" align="center">
					<td colspan="3">
						<a href="PlacardEditServlet?action=clearAll"
							style="text-decoration: none">[删除全部公告]</a>
					</td>
				</tr>
			</c:if>
		</table>
	</body>
</html>
