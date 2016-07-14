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
        <li><a href="armarSanguche">ARMAR SANGUCHE</a></li>
        <li><a href="#about">QUIENES SOMOS</a></li>
        <li><a href="#portfolio">OPINIONES</a></li>
        <li><a href="loginAdmin"><span class="glyphicon glyphicon-user"></span></a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="jumbotron text-center">
  <h1 class="sangucheto">SanguCheto</h1>
  <p>El Chegusan por excelencia!</p>
<a href="armarSanguche" class="btn btn-lg btn-default">Armar Sanguche&raquo;</a>
</div>

<!-- Container (About Section) -->
<div id="about" class="container-fluid">
  <div class="row text-center">
      <img style="width: 15%;"alt="" src="http://img1.cookinglight.timeinc.net/sites/default/files/styles/500xvariable/public/image/2011/07/1107w-panerabread-sandwich-x.jpg?itok=NAlbDWPv" class="img-circle chegusan"/>
    <div>
      <h2>Que es SanguCheto?</h2><br>
      <p>SanguCheto es la primera aplicacion web que te permite armar tu sanguche favorito y recibirlo en la puerta de tu casa!</p>
      <a href="armarSanguche" class="btn btn-default">Armar Sanguche</a>
    </div>

  </div>
</div>

<!-- Container (Portfolio Section) -->
<div id="portfolio" class="container-fluid text-center bg-grey">
  <h2>Que dicen los que ya lo probaron</h2>
  <div id="myCarousel" class="carousel slide text-center" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <h4>"El mejor Chegusan del universo"<br><span style="font-style:normal;">Alberto Einstein, Cientifico, Amante de SanguCheto</span></h4>
      </div>
      <div class="item">
        <h4>"Solo una palabra... UNICO"<br><span style="font-style:normal;">Juan Carlos, Portero</span></h4>
      </div>
      <div class="item">
        <h4>"Hijo, la rompiste con estos sanguchitos"<br><span style="font-style:normal;">Jorge Cheto, Padre del dueño de SanguCheto</span></h4>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<footer class="container-fluid text-center">
  <a href="#myPage" title="To Top">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a>
  <p>Sangucheto - BigChegusanRecords - 2016</p>
</footer>

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

</body>
</html>

