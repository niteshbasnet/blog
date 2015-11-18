<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Blog</title>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<div
		style="width: 100%; margin: auto; text-align: center; padding: 20px">
		<div style="padding-left: 200px;">
			<div style="text-align: left;">

			<spring:url var="blogcreateurl" value="/blog/createblog"></spring:url>
				<form:form modelAttribute="newblog" action="#{blogcreateurl}" method="post">
					<fieldset>
						<form:errors path="*" cssStyle="color:red;" element="div" />
						<br/>
						<table>
							<tr>

								<td style="vertical-align:top"><label for="title"><spring:message
											code="blog.title.label"  /></label></td>

								<td class="data"><form:input id="title"
										path="title" type="text" class="form-control"/> <form:errors path="title"
										cssStyle="color:red;" /><br/></td>
							</tr>
							<tr>

								<td style="vertical-align:top"><label for="blogName"><spring:message
											code="blog.blogName.label" /></label></td>

								<td ><form:input id="blogName"
										path="blogName" type="text" class="form-control"/> <form:errors path="blogName"
										cssStyle="color:red;" /><br/></td>
							</tr>
							<tr>

								<td style="vertical-align:top"><label for="description"><spring:message
											code="blog.description.label" /></label></td>

								<td class="data">
									<div>
										<form:textarea id="description" path="description" type="text" rows="5" class="form-control" />
										<form:errors path="description" cssStyle="color:red;" />
										<br/>
									</div>

								</td>
							</tr>
							
							<tr>

								<td class="label"></td>

								<td class="data">
									<div>
										<br/>									
										<input type="submit" value="Create new Blog" class = "btn btn-primary">
									</div>

								</td>
							</tr>
						</table>

					</fieldset>
				</form:form>
			</div>
		</div>
	</div>


</body>
</html>