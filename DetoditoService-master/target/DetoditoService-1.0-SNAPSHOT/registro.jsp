

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
       <!--  <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
       <!--  <meta name="description" content="">
        <meta name="author" content=""> -->
        <link rel="icon" href="image/favicon.ico">
        <title>DetoditoServices</title>        
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet"> 
       
        <script src="validations.js"></script>


        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- tipo de letra Algerian-->
        <link rel="stylesheet" type="text/css" href="csscreados/Algerian.css">
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <!--Buscador-->
        <link rel="stylesheet" type="text/css" href="csscreados/buscar.css">
        <!--Table spacing-->
        <link rel="stylesheet" type="text/css" href="csscreados/table.css">
        <!-- Custom styles for this template -->
        <link href="csscreados/dashboard.css" rel="stylesheet">
        <!--panelpage table-->
        <link rel="stylesheet" type="text/css" href="csscreados/panelpage.css">
        <!--Icono de los input-->
        <link rel="stylesheet" type="text/css" href="csscreados/IconoInput.css">

        <link href="csscreados/btn.css" type="text/css" rel="stylesheet">
        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <link href="csscreados/error.css" type="text/css" rel="stylesheet">
        <script src="assets/js/ie-emulation-modes-warning.js"></script>
        <script src="dist/js/JSFunction.js" type="text/javascript"></script>

      

    </head>

    <body background="image/background5.jpg" >        
        <div class="container-fluid" style="margin-top: -30px;" >
            <div class="row"> 
                <div class="col-sm-9 col-sm-offset- col-md-10 col-md-offset-1 main">
                    <center class="page-header classname" style="color:#fff ; "><img src="image/logofinal.png" width="280" height="280"></center>

                    <div id="formRegistro">
                        <div id="confirm" align="center">
                            <h1 style="color: gray" align="center">Registro</h1>
                           
                            <form  id="Formulario" method="Post" action="Registrar" >

                           
                                <input type="text" class="form-control margin2px" name="txtNombreRegistro" id="txtNombreRegistro" required="required" placeholder="Nombre y Apellido" style="background: white; margin: 2px !important;"
                                       pattern="[A-Za-z].{1,}" onkeypress="return soloLetras(event)"
                                       >
                                
                                <input type="email" class="form-control margin2px" name="txtCorreoRegistro" id="txtCorreoRegistro" required="required" placeholder="e-mail" style="background: white; margin: 2px !important;"
                                       >

                                <input type="password" class="form-control margin2px"  name="txtPassRegistro" id="txtPassRegistro" required="required" placeholder="Password" style="background: white; margin: 2px !important;"
                                       pattern=".{6,}" title="6 o mas caracteres"
                                       >
                                <input type="password" class="form-control margin2px"  name="txtConfirmPassRegistro" id="txtConfirmPassRegistro" required="required" placeholder="Repeat Password" style="background: white; margin: 2px !important;"
                                       pattern=".{6,}" title="6 o mas caracteres"
                                       >

                                <input type="text" class="form-control margin2px" name="txtTelefonoRegistro" id="txtTelefonoRegistro" required="required" placeholder="Telefono" style="background: white; margin: 2px !important;"
                                       onkeypress="return soloNumero(event)">
                              
                                <input type="text" class="form-control margin2px" name="txtDireccionRegistro" id="txtDireccionRegistro" required="required"  placeholder="Direccion" style="background: white; margin: 2px !important;">

                                 <% if (request.getAttribute("Error") != null) {%>
                                    <p class="error" ><%= request.getAttribute("Error").toString()%></p>
                                    <% }%>
                                
                                    <input type="submit" class="botn" value="Registrar" id="btnRegistrarUsuario" style="margin: 10px !important;">
                                    <button onclick="location.href='index.jsp'" class="botn" style="width: 230px;">Ir al Login</button>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- Bootstrap core JavaScript
                                                ================================================== -->
                                                <!-- Placed at the end of the document so the pages load faster -->
                                                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
                                                <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
                                                <script src="dist/js/bootstrap.min.js"></script>
                                                <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
                                                <script src="assets/js/vendor/holder.min.js"></script>
                                                <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
                                                <script src="assets/js/ie10-viewport-bug-workaround.js"></script>
                </body>
                </html>