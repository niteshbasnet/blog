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

</head>
<body>

<div
		style="width: 100%; margin: auto; text-align: center; padding: 20px">
		<div style="padding-left: 200px; width: 800px">
			<div style="text-align: left;">


				<form:form modelAttribute="newblog" action="${flowExecutionUrl}">
					<fieldset>
						<form:errors path="*" cssStyle="color:red;" element="div" />
						<table>
							<tr>

								<td class="label"><label for="title"><spring:message
											code="blog.title.label" /></label></td>

								<td class="data"><form:input id="title"
										path="title" type="text" class="form-control" /> <form:errors path="title"
										cssStyle="color:red;" /></td>
							</tr>
							<tr>

								<td class="label"><label for="blogName"><spring:message
											code="blog.blogName.label" /></label></td>

								<td class="data"><form:input id="blogName"
										path="blogName" type="text" /> <form:errors path="blogName"
										cssStyle="color:red;" /></td>
							</tr>
							<tr>

								<td class="label"><label for="description"><spring:message
											code="blog.description.label" /></label></td>

								<td class="data">
									<div>
										<form:textarea id="description" path="description" type="text" rows="5" />
										<form:errors path="description" cssStyle="color:red;" />
									</div>

								</td>
							</tr>
						</table>
						<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
						<table width="45%" border="0" cellspacing="3" cellpadding="1">
							<tr>
								<td>
									<button type="submit" id="previous" name="_eventId_previous">
										<spring:message code="previous" />
									</button>
								</td>
								<td>
									<button type="submit" id="save" name="_eventId_save">
										<spring:message code="save" />
									</button>
								</td>
								<td>
									<button type="submit" id="cancel" name="_eventId_cancel">
										<spring:message code="cancel" />
									</button>
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