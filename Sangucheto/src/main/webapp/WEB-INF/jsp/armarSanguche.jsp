<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SANGUCHETO</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container theme-showcase" role="main">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>Selecciona los ingredientes</h1>
			
			<table class="table">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Precio</th>
						<th>Tipo</th>
						
						<th></th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${stock}" var="item">
						<tr>
							<td>${item.key.nombre}</td>
							<td>$ ${item.key.precio}</td>
							<td>${item.key.tipo}</td>
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
							<td>${item.value}</td>
>>>>>>> origin/master
>>>>>>> bfd0c4f82ce85625ade1108e7a1631be326aca91
							<td><td><a href="agregarIngredienteSanguche?ingredientes=${item.key.nombre}"><button type="button" class="btn btn-default">Agregar</button></a></td></td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		
		<div class="col-xs-6">
			
			<h1>Ingredientes seleccionados</h1>
			
			<table class="table">
				<thead>
					<tr>
						<th>Nombre</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ingredientesAgregados}" var="ingre">
						<tr>
							<td>${ingre.nombre}</td>
<<<<<<< HEAD
							<td><a href="quitarIngredienteSanguche?ingredientes=${ingre.nombre}"><button type="button" class="btn btn-default">Quitar</button></a></td>
=======
<<<<<<< HEAD
							<td><a href="quitarIngredienteSanguche?ingredientes=${ingre.nombre}"><button type="button" class="btn btn-default">Quitar</button></a></td>
=======
>>>>>>> origin/master
>>>>>>> bfd0c4f82ce85625ade1108e7a1631be326aca91
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		
		<div class="col-xs-6">
			
			<h1>Condimentos seleccionados</h1>
			
			<table class="table">
				<thead>
					<tr>
						<th>Nombre</th>
												
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${condimentosAgregados}" var="condi">
						<tr>
							<td>${condi.nombre}</td>
<<<<<<< HEAD
							<td><a href="quitarIngredienteSanguche?ingredientes=${condi.nombre}"><button type="button" class="btn btn-default">Quitar</button></a></td>
=======
<<<<<<< HEAD
							<td><a href="quitarIngredienteSanguche?ingredientes=${condi.nombre}"><button type="button" class="btn btn-default">Quitar</button></a></td>
=======
>>>>>>> origin/master
>>>>>>> bfd0c4f82ce85625ade1108e7a1631be326aca91
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bfd0c4f82ce85625ade1108e7a1631be326aca91
		<br>
	<div class="panel panel-default">
	  <div class="panel-body">
		<label  for="precio">Precio: </label>
		<input id="precio"   name="precio" type="text" value="${precio}" class="panel-body" disabled>
	  </div>
	</div>
		
<<<<<<< HEAD
		
		<a href="index"><button class="btn btn-default">Volver</button></a>
		<a href="limpiarSanguche"><button class="btn btn-default">Limpiar</button></a>
		<a href="comprarSanguche"><button class="btn btn-default">Comprar</button></a>
=======
		
		<a href="index"><button class="btn btn-default">Volver</button></a>
		<a href="limpiarSanguche"><button class="btn btn-default">Limpiar</button></a>
		<a href="comprarSanguche"><button class="btn btn-default">Comprar</button></a>
=======
		
		<a href="index"><button class="btn btn-default">Volver</button></a>
>>>>>>> origin/master
>>>>>>> bfd0c4f82ce85625ade1108e7a1631be326aca91
			
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>