<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>[SanguCheto]</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link href="css/sangucheto.css" rel="stylesheet">  
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand sangucheto" href="indexAdmin">SanguCheto</a>
        <p class="navbar-brand text-verde">-[GOD MODE]-</p>     
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
      	<li><a href="agregarIngredienteStock">ALTA&nbsp;</a></li>
      	<li><a href="verStock">STOCK&nbsp;</a></li>
        <li><a href="armarSanguche">ARMAR</a></li>
        <li><a href="index"><span class="glyphicon glyphicon-log-out"></span></a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="jumbotron-admin text-center">
  <h1 class="sangucheto">SanguCheto</h1>
</div>

<!-- Container (About Section) -->
<div id="about" class="text-center">
<h1 class="text-center">Ingredientes</h1>
  <div class="row">

			<table class="table class="text-center"">
				<thead>
					<tr>
						<th class="text-center">Nombre</th>
						<th class="text-center">Precio</th>
						<th class="text-center">Tipo</th>
						<th class="text-center">Cantidad</th>
						<th></th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${stock}" var="item">
						<tr>
							<td>${item.key.nombre} <img src="${item.key.imagen}"  class="img-circle" width="52" height="45"></td>
							<td>${item.key.precio}</td>
							<td>${item.key.tipo}</td>
							<td>${item.value}</td>
							<td><button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal" data-name="${item.key.nombre}" onclick="hola(this);">Agregar stock</button></td>
							<td><a href="eliminarStock?condimento=${item.key.nombre}"><button type="button" class="btn btn-danger">Eliminar</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog">
		      <div class="modal-content">
		        <div class="modal-header">
		        <br>
		        <h1 class="sangucheto">SanguCheto</h1>
		        <br>
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
  </div>
</div>


<footer class="container-fluid text-center">
  <a href="#myPage" title="To Top">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a>
  <p>Sangucheto - BigChegusanRecords - 2016</p>
</footer>

<script>

function hola(elem){
	name = $(elem).data('name');
	document.getElementById("ingrediente").value = name;
}
$(document).ready(function(){
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {
    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {
      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
  
  $(window).scroll(function() {
    $(".slideanim").each(function(){
      var pos = $(this).offset().top;

      var winTop = $(window).scrollTop();
        if (pos < winTop + 600) {
          $(this).addClass("slide");
        }
    });
  });
})
</script>

</body>
</html>


