<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
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
							<td>${item.key.nombre}<img src="${item.key.imagen}"  class="img-circle" width="52" height="45"></td>
							<td>$ ${item.key.precio}</td>
							<td>${item.key.tipo}</td>
							<c:if test="${item.value > 0}">
							<td><td><a href="agregarIngredienteSanguche?ingredientes=${item.key.nombre}"><button type="button" class="btn btn-info">Agregar</button></a></td></td>
							</c:if>
							<c:if test="${item.value == 0}">
							<td><td><button type="button" class="btn btn-danger" disabled>Sin Stock</button></a></td></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class="row">
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
								<td>${ingre.nombre}<img src="${ingre.imagen}"  class="img-circle" width="52" height="45"></td>
								<td><a href="quitarIngredienteSanguche?ingredientes=${ingre.nombre}"><button type="button" class="btn btn-danger">Quitar</button></a></td>
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
								<td>${condi.nombre}<img src="${condi.imagen}"  class="img-circle" width="52" height="45"></td>
								<td><a href="quitarIngredienteSanguche?ingredientes=${condi.nombre}"><button type="button" class="btn btn-danger">Quitar</button></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="page-header">
			<div class="panel-body">
				<label for="precio"><h3>Precio: </h3></label>
				<input id="precio"   name="precio" type="text" value="${precio}" class="panel-body" disabled>
		  	</div>
			
			<a href="index"><button class="btn btn-default btn-lg">Volver</button></a>
			<a href="limpiarSanguche"><button class="btn btn-danger btn-lg">Limpiar</button></a>
			<a href="comprarSanguche"><button class="btn btn-success btn-lg">Comprar</button></a>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>