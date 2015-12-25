<%--
  Created by IntelliJ IDEA.
  User: blackr
  Date: 23/12/15
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
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

</head>

<body class="ultima">

<div class="container">
    <div class="Cartelera ">
        <div class="row center">
            <div class="col-xs-8 col-xs-offset-2 col-sm-6 col-sm-offset-3">
                <div class="panel panel-default" style="position:absolute; width:700px; height:auto;">
                    <div class="panel-heading">
                        <span class="glyphicon glyphicon-film"></span> <strong class="text-center">VENTA DE TICKETS</strong>
                    </div>
                    <div class="panel body">
                        <form action="" method="post">
                            <fieldset>

                                <div class="col-sm-12 col-md-10 col-md-offset-1" style="padding-left:10px;padding-right:10px;" >
                                    <div class="section-title first" style="margin-bottom:0px;" >

                                        <div class="form-group hidden " id="nombre">
                                            <label style="display:block;padding-top:15px;padding-bottom:15px;">NOMBRE :</label>
                                            <h4 id="nombreReserva"></h4>
                                        </div>

                                        <div class="form-group hidden " id="pelicula">
                                            <label style="display:block;padding-top:15px;padding-bottom:15px;">PELICULA :</label>
                                            <h4 id="peliculaReserva"></h4>
                                        </div>

                                        <div class="form-group hidden " id="horario">
                                            <label style="display:block;padding-top:15px;padding-bottom:15px;">HORARIO :</label>
                                            <h4 id="horarioReserva"></h4>
                                        </div>


                                        <div class="form-group hidden " id="cantidad">
                                            <label style="display:block;padding-top:15px;padding-bottom:15px;">CANTIDAD :</label>
                                            <h4 id="cantidadReserva"></h4>
                                        </div>


                                        <div class="form-group hidden " id="precio">
                                            <label style="display:block;padding-top:15px;padding-bottom:15px;">PRECIO TOTAL :</label>
                                            <h4 id="PrecioReserva"></h4>
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