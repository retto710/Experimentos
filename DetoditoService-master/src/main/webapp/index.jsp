

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
         <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="image/favicon.ico">
        <title>DetoditoServices</title>

        <!--<link rel="stylesheet" href="jquery-ui-1.12.1/jquery-ui.min.css">-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!--<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">--> 
        <!--<script src="jquery-ui-1.12.1/jquery-ui.min.js"></script>-->
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
        <link href="csscreados/btn.css" type="text/css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="csscreados/panelpage.css">
        <!--Icono de los input-->
        <link rel="stylesheet" type="text/css" href="csscreados/IconoInput.css">
        <!--Icono de los input-->
        <link rel="stylesheet" type="text/css" href="csscreados/btn.css">
        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <link href="csscreados/error.css" type="text/css" rel="stylesheet">
        <script src="assets/js/ie-emulation-modes-warning.js"></script>


    </head>

    <body background="image/background5.jpg">
       
        <div class="container-fluid" >

            <div class="row" style=" margin-top: -30px;"> 

                <div class="col-sm-9 col-sm-offset- col-md-10 col-md-offset-1 main">
                    <center class="page-header classname" style="color:#fff ;"><img src="image/logofinal.png" width="280" height="280"></center>
                    <!------------------------------------------------------------------------------------------------------------------------->
                    <div id="container">

                        <div id="formLogin">
                            <div id="confirm" align="center">
                                <h1 style="color: gray" align="center">Login</h1>
                                <form id="Formulario" method="Post" action="Login" onsubmit="return ValidateLogin()">
                                    <p></p>
                                    <input type="email" class="form-control" name="txtUsuarioLogin" id="txtUsuarioLogin" onchange="ValidateUsername()" required="required" placeholder="Usuario" style="background: white">
                                    <div id="validateUsername"></div>
                                    <p></p>
                                    
                                    <input type="password" class="form-control" name="txtPassLogin" id="txtPassLogin" onchange="ValidatePassword()" required="required" placeholder="Password" style="background: white">
                                    <div id="validatePassword"></div>
                                    <br>
                                    <% if (request.getAttribute("Error") != null) {%>
                                    <p class="error" ><%= request.getAttribute("Error").toString()%></p>
                                    <% }%>
                                    <div>
                                       
                                       
<!--                                        <input type="submit" class="botn marginBottom" value="Acceder" onsubmit="return ValidateLogin()" id="btnAcceder" > -->
                                       <button onclick="location.href='Login'" class="botn" style="width: 230px;" id="btnAcceder">Login</button>
                                    	<button onclick="location.href='registro.jsp'" class="botn" style="width: 230px;" id="btnRegistrar">Registrar</button>
                                       
                                    </div>
                                   
                                   
                                </form>
                                    
                            </div>
                        </div>
                    </div>

                </div></div></div>
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