<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<tiles:importAttribute name="navList" />

<ul class="sidebar.affix-top">

	<li><a href="<spring:url value="/blog"/>">Home</a></li>
	<li>Blog List
		<ul>
			<c:forEach var="link" items="${navList}">
				<li><a href="<spring:url value="${link.linkURL}"/>">${link.linkName}</a></li>
			</c:forEach>
		</ul>
	</li>
</ul>
