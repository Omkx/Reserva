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
    <script src="js/jspdf.js"></script>

</head>
<%
    if(session.getAttribute("usu") == null){
        response.sendRedirect("/login.jsp");
    }
%>
<body class="ultima">
<div class="container">
        <div class="row center">
            <div class="col-xs-8 col-xs-offset-2 col-sm-6 col-sm-offset-3">
                <div class="panel panel-default" style="position:absolute; width:700px; height:auto;">
                    <div class="panel-heading" style="padding-bottom: 0;">
                        <span class="glyphicon glyphicon-film"></span> <strong class="text-center">RESERVA</strong>
                        <div class="input-group" style="display: inline-block;margin-left: 26.5em;">
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
                                <div class="col-sm-12 col-md-10 col-md-offset-1" style="padding-left:10px;padding-right:10px;" >
                                    <div class="section-title first" style="margin-bottom:0px;" >
                                        <div class="form-group" id="Usuario" style="margin-top:1em;">
                                            <label for="inUsu">USUARIO : </label><div id="inUsu" name="inUsu" class="mayuscula">${usu.apPaterno} ${usu.apMaterno} , ${usu.nombre} </div>
                                        </div>
                                        <div class="form-group" id="Pelicula">
                                            <label for="inPelicula">PELICULA : </label><div id="inPelicula" name="inPelicula" class="mayuscula">${pelicula.nombre}</div>
                                        </div>
                                        <div class="form-group" id="Horario">
                                            <label for="inHorario">HORARIO : </label><div id="inHorario" name="inHorario" class="mayuscula">${horario.hora}</div>
                                        </div>
                                        <div class="form-group" id="Fecha">
                                            <label for="inFecha">FECHA : </label><div id="inFecha" name="inFecha" class="mayuscula">${reserva.fechaReserva}</div>
                                        </div>
                                        <div class="form-group" id="Monto" style="margin-bottom:1em;">
                                            <label for="inMonto">MONTO : </label><div id="inMonto" name="inMonto">S/. ${reserva.monto}0</div>
                                        </div>
                                        <button class="btn btn-lg btn-success" type="button" id="inImprimir" style="margin-bottom:1.5em;">Imprimir Ticket</button>
                                    </div>
                                </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function() {
        $('#inImprimir').click(function(e) {
            e.preventDefault();
            var usuario = $('#inUsu').html();
            var pelicula = $('#inPelicula').html();
            var horario = $('#inHorario').html();
            var fecha = $('#inFecha').html();
            var monto = $('#inMonto').html();
            var doc = new jsPDF();
            doc.text(20, 30, 'USUARIO :    '+ usuario );
            doc.text(20, 40, 'PELICULA :   '+ pelicula );
            doc.text(20, 50, 'HORARIO :    '+ horario);
            doc.text(20, 60, 'FECHA :         '+ fecha);
            doc.text(20, 70, 'MONTO :        '+ monto);

            doc.save('Test.pdf');
            location.href='/login.jsp';
            });
        });
</script>
</body>
</html>
