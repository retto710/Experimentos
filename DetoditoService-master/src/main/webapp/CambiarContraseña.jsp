
<%@page import="pe.edu.upc.DataAccess.UsuariosRep"%>
<%@page import="pe.edu.upc.DataAccess.IUsuariosRep"%>
<%@page import="pe.edu.upc.entities.Usuarios"%>
<%@page import="java.util.List"%>
<%@page import="pe.edu.upc.entities.Categorias"%>
<%@page import="pe.edu.upc.DataAccess.ICategoriasRep"%>
<%@page import="pe.edu.upc.DataAccess.CategoriasRep"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="image/favicon.ico">
        <title>Detodito Services</title>

        <%--Dropdown Style--%>    <link rel="stylesheet" type="text/css" href="csscreados/dropdown.css">

        <!-- Bootstrap core CSS -->
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
        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <script src="assets/js/ie-emulation-modes-warning.js"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        
        <![endif]-->

        <script type="text/javascript">

            function validate_password()
            {
                //Cogemos los valores actuales del formulario
                pasActual = document.formName.passwordActual;
                pasNew1 = document.formName.passwordNew1;
                pasNew2 = document.formName.passwordNew2;
                //Cogemos los id's para mostrar los posibles errores
                id_epassActual = document.getElementById("epasswordActual");
                id_epassNew = document.getElementById("epasswordNew1");

                //Patron para los numeros
                var patron1 = new RegExp("[0-9]+");
                //Patron para las letras
                var patron2 = new RegExp("[a-zA-Z]+");

                if (pasNew1.value == pasNew2.value && pasNew1.value.length >= 6 && pasActual.value != "" && pasNew1.value.search(patron1) >= 0 && pasNew1.value.search(patron2) >= 0) {
                    //Todo correcto!!!
                    return true;
                } else {
                    if (pasNew1.value.length < 3)
                        id_epassNew.innerHTML = "La longitud mínima tiene que ser de 3 caracteres";
                    else if (pasNew1.value != pasNew2.value)
                        id_epassNew.innerHTML = "La copia de la nueva contraseña con coincide";
                    else 
                        id_epassNew.innerHTML = "";
                    if (pasActual.value == "")
                        id_epassActual.innerHTML = "Indicar tu contraseña actual";
                    else
                        id_epassActual.innerHTML = "";
                    return false;
                }
            }

        </script>
    </head>

    <body  background="image/background5.jpg" >

       <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">DTServices</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- <a class="navbar-brand" href="#">Project name</a>-->
                </div>

                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="home.jsp">Servicios</a></li>

                        <li><a href="Registro_Servicio.jsp">Registro de Servicio</a></li>
                            <%if (session.getAttribute("Usuario") == null) {%>
                        <li>
                            <a href="login.jsp" >Iniciar Sesion</a>
                        </li>
                        <% } else if (session.getAttribute("Usuario") != null) {%>                              
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false" >
                                <%= (session.getAttribute("Usuario"))%>
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu" role="menu" >
                                <li>
                                    <a href="perfilUsuario.jsp" title="Perfil">Perfil</a>
                                </li>
                                <li>
                                    <a href="logout" title="Logout">Log out</a>
                                </li>
                                <li>
                                    <a href="mispedidos.jsp" title="Mispedidos">Mis Pedidos</a>
                                </li>
                                <li>
                                    <a href="miservicios.jsp" title="MisServicios">Mis Servicios</a>
                                </li>
                            </ul>
                        </li>
                        <% }%>   
                        <%if (session.getAttribute("Usuario") == null) {%>
                        <li>
                            <a href="registro.jsp" title="Registro" >Registro</a>
                        </li>
                        <% } else if (session.getAttribute("Usuario") != null) {%>                            
                        <% }%>           
                    </ul>

                </div>
            </div>
        </nav>



        <div class="container-fluid" >
            <center class="page-header classname" style="color:#000 ; "><img src="image/logofinal.png" width="240" height="260"> <%--<%= usuario.getNombre() %>--%></center>

            <div >
                
                    <center>
                    <header style="color: gray ; " ><h1>Cambiar Contraseña</h1></header></center>
                    <center>
                        <form name="formName" action="index.jsp" method="post" onsubmit="return validate_password()">
                           
                            <div id="epasswordActual" style="color:gray;"></div>
                            <div>Contraseña Actual: <input type="password" placeholder="Contraseña Actual" name="passwordActual"style="background: white"/></div>
                            <div id="epasswordNew1" style="color:#f00;"></div>
                            <div>Nuevo Contraseña: <input type="password" placeholder="Nueva Contraseña"class="textbox" name="passwordNew1" style="background: white"/></div>
                            <div>Repite Contraseña: <input type="password" placeholder="Nueva Contraseña" class="textbox"name="passwordNew2" style="background: white"/></div>
                            <br>
                            <div><a href="perfilUsuario.jsp"><input type="button" value="volver" class="btn btn-primary">  </a>
                                <input type="submit" value="Actualizar" class="btn btn-primary"/></div>
                            
                        </form>
                    </center>
                
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
