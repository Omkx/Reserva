function eAplicacion(){
	$('#mAplicacion').modal();
}
function ePerfil(){
	$('#mPerfil').modal();
}
function eUsuario(){
	$('#mUsuario').modal();
}
function eAsignacionPerfil(){
	$('#mAsignacionPerfil').modal();
}
function ok(cantidad)
{
	//console.log('cantidad');
	var precio = parseFloat(document.getElementById("precioIndividual").innerHTML);
	a = parseInt(cantidad) * precio;

	//console.log('cantidad a:'+a);
	$('#total').html('S/.'+ a);
}
function mostrarInformacion(c) {

	if (c != '0') {
		$('#horario').removeClass('hidden');
		$('#cantidad').removeClass('hidden');
		$('#synopsis').removeClass('hidden');
		$('#duracion').removeClass('hidden');
		$('#trailer').removeClass('hidden');
		$('#calificacion').removeClass('hidden');
		$('#precio').removeClass('hidden');
		$('#ticket').removeClass('hidden');
	}
}

function categoria(valor) {

	if (valor != '0') {
		$('#cantCat').removeClass('hidden');
	}
}
/*function nuevaRazon(genial)
 {
 //console.log('cantidad');
 a = parseInt(genial);
 //console.log('cantidad a:'+a);
 //$('#total').html('S/.'+ a);
 $('.pelsyp').html(a);
 }*/

