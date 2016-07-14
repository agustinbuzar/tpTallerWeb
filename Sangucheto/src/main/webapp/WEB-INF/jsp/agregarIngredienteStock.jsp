<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
<head>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.3.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script src="js/validacion.js"></script>
	
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>-- Sanguchetto --</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="jumbotron">
		<h1>Agregar Ingrediente</h1>
	</div>
	
	<div class="container theme-showcase" role="main">

		<div class="page-header">
			<form:form method="post" action="agregarIngrediente" commandName="ingrediente" role ="form" id="ingredientes">
				<div class="form-group">
					<form:label path="nombre" for="nombre">Nombre:</form:label>
					<form:input path="nombre" class="form-control" id="nombre"/>
					<span class="help-block"></span>
				</div>
				<div class="form-group">
					<form:label path="precio" for="precio">Precio:</form:label>
					<form:input path="precio" class="form-control" id="precio"/>
					<span class="help-block"></span>
					<br/>
				</div>
				<div class="form-group">
					<form:label path="imagen" for="imagen">Path/URL Imagen:</form:label>
					<form:input path="imagen"  id="imagen" class="form-control"/>
					<br/>
				</div>
				<div class="form-group">
					<form:label path="tipo" for="tipo">Tipo:</form:label>
						<div class="radio">
							<form:radiobutton path="tipo" value="INGREDIENTE"/>Ingrediente
						</div>
						<div class="radio">
							<form:radiobutton path="tipo" value="CONDIMENTO"/>Condimento
						</div>
				</div>
				<br/>
		
				<button type="submit" class="btn btn-success" id="agregar">Agregar</button>
				<a href="indexAdmin"><button class="btn btn-danger">Cancelar</button></a>	
			</form:form>

					
		</div>
		
		

	</div>

</body>
</html>