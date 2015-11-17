<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Comment</title>
<script>
   alert("asdasdas");
   var files=${json};
   var comment=files.commentobj;
   alert(comment);
</script>
</head>
<body>

<form:form  modelAttribute="comment" action="addComment" method="post">
<fieldset>
<p>
<strong>Comment:</strong> <label><form:textarea path="comment"	name="comment" rows="10" cols="30"/></label>
	</p>	
	<input type="submit" value="Add" />
	</fieldset>
</form:form>

</body>
</html>