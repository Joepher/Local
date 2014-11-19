<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
	<head>
		<title>UploadForm</title>
	</head>

	<body>
		<h1>
			文件上传
		</h1>
		<s:form action="upload" method="post" theme="xhtml"
			enctype="multipart/form-data">
			<s:file label="File" name="some" />
			<s:submit value="Upload" />
		</s:form>
	</body>
</html>
