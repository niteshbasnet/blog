<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IMAGE EXCEPTION</title>
</head>
<body>
	<section>
		<div>
			<div>
				<h1 style="color:red"> ${unableToUpload}</h1>
			</div>
		</div>
	</section>

	<section>
		<div >
			<p>${url}</p>
			<p>${exception}</p>
		</div>

		<div>
			<p>
				<a href="<spring:url value="/" />" >
					<span ></span> Go Home
				</a>
			</p>
		</div>
		
	</section>
</body>
</html>
