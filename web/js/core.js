/*function monto(){
	//var diasSemana = new Array("Domingo","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado");
	var f=new Date();
	var nroAdultos;
	var nroNinos;
	if(document.getElementById('inAdulto') == null){
		nroAdultos = 0;
	}else{
		nroAdultos = parseFloat(document.getElementById('inAdulto').value) + 1;
	}

	if(document.getElementById('inNino') == null){
		nroNinos = 0;
	}else{
		nroNinos = parseFloat(document.getElementById('inNino').value) + 1 ;
	}

	if (f.getDay()==1 || f.getDay()==3)
	{
		var precioAdulto = 20.00;
		var precioNino = 10.00;
	}else if(f.getDay()==2)
	{
		var precioAdulto = 12.00;
		var precioNino = 7.00;
	}else{
		var precioAdulto = 28.00;
		var precioNino = 15.00;
	}
	monto = nroAdultos*precioAdulto + nroNinos*precioNino;
	$('#total').html('S/.'+ monto.toString());
}
*/
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
/*function ok(cantidad)
{
	//console.log('cantidad');
	var precio = parseFloat(document.getElementById("precioIndividual").innerHTML);
	a = parseInt(cantidad) * precio;

	//console.log('cantidad a:'+a);
	$('#total').html('S/.'+ a);
}
*/
function mostrarInformacion(c) {

	if (c != '0') {
		$('#horario').removeClass('hidden');
		$('#cantidad1').removeClass('hidden');
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
		if(valor == 1){
			$('#cantAdulto').removeClass('hidden');
		}
		if (valor == 2){
			$('#cantNino').removeClass('hidden');
		}
	}else{
		$('#cantNino').addClass('hidden');
		$('#cantAdulto').addClass('hidden');
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

