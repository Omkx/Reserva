<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Seguridad</title>

	<!-- Bootstrap CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="css/core.css">
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
	<!-- jQuery -->
	<script src="js/jquery-2.1.1.min.js"></script>
	<!-- Bootstrap JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/core.js"></script>
	<script src="js/precio.js"></script>
	<script src="js/script.js"></script>

</head>
<%
	if(session.getAttribute("usu") == null){
		response.sendRedirect("/login.jsp");
	}
%>
<body class="ultima">
<div class="container">
	<div class="Cartelera ">
		<div class="row center">
			<div class="col-xs-8 col-xs-offset-2 col-sm-6 col-sm-offset-3">
				<div class="panel panel-default" style="position:absolute; width:700px; height:auto;">
					<div class="panel-heading" style="padding-bottom: 0;">
						<span class="glyphicon glyphicon-film"></span> <strong class="text-center">VENTA DE TICKETS</strong>
						<div class="input-group" style="display: inline-block;margin-left: 22.3em;">
							<form action="logout" method="post" accept-charset="UTF-8">
								<fieldset>
									<div class="form-group">
										<button type="submit" class="btn btn-default" aria-haspopup="true" aria-expanded="true">Logout</button>
									</div>
								</fieldset>
							</form>
						</div>
					</div>
					<div class="panel body">
						<form action="Reservar" method="post">
						<fieldset>
							<div class="col-sm-12 col-md-10 col-md-offset-1" style="padding-left:10px;padding-right:10px;" >
								<div class="section-title first" style="margin-bottom:0;" >
									<div class="form-group hidden " id="Usuario">
										<input type="text" id="inUsu" name="inUsu" style="display: none" value="${usu.idUsuario}"/>
									</div>
										<div class="form-group" name="pel">
											<label style="display:block;padding-top:15px;padding-bottom:15px;">NOMBRE DE LA PELÍCULA</label>

											<select class="form-control"  name="inPelicula" id="inPelicula" onchange="mostrarInformacion(this.value)" autofocus required>
												<option value="0">Seleccionar</option>
												<c:forEach var="fila" items="${peliculas}">
													<option value="${fila.idPelicula}">${fila.nombre}</option>
												</c:forEach>
											</select>
										</div>


										<div class="form-group hidden" id="horario" >
										</div>

										<div class="form-group hidden" id="cantidad1">
											<label style="display:block;padding-top:15px;padding-bottom:15px;">RESERVA POR PERSONA</label>
											<select name="inResPer" id="input1" class="form-control" required="required" onchange="categoria(this.value)" style="width: 40%;display:inline-block;margin-right: 2.8em;padding: 2px 12px;font-size: 17px;" autofocus required>
												<option value="0">Seleccionar</option>
												<option value="1">Adulto</option>
											</select>

											<div class="form-group hidden" id="cantAdulto" style="display:inline-block; width: 50%;">
												<button type="button" class='qtyminus1 btn btn-default btn-lg' field='quantity1'><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button>
												<input type='text' name='quantity1' value='0' class='qty form-control' style="display: inline-block;width: 20%;" id="inAdulto" />
												<button type="button" class='qtyplus1 btn btn-default btn-lg' field='quantity1'><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
												<input id="totalAdultos" style="display: none"/>
											</div>
											<a href="#" id="more">more..</a>
										</div>
										<div class="form-group hidden" id="cantidad2">
											<select name="inResPer" id="input2" class="form-control" required="required" onchange="categoria(this.value)" style="width: 40%;display:inline-block;margin-right: 2.8em;padding: 2px 12px;font-size: 17px;">
												<option value="0">Seleccionar</option>
												<option value="2">Niño y Adulto Mayor</option>
												</select>
											<div class="form-group hidden" id="cantNino"  style="display:inline-block; width: 50%;">
												<button type="button" class='qtyminus2 btn btn-default btn-lg' field='quantity2'><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button>
												<input type='text' name='quantity2' value='0' class='qty form-control' style="display: inline-block;width: 20%;" id="idNino" />
												<button type="button" class='qtyplus2 btn btn-default btn-lg' field='quantity2'><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
												<input id="totalNinos" style="display: none"/>
											</div>

										</div>


										<div class="form-group hidden " id="synopsis">
											<label style="display:block;padding-top:15px;padding-bottom:15px;">SIPNOSIS</label>
												<h4 id="pelsyp"></h4>

										</div>

										<div class="form-group hidden " id="duracion">
											<label style="display:block;padding-top:15px;padding-bottom:15px;">DURACION</label>
											<h4 id="duracionPelicula"></h4>
										</div>

										<div class="form-group hidden" id="trailer">
											<label style="display:block;padding-top:15px;padding-bottom:15px;">TRAILER</label>

											<iframe id="trailerIframe" width=555" height="430" frameborder="0" allowfullscreen></iframe>

										</div>

										<div class="form-group hidden" id="calificacion">
											<label style="display:block;padding-top:15px;padding-bottom:15px;">CALIFICACION</label>
											<h4 id="calificacionPelicula"></h4>
										</div>

										<div class="form-group hidden" id="precio">
											<label style="display:block;padding-top:15px;padding-bottom:15px;">PRECIO TOTAL</label>
											<div class="input-group">
												<span class="input-group-addon">$</span>
												<input id="total" name="total" type="text" class="form-control" aria-label="Amount (to the nearest dollar)" autofocus required>
												<div id="precioIndividual" style="display:none"></div>
											</div>
										</div>


										<div class="form-group hidden" id="ticket"  style="display:block;padding-top:15px;padding-bottom:15px; " >
											<button type="Submit" class="btn btn-primary">Imprimir Ticket</button>
										</div>

								</div>
							</div>
						</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#inPelicula').click(function(event) {
			var peli =$('#inPelicula').val();
			$.get('ActionServlet', {pelicula:peli},function(responseText) {
				var parametros = responseText.split("|");
				$('#pelsyp').text(parametros[0]);
				$('#duracionPelicula').text(parametros[1]);
				var url = "https://www.youtube.com/embed/";
				document.getElementById("trailerIframe").src = url.concat(parametros[2]);
				$('#calificacionPelicula').text(parametros[3].toUpperCase());
				var array = parametros[4].substring(1, parametros[4].length - 1 );
				var cars = array.split(",");
				var text = "<label style='display:block;padding-top:15px;padding-bottom:15px;'>HORARIOS</label><select class='form-control' name='inHorario' id='inHorario'><option value='0'>Seleccionar</option>";
				var i;
				for (i = 0; i < cars.length; i++) {
					text += "<option value="+ (i+1) +">" + cars[i]+ "</option>" + "<br>";
				}

				text += "</select>";

				document.getElementById("horario").innerHTML = text;
			});
		});
	});
</script>


</body>
</html>