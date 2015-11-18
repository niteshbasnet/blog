
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<div class="language">
	<div
		style="position: relative; vertical-align: bottom; text-align: right; padding-top: 10px">


		<ul class="list-inline">

			<li><a href="<spring:url value="/"/>">Home</a></li>

			<security:authorize access="isAuthenticated()">
				<li><a href="<spring:url value="/blog/createblog"/>">Add Blog</a></li>
			</security:authorize>
			<security:authorize access="isAnonymous()">
 							 <li><a href="<spring:url value='/signup' />" >SignUp</a> 
 							<li><li>
 							<a href="<spring:url value='/login' />" >Login</a>
 							<li>
 							
				</security:authorize>
		</ul>

		<security:authorize access="isAuthenticated()">
  					Welcome  <security:authentication property="principal.username" />
			<form method="post"
				action="<c:url value='j_spring_security_logout' />">

				<input type="hidden" name="<c:out value="${_csrf.parameterName}"/>"
					value="<c:out value="${_csrf.token}"/>" /> <input type="submit"
					value="Log out" />
			</form>

		</security:authorize>
	</div>
</div>
