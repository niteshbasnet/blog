<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<%-- <link href="<c:url value="/resource/css/main.css"/>" rel="stylesheet"> --%>
<link href="<c:url value="/resource/css/simple-sidebar.css"/>" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title><tiles:insertAttribute name="title" /></title>
</head>

<body>

	<div class="container">
		<div class="header">
			<div class="nav nav-pills nav-fixed-top pull-right">
				<tiles:insertAttribute name="menu" />
			</div>
			<h3 class="text-muted">Blog
					<tiles:insertAttribute name="heading" />
			</h3>
			<p class="text-muted">
					<tiles:insertAttribute name="tagline" />
				</p>
		</div>
		
			
		
		<div class="row">
			<div id="wrapper">
				<div id="sidebar-wrapper"><tiles:insertAttribute name="side_bar" />
				</div>
				<div id="page-content-wrapper">
					<div class="panel panel-default">
						<tiles:insertAttribute name="body" />
					</div>
				</div>
			</div>
		</div>

		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>

	</div>
</body>

<%-- <body>
	<div class="container">
	<div class="container-fluid">
	
		<div class="navbar navbar-fixed-top navbar-default" role="navigation"> 
			<div class="container">
			<div class="navbar-header">
				<h1>
						<tiles:insertAttribute name="heading" />
					</h1>
					<p>
						<tiles:insertAttribute name="tagline" />
					</p>
			</div>
				
				<div>
						<tiles:insertAttribute name="menu" />
				</div>

			 </div>
		</div> 

		<div class="container">
		<div class="row">
			<div id="wrapper">
				<div id="sidebar-wrapper"><tiles:insertAttribute name="side_bar" />
				</div>
				<div id="page-content-wrapper">
					<div class="panel panel-default">
						<tiles:insertAttribute name="body" />
					</div>
				</div>
			</div>
				
		
			</div>
		</div>
		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>
		</div>
	</div>
</body> --%>
</html>
