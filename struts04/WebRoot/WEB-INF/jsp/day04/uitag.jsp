<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>UITag</title>
	</head>

	<body>
		<s:form action="submit" namespace="/day04" method="post" theme="xhtml">
			<s:textfield label="username" name="username" required="true"
				maxlength="15" size="20" readonly="true" tooltip="username"
				tooltipIconPath="" />
			<s:password label="password" name="password" />
			<s:textarea label="Textarea" name="content" cols="19" rows="3" />

			<s:iterator value="productOptions">
				<s:checkbox label="%{label}" name="product" fieldValue="%{value}" />
			</s:iterator>

			<s:radio list="productOptions" label="radio" name="radio"
				listValue="label" listKey="value">
			</s:radio>

			<s:select list="productOptions" label="select" name="select"
				listValue="label" listKey="value" headerValue="SELECT..."
				headerKey="0">
			</s:select>

			<s:submit />
		</s:form>
	</body>
</html>