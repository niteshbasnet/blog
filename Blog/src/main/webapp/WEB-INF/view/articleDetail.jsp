<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Article Details</title>
</head>
<body>
	Welcome ${userName}
	<h4>Title</h4>${article.title}
	<h4>Title</h4>${article.content}

	<c:forEach var="comment" items="${comments}">
		<fieldset>
			${comment.comment}
		</fieldset>
	</c:forEach>
	<form:form modelAttribute="comment"
		action="/blog/article/${article.id}/addComment" method="post">
		<fieldset>
			<p>
				<strong>Comment:</strong> <label><form:textarea
						path="comment" name="comment" rows="10" cols="30" /></label>
			</p>
			<input type="submit" value="Add" />
		</fieldset>
	</form:form>
</body>
</html>