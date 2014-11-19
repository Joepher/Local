<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>modifyPlacard</title>
	</head>

	<body>
		<form action="PlacardEditServlet?action=modify" name="form1"
			method="post">
			<c:set var="form" value="${placardContent}"></c:set>
			<table align="center">
				<tr height="50">
					<td width="100">
						公告标题
					</td>
					<td width="450">
						<input name="title" type="text" id="title" value="${form.title}"
							size="50">
						<input name="id" type="hidden" id="id" value="${form.id}" size="5">
					</td>
				</tr>

				<tr height="170">
					<td>
						公告内容
					</td>
					<td>
						<textarea name="content" id="content" rows="10" cols="45">${form.content}</textarea>
					</td>
				</tr>

				<tr height="50" align="center">
					<td colspan="3">
						<input name="Submit" type="submit" class="btn_grey" value="保存">
						<input name="Submit2" type="reset" class="btn_grey" value="重置">
						<input name="Submit3" type="button" class="btn_grey" value="后退"
							onClick=
	history.back(-1);
>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
