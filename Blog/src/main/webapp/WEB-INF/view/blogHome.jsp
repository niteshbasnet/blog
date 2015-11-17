<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<c:forEach var="article" items="${articles}">
		<a href="<spring:url value="/article/articleDetail/${article.id}"/>">${article.title}</a><br/>
		Date: ${article.date}
		<br/>tags : [
		<c:forEach var="tag" items="${article.tags}">
			<a href="<spring:url value="/article/tag/${tag}"/>"> #${tag}</a>,		
		</c:forEach>
		]<br/><br/>
	</c:forEach>
</body>
</html>