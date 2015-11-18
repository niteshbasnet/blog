<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	<div
		style="position: relative; vertical-align: bottom; text-align: right; padding-top: 10px">

	Language : <a href="?language=en_US">English</a> | <a
			href="?language=mn_MN">Монгол хэл</a>
		<ul class="list-inline">

			<li><a href="<spring:url value="/"/>">Home</a></li>

			<security:authorize access="isAuthenticated()">
			
				<li><a href="<spring:url value="/blog/createblog"/>"> <spring:message code="addblog" text="Add Blog"></spring:message> </a></li>
				<li><c:if test="${blogid>-1}"><a href="<spring:url value='/article/addArticle'/>" > <spring:message code="addarticle" text="Add Article"></spring:message></a></c:if></li>
				<li><a href="<spring:url value='/doLogout' />" ><spring:message code="logout" text="Log Out"></spring:message></a><li>
			</security:authorize>
			<security:authorize access="isAnonymous()">
 							<li><a href="<spring:url value='/signup' />" ><spring:message code="signup" text="Create Own Blog"></spring:message></a></li>
 							<li><a href="<spring:url value='/login' />" ><spring:message code="login" text="Login"></spring:message></a></li>	
				</security:authorize>
		</ul>

		<security:authorize access="isAuthenticated()">
  					Welcome  <security:authentication property="principal.username" />
		<%--	<form method="post"
				action="<spring:url value='/j_spring_security_logout' />">

				<input type="hidden" name="<c:out value="${_csrf.parameterName}"/>"
					value="<c:out value="${_csrf.token}"/>" /> 
					<input type="submit" value="Log out" />
			</form>
--%>
		</security:authorize>
	</div>
