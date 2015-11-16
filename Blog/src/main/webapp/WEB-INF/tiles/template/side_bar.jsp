<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:importAttribute name="test"/>
<ul>
	<li><a href="<spring:url value="/home"/>">Home</a></li>
	<li>Blog List
		<ul>
			<li>${test} s</li>
		</ul>
	</li>
</ul>
