
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
            <div class="row"> 

                <div class="col-sm-9 col-sm-offset- col-md-10 col-md-offset-1 main ">
                    <div class="page-header classname " style="color:#000   " align="center"><img src="image/logofinal.png" width="280" height="280"></div>


                    <form id="Formulario" method="post" action="ServiciosServlet" >
                        <table  <%--class="fixed-height fixed-width fixed-cell table-spacing" --%> align="center">

                            <tr>
                                <td >
                                    <span class="input-group" >
                                        <!--<span class="glyphicon glyphicon-search" hidden="true" style="color: white"></span>-->
                                        <input class="searchPosition"  type="search" name="buscar" placeholder='¿Que Busca?' style="background-color: #fff;margin-left: -70px;margin-right: 10px;" >      
                                    </span>

                                </td>
                                <td>
                                    <button class="btn btn-primary" name="busqueda" ><span class="glyphicon glyphicon-search"  ></span></button>
                                    <br>
                                </td>
                            </tr> 

                            <tr>
                                <td >
                                    <br>
                                    <% ICategoriasRep catRep = new CategoriasRep(); %>
                                    <% List<Categorias> categorias = catRep.GetAllCategorias(); %>
                                    <%--  <div class="dropdown">
                                        <button class="dropbtn" >Categoría</button>
                                        <div class="dropdown-content" >
                                            <% for (Categorias categoria : categorias) {%>

                                            <a href="#" value="<%=categoria.getId()%>" > <%= categoria.getNombre()%></a>
                                            <% }%>
                                        </div>
                                    </div>--%>

                                    <select class=" select"  style="background-color:  #fff;margin-left: 50px; padding: 5px; border-radius: 6px;" name="slCategorias">
                                        <option value="0" >Categoría</option>

                                        <% for (Categorias categoria : categorias) {%>
                                        <option value="<%=categoria.getId()%>" > <%= categoria.getNombre()%> </option>
                                        <% }%> 
                                    </select>
                                </td>
                            </tr>

                        </table>
                    </form>


                    <div class="table-striped">
                        <br>

                        <form action="MasBuscado" method="get">
                            <table <%--class="table table-striped"  --%>align="center"  > 
                                <thead>
                                    <tr >
                                        <td style="color: gray   "  colspan="2" align="center"><br><h2>Más Buscado<h2></td>
                                                    </tr>
                                                    </thead>
                                                    <tbody align="center">
                                                        <tr style="background-color: #fff">
                                                            <td align="center">Programacion Profesores</td>
                                                            <td><button type="submit" name="PrograProfe"  ><img src="image/logo_Profesor.png"  width="40" height="40"></button></td>

                                                        </tr>
                                                        <tr style="background-color: #ededed">
                                                            <td>Comidas</td>
                                                            <td><button ><img src="image/iconoComida.png"  width="40" height="40"></button></td>

                                                        </tr>
                                                        <tr style="background-color: #fff">
                                                            <td>Transporte</td>
                                                            <td><button><img src="image/iconoTaxi.png" witdth="40" height="40"></button></td>

                                                        </tr>
                                                        <tr style="background-color: #ededed">
                                                            <td>Dj</td>
                                                            <td><button ><img src="image/iconoDj.png"  width="40" height="40"></button></td>


                                                        </tr>
                                                        <tr style="background-color: #fff">
                                                            <td>Tecnologia</td>
                                                            <td><button ><img src="image/iconoTecnologia.png"  width="50" height="40"></button></td>

                                                        </tr>
                                                    </tbody>
                                                    </table>
                                                    </form>
                                                    </div>
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
