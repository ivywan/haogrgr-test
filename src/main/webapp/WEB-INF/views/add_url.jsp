<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="${path}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="expires" content="0">
<title>index</title>
</head>
<body>
	<form action="${path}/do/add" method="post">
		<c:forEach items="${urls}" var="url"> 
			url:<input name="url" value="${url}" style="width: 300px;" >
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			name:<input name="name" value="">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			desc:<input name="desc" value="">
			<br>
		</c:forEach>
		<input type="submit" value="提交">
	</form>
</body>
</html>