<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Article</title>
</head>
<body>
	<form:form modelAttribute="article" enctype="multipart/form-data" method="post">
		<fieldset>
			<div>
				<p>
					<strong>Title:</strong> <label><form:input path="title"	name="title" /></label>
				</p>
				
				<p>
					<strong>Content:</strong> <label><form:textarea path="content"	name="content" rows="10" cols="50"/></label>
				</p>				
				
				<p>
					<form:input path="articleImg" type="file" />
				</p>
				
				<p>
					<strong>Tags:</strong> <label><form:input path="tags"	name="tags" /></label>
				</p>
				
				<input type="submit" value="Add" />
			</div>
		</fieldset>
	</form:form>
</body>
</html>