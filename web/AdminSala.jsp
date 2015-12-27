<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Administrador</title>

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
                    <div class="panel-heading">
                        <strong class="text-center">Actualizar datos</strong>
                    </div>
                    <div class="panel body">
                        <form action="AdminSala" method="post" accept-charset="UTF-8">
                            <fieldset>
                                <div class="row">
                                    <div class="text-center">
                                        <img class="profile-img" src="img/ticket.png" height="128" width="128" alt="">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 col-md-10 col-md-offset-1">
                                        <div class="form-group">
                                            <div class="input-group">
													<span class="input-group-addon">
														<i class="glyphicon glyphicon-facetime-video"></i>
													</span>
                                                <input type="text" class="form-control" id="inSala" name="inSala" placeholder="Ingrese Sala" autofocus required>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="input-group">
													<span class="input-group-addon">
														<i class="glyphicon glyphicon-pencil"></i>
													</span>
                                                <input type="text" class="form-control" id="inNroAsientos" name="inNroAsientos" placeholder="Ingrese Numero de Asientos" autofocus required>
                                            </div>
                                        </div>



                                        <div class="form-group">
                                            <button type="submit" class="btn btn-lg btn-primary btn-block" >Actualizar</button>
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

</body>
</html>
