<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

	<div class="body">
		<div class="article">
			<h3>${article.title}</h3>
			<h4>Content</h4>${article.content}
		</div>
		<div class="comment">
			<c:forEach var="comment" items="${comments}">
				<fieldset>
					<p>${comment.comment}</p>
					<br />
					<p>${comment.date}</p>

				</fieldset>
			</c:forEach>
		</div>

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

	</div>
</body>
</html>