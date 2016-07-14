$(document).ready(function() {
	
	
	$("span.help-block").hide();
	$("#agregar").click(validar);

});
function validar(){

	var valor = document.getElementById("nombre").value;
	
	
	
	if (valor == null || valor == 0){
		
		$("#nombre").parent().attr("class","form-group has-error");
		$("#nombre").parent().children("span").text("Debe ingresar un nombre para el ingrediente").show();
		return false;
	}else if (!isNaN(valor)){
			
			$("#nombre").parent().attr("class","form-group has-error");
			$("#nombre").parent().children("span").text("Debe ingresar solo letras").show();
			return false;
		}else{
			$("#nombre").parent().attr("class","form-group has-success");
		}
	
	
	var valor = document.getElementById("precio").value;
	
	
	
	if (valor == null || valor == 0){
		
		$("#precio").parent().attr("class","form-group has-error");
		$("#precio").parent().children("span").text("Debe ingresar un precio para el ingrediente").show();
		return false;
	}else if (isNaN(valor)){
			
			$("#precio").parent().attr("class","form-group has-error");
			$("#precio").parent().children("span").text("Debe ingresar precio valido").show();
			return false;
		}else{
			$("#precio").parent().attr("class","form-group has-success");
		}
	
}