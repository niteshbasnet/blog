<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Sign Up</title>
</head>
<body>

	<div
		style="width: 100%; margin: auto; text-align: center; padding: 20px">
		<div style="padding-left: 200px; padding-bottom:50px;" >
			<div style="text-align: left;" >


				<form:form modelAttribute="user" action="${flowExecutionUrl}"
					enctype="multipart/form-data">
					<fieldset>
					<%-- <input type="hidden" name="_flowExecutionId" value="<c:out value="${flowExecutionId}"/>"/> --%>
						<form:errors path="*" cssStyle="color:red;" element="div" />
						<table>
							<tr>

								<td ><label for="firstName"><spring:message
											code="register.firsname.label" /></label></td>

								<td class="data"><form:input id="firstName" class="form-control"
										path="firstName" type="text" /> <form:errors path="firstName" 
										cssStyle="color:red;" /></td>
							</tr>

							<tr>

								<td><label for="lastName"><spring:message
											code="register.lastname.label" /></label></td>

								<td class="data">
									<div>
										<form:input id="lastName" path="lastName" type="text" class="form-control" />
										<form:errors path="lastName" cssStyle="color:red;" />
									</div>

								</td>
							</tr>

							<tr>

								<td ><label for="birthDate"><spring:message
											code="register.birthdate.label" /></label></td>

								<td class="data">

									<div>
										<form:input id="birthDate" path="birthDate" type="text" class="form-control" />
										<form:errors path="birthDate" cssStyle="color:red;" />
									</div>
								</td>
							</tr>
							
							<tr>

								<td ><label for="bio"><spring:message
											code="register.bio.label" /></label></td>

								<td class="data">
									<div>
										<form:textarea id="bio" path="bio" type="text" rows="5" class="form-control" />
										<form:errors path="bio" cssStyle="color:red;" />
									</div>

								</td>
							</tr>
							
							<tr>

								<td ><label for="email"><spring:message
											code="register.email.label" /></label></td>

								<td class="data">

									<div>
										<form:input id="email" path="email" type="text" class="form-control" />
										<form:errors path="email" cssStyle="color:red;" />
									</div>
								</td>
							</tr>

							<tr>

								<td ><label for="userImage"><spring:message
											code="register.userimage.label" /></label></td>

								<td class="data">
									<div>
										<form:input id="userImage" path="userImage" type="file" class="form-control"/>
									</div>

								</td>
							</tr>
							<tr>

								<td ><label for="username"><spring:message
											code="register.credential.username.label" /></label></td>

								<td class="data">
									<div>
										<form:input id="username"
											path="username" type="text" />
										<form:errors path="username" cssStyle="color:red;" />
										<form:hidden path="enabled" value="True"/>
										<form:hidden path="authority" value="ROLE_USER"/>
									</div>

								</td>
							</tr>
							<tr>

								<td class="label"><label for="password"><spring:message
											code="register.credential.password.label" /></label></td>

								<td class="data">
									<div>
										<form:input id="password"
											path="password" type="password" />
										<form:errors path="password" cssStyle="color:red;" />
									</div>

								</td>
							</tr>
						</table>
<br/>
						<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
						<table width="50%" border="0" cellspacing="3" cellpadding="1">
							<tr>
								<td>
									<button type="submit" id="next" name="_eventId_next" class = "btn btn-primary">
										<spring:message code="next" />
									</button>
								</td>
								<td>
									<button type="submit" id="save" name="_eventId_save" class = "btn btn-primary">
										<spring:message code="save" />
									</button>
								</td>
								<td>
									<button type="submit" id="cancel" name="_eventId_cancel" class = "btn btn-primary">
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