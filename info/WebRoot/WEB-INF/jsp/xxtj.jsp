<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>党员个人信息统计</title>
		<style type="text/css">
<!--
body {
	margin-top: 100px;
}
-->
</style>
	</head>

	<body>
		<table align="center" border="0" cellspacing="0" width="500">
			<tr height="100">
				<td colspan="2">
					<strong>党员个人信息统计 - 软件学院13级研究生党支部</strong>
				</td>
			</tr>
			<tr height="100">
				<td width="200">
					1.请先下载附件
				</td>
				<td width="300">
					<form action="download" method="post">
						<input type="submit" value="点我下载">
					</form>
				</td>
			</tr>
			<tr height="60">
				<td colspan="2">
					2.将填写好的个人信息统计文件按
					<font color="red">学号_姓名</font>方式命名提交
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<form action="upload" method="post" enctype="multipart/form-data">
						请选择要上传的文件
						<input type="file" name="upfile" size="50">
						<input type="submit" value="提交">
					</form>
				</td>
			</tr>
		</table>


	</body>
</html>
