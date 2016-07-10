<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<h1>Stock Disponible</h1>
	</div>
	
	<div class="container theme-showcase" role="main">

		<div class="page-header">
			<table class="table">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Precio</th>
						<th>Tipo</th>
						<th>Cantidad</th>
						<th></th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${stock}" var="item">
						<tr>
							<td>${item.key.nombre}</td>
							<td>${item.key.precio}</td>
							<td>${item.key.tipo}</td>
							<td>${item.value}</td>
							<td><button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal" data-name="${item.key.nombre}" onclick="hola(this);">Agregar stock</button></td>
							<td><a href="eliminarStock?condimento=${item.key.nombre}"><button type="button" class="btn btn-danger">Eliminar</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<a href="indexAdmin"><button class="btn btn-default btn-lg">Volver</button></a><br/>
		</div>

		<div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog modal-lg">
		      <div class="modal-content">
		        <div class="modal-header">
		          <h4 class="modal-title">Agregar stock</h4>
		        </div>
		        <div class="modal-body">
						<form action="agregarStock" method="GET">
							<input type="hidden" id="ingrediente" name="ingrediente" >
										
							<label class="active" for="cantidad">Cantidad</label>
							<input id="cantidad" name="cantidad" type="text" class="form-control"></br>
									
							<button type="submit" class="btn btn-success">Agregar Stock</button>
						</form>
		        </div>
		        <div class="modal-footer">
		          <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
		        </div>
		      </div>
		    </div>
		  </div>

	</div>
	
	<script>
		function hola(elem){
			name = $(elem).data('name');
			document.getElementById("ingrediente").value = name;
		}
	</script>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	
</body>
</html>