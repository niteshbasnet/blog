<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login JSP Page</title>
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col-md-6 col-md-offset-2">
				<div class="panel panel-login">
					<!-- <div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Login</a>
							</div>

						</div>
						<hr>
					</div> -->
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">

								<c:if test="${error eq true}">
									<p>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
								</c:if>

								
								<form id="login-form" action="<c:url value='j_spring_security_check' />"
									method="post" role="form" style="display: block;">
									<div class="form-group">
										<input type="text" name="j_username" id="j_username" tabindex="1"
											class="form-control" placeholder="Username" value="">
									</div>
									<div class="form-group">
										<input type="password" name="j_password" id="j_password"
											tabindex="2" class="form-control" placeholder="Password">
									</div>
									<div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="_spring_security_remember_me"
											id="_spring_security_remember_me"> <label for="_spring_security_remember_me">
											Remember Me</label>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit"
													tabindex="4" class="form-control btn btn-primary"
													value="Log In">
													
													<input type="hidden" name="<c:out value="${_csrf.parameterName}"/>"
													value="<c:out value="${_csrf.token}"/>" />
														</div>
										</div>
									</div>

								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>
