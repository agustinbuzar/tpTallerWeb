<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>-- Sanguchetto --</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container theme-showcase" role="main">
		<div class="jumbotron">
			<h1>Inicio de Sesi�n</h1>
		</div>

		<div class="page-header">
			<form:form method="post" action="validaAdmin" commandName="admin" role ="form">
				<div class="form-group">
					<form:label path="user" for="user">Usuario:</form:label>
					<form:input path="user" type="text" class="form-control" id="user"/>
				</div>
				
				<div class="form-group">
					<form:label path="pass" for="pass">Contrase�a:</form:label>
					<form:input path="pass" type="password" class="form-control" id="pass"/>
				</div>
				
				
				<button type="submit" class="btn btn-default">Ingresar</button>
				<a href="index" class="btn btn-default">Volver</a>
			</form:form>			
		</div>
		
		

	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>