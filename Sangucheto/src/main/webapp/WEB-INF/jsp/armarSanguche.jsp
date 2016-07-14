<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
      <a class="navbar-brand sangucheto" href="#myPage">SanguCheto</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li class="fondo-naranja"><a href="limpiarSanguche"><span class="glyphicon glyphicon-trash"></span>VACIAR</a></li>
        <li class="fondo-verde"><a href="comprarSanguche"><span class="glyphicon glyphicon-piggy-bank"></span>COMPRAR SanguCheto</a></li>
        <li><a href="loginAdmin"><span class="glyphicon glyphicon-user"></span></a></li>
      </ul>
    </div>
  </div>
</nav>

<!-- Container (About Section) -->
<div id="about" class="container-fluid">
  <div class="row">
      <h1 class="text-center">Arma tu SanguCheto!</h1>
      <hr>
    <div class="col-sm-6">
    <h4 class="text-center">Ingredientes Disponibles</h4>
      <table class="table">
				<thead>
					<tr>
						<th class="text-center">Nombre</th>
						<th class="text-center">Precio</th>
						<th class="text-center">Tipo</th>
						
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
 <div class="col-sm-6 text-center" >
 		
				
				<h4>Tu Sangucheto</h4>
				
				<table class="table">
					<thead>
						<tr>
							<th class="text-center">Ingrediente</th>
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
			
				<table class="table">
					<thead>
						<tr>
							<th class="text-center">Aderezo	</th>
													
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
		<div class="page-header">
			<div class="panel-body">
				<div class="text-container">
  				<input id="precio"   name="precio" type="text" value="${precio}" class="panel-body text-center" disabled></input>
  				<span id="clearBtn1" class="clearBtn glyphicon glyphicon-usd"></span>
				</div>
				
		  	</div>
 </div>
</div>
</div>
<div class="text-center">
  <a href="#myPage" title="To Top" class="text-center">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a>
  <p class="text-center">Sangucheto - BigChegusanRecords - 2016</p>
  </div>
</div>


<script>
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
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
