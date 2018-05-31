
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
    </head>

    <body  background="image/background5.jpg" >

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">DServices</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="index.jsp" class="navbar-brand">Detodito Service</a>
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
                                    <a href="logout" title="Logout">Log out</a>
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

            
            <form class="form-horizontal" action="ActualizarPerfil" method="Post">
                <% IUsuariosRep usuariosRep = new UsuariosRep();%>
                <% Usuarios usuario = (Usuarios) usuariosRep.GetUsuarioById(Integer.valueOf(session.getAttribute("UsuarioId").toString()));%>
              <%--  <%Usuarios currentUser = (Usuarios) session.getAttribute("CurrentUser");%>--%>
              
                <center class="page-header classname" style="color:#000 ; "><img src="image/logofinal.png" width="240" height="260"> <%--<%= usuario.getNombre() %>--%></center>
             
                <fieldset>

                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-2 control-label">Correo electrónico</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="inputEmail" placeholder="Email" value="<%= usuario.getCorreoElectronico()%>" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        
                        <label for="inputPassword" class="col-lg-2 control-label">Contraseña</label>
                        <div class="col-lg-10">
                              
                            <input type="password" class="form-control" id="inputPassword" name="txtContraseña" placeholder="Contraseña"value="<%=usuario.getPassword()%>" readonly="readonly">
                               
                        </div>
                            <div class="col-lg-10 col-lg-offset-2">
                                <a href="CambiarPassword.jsp"><input type="button" class="btn btn-primary" value="Cambiar Contraseña" ></a>
                            </div>
                    </div>
                    <div class="form-group">
                        
                        <label for="textDireccion" class="col-lg-2 control-label">Direccion</label>
                        <div class="col-lg-10">
                            
                            <textarea class="form-control" rows="3" id="textDireccion" name="txtDireccion" readonly="readonly" ><%= usuario.getDireccion()%></textarea>                            
                           
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputTelefono" class="col-lg-2 control-label">Telefono</label>
                        <div class="col-lg-10">
                           
                            <input type="text" class="form-control" id="inputTelefono" name="txtTelefono" placeholder="Telefono" value="<%= usuario.getTelefono()%>" readonly="readonly">
                           
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <a href="index.jsp"> <input type="button" class="btn btn-primary" value="Regresar" ></a>
                          
                        </div>
                    </div>
                </fieldset>
            </form>
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
