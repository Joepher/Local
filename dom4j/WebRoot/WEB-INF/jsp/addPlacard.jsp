<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>Add Placard</title>
	</head>

	<body>
		<form action="PlacardAddServlet" name="form1" method="post"
			target="_self" onsubmit="return check(this)">
			<table align="center">
				<tr height="50">
					<td colspan="2" align="center">
						添加公告信息
					</td>
				</tr>
				<tr height="20">
					<td width="70">
						公告标题
					</td>
					<td width="400">
						<input name="title" type="text" id="title" size="45">
					</td>
				</tr>

				<tr>
					<td>
						公告内容
					</td>
					<td>
						<textarea name="content" rows="9" cols="40" id="content"></textarea>
					</td>
				</tr>

				<tr height="50">
					<td colspan="2" align="center">
						<input name="Submit" type="submit" class="btn_grey" value="保存">
						<input name="Submit2" type="reset" class="btn_grey" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
