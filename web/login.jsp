<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
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
	<script src="js/jquery.js"></script>
	<!-- Bootstrap JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/core.js"></script>
</head>
<body>
<div class="container">
	<div class="login">
		<div class="row center">
			<div class="col-xs-8 col-xs-offset-2 col-sm-6 col-sm-offset-3">
				<div class="panel panel-default">
					<div class="panel-heading" style="padding-bottom: 1em;">
						<strong class="text-center">INICIAR SESION</strong>
					</div>
					<div class="panel body">
						<form action="login" method="post">
							<fieldset>
								<div class="row">
									<div class="text-center" style="margin-bottom: 1em;">
										<img class="profile-img" src="img/ticket.png" height="128" width="128" alt="">
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 col-md-10 col-md-offset-1">
										<div class="form-group">
											<div class="input-group">
													<span class="input-group-addon">
														<i class="glyphicon glyphicon-user"></i>
													</span>
												<input type="text" class="form-control" id="inUsuario" name="inUsuario" placeholder="Ingrese usuario" autofocus required>
											</div>
										</div>
										<div class="form-group">
											<div class="input-group">
										  			<span class="input-group-addon">
														<i class="glyphicon glyphicon-lock"></i>
													</span>
												<input type="password" class="form-control" id="inClave" name="inClave" placeholder="Ingrese contraseña" autofocus required>
											</div>
										</div>
										<div class="form-group">
											<button type="submit" class="btn btn-lg btn-primary btn-block">Ingresar</button>

										</div>
										</div>
									</div>
							</fieldset>
						</form>

						<div class="row">
							<div class="col-sm-12 col-md-10 col-md-offset-1">

								<div class="form-group">
									<a href="CreacionDeCuenta.jsp"><button type="button" class="btn btn-lg btn-primary btn-block">Crear nueva cuenta</button></a>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>

</body>
</html>