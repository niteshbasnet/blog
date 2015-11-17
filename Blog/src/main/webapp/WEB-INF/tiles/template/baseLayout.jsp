<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="<c:url value="/resource/css/main.css"/>" rel="stylesheet">
<title><tiles:insertAttribute name="title" /></title>
</head>

<body class="container">
	<div class="container">
		<div class="header">
			<ul>
				<tiles:insertAttribute name="menu" />
			</ul>
			<h3>Blog</h3>
		</div>

		<div>
			<h1>
				<tiles:insertAttribute name="heading" />
			</h1>
			<p>
				<tiles:insertAttribute name="tagline" />
			</p>
		</div>

		<div class="row">
			<tiles:insertAttribute name="body" />
		</div>
		<div>
			<tiles:insertAttribute name="side_bar"/>
		</div>
		
	</div>
	<div class="footer" style="clear:both;">
			<tiles:insertAttribute name="footer" />
		</div>
	
</body>
</html>
