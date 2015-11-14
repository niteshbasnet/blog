<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign Up</title>
</head>
<body>

	<div
		style="width: 100%; margin: auto; text-align: center; padding: 20px">
		<div style="padding-left: 200px">
			<div style="text-align: left;">


				<form:form modelAttribute="newUser" action="Registration"
					enctype="multipart/form-data">
					<fieldset>

						<form:errors path="*" cssStyle="color:red;" element="div" />
						<table>
							<tr>

								<td class="label"><label for="firstName"><spring:message
											code="register.firsname.label" /></label></td>

								<td class="data"><form:input id="firstName"
										path="firstName" type="text" /> <form:errors path="firstName"
										cssStyle="color:red;" /></td>
							</tr>

							<tr>

								<td class="label"><label for="lastName"><spring:message
											code="register.lastname.label" /></label></td>

								<td class="data">
									<div>
										<form:input id="lastName" path="lastName" type="text" />
										<form:errors path="lastName" cssStyle="color:red;" />
									</div>

								</td>
							</tr>

							<tr>

								<td class="label"><label for="birthDate"><spring:message
											code="register.birthdate.label" /></label></td>

								<td class="data">

									<div>
										<form:input id="birthDate" path="birthDate" type="text" />
										<form:errors path="birthDate" cssStyle="color:red;" />
									</div>
								</td>
							</tr>

							<tr>

								<td class="label"><label for="email"><spring:message
											code="register.email.label" /></label></td>

								<td class="data">

									<div>
										<form:input id="email" path="email" type="text" />
										<form:errors path="email" cssStyle="color:red;" />
									</div>
								</td>
							</tr>

							<tr>

								<td class="label"><label for="phonenumber"><spring:message
											code="register.phonenumber.label" /></label></td>

								<td class="data">

									<div>
										<form:input id="phonenumber" path="phonenumber" type="text" />
										<form:errors path="phonenumber" cssStyle="color:red;" />
									</div>
								</td>
							</tr>
							<tr>

								<td class="label"><label for="userImage"><spring:message
											code="register.userimage.label" /></label></td>

								<td class="data">
									<div>
										<form:input id="userImage" path="userImage" type="file" />
									</div>

								</td>
							</tr>
							<tr>

								<td class="label"><label for="credential.username"><spring:message
											code="register.credential.username.label" /></label></td>

								<td class="data">
									<div>
										<form:input id="credential.username"
											path="credential.username" type="text" />
										<form:errors path="credential.username" cssStyle="color:red;" />
									</div>

								</td>
							</tr>
							<tr>

								<td class="label"><label for="credential.password"><spring:message
											code="register.credential.password.label" /></label></td>

								<td class="data">
									<div>
										<form:input id="credential.password"
											path="credential.password" type="password" />
										<form:errors path="credential.password" cssStyle="color:red;" />
									</div>

								</td>
							</tr>
							<tr>
								<td class="label"></td>

								<td class="data">

									<div>
										<input type="submit" id="btnAdd"
											value="<spring:message code="register.add.btn"/>" />
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