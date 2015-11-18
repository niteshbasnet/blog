<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<body></body>
</head>
<body>

<div class="container">
<security:authorize access="isAuthenticated()">

<c:forEach var="blog" items="${userBlogs}">
		<a href="<spring:url value="/blog/${blog.blogName}"/>">${blog.blogName}</a><br/>
		<br/>
		
		Description : ${blog.description}"
		<br/>
		<hr>
	</c:forEach>
</security:authorize>

<security:authorize access="isAnonymous()">
<c:forEach var="article" items="${articles}">
		<a href="<spring:url value="/article/articleDetail/${article.id}"/>">${article.title}</a><br/>
		Date: ${article.date}
		<br/>tags : [
		<c:forEach var="tag" items="${article.tags}">
			<a href="<spring:url value="/article/tag/${tag}"/>"> #${tag}</a>,		
		</c:forEach>
		]<br/><br/>
	</c:forEach>
</security:authorize>

</div>	
</body>
</html>