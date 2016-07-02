<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Test</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container theme-showcase" role="main">

		<div class="page-header">
			<form:form method="post" action="agregarIngrediente" commandName="ingrediente" role ="form">
				<div class="form-group">
					<form:label path="nombre" for="nombre">Nombre:</form:label>
					<form:input path="nombre" class="form-control" id="nombre"/>
				</div>
				<div class="form-group">
					<form:label path="precio" for="precio">Precio:</form:label>
					<form:input path="precio" class="form-control" id="precio"/>
				</div>
					<form:label path="tipo" for="tipo">Tipo:</form:label>
				<div class="radio">
					<form:radiobutton path="tipo" value="INGREDIENTE"/>Ingrediente
				</div>
				<div class="radio">
					<form:radiobutton path="tipo" value="CONDIMENTO"/>Condimento
				</div>
				
				<button type="submit" class="btn btn-default">Agregar</button>
			</form:form>			
		</div>
	

	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>