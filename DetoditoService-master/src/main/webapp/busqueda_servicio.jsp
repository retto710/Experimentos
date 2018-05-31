<%-- 
    Document   : busqueda_servicio
    Created on : Jun 24, 2017, 12:41:00 PM
    Author     : Alumnos
--%>

<%@page import="pe.edu.upc.DataAccess.CategoriasRep"%>
<%@page import="pe.edu.upc.entities.Categorias"%>
<%@page import="pe.edu.upc.DataAccess.ICategoriasRep"%>
<%@page import="pe.edu.upc.entities.Servicios"%>
<%@page import="java.util.List"%>
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
                    <a class="navbar-brand" href="#" >Detodito Services</a>
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


                    <form id="Formulario" method="post" action="ServiciosServlet" style="padding-bottom: 100px;">
                            <table  <%--class="fixed-height fixed-width fixed-cell table-spacing" --%> align="center" >
                                <tr>
                                    <td >
                                        <span class="input-group" >
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


                                        <select class=" select"  style="background-color: #fff;margin-left: 50px; padding: 5px; border-radius: 6px;" name="slCategorias">
                                            <option value="0" >Categoría</option>
                                                    <% for (Categorias categoria : categorias) {%>
                                                    <option value="<%=categoria.getId()%>" > <%= categoria.getNombre()%> </option>
                                                    <% }%> 
                                         </select>
                                        </td>
                                    </tr>

                                        </table>
                                    </form>  

                    <% List<Servicios> servicios = (List<Servicios>) request.getAttribute("BusquedaServicios");%>
                    <%for (Servicios servicio : servicios) {%>

                    <%--<%= // servicio.getProveedores() %>--%>
                    <form method="get" action="VerDetalleServlet" >        
                        <table class="table table-striped table-hover table-condensed table-bordered " >
                            <%if(servicio.getEstado().equals("espera")){%>
                            <tbody>
                                <tr>
                                    <td><%= servicio.getNombre()%></td>                                
                                    <td></td>
                                    <td style="text-align: right;" ><button type="submit" class="btn btn-default btn-sm">Ver Detalles</button></td>
                                </tr>
                                <tr class="info">
                                    <td style="text-align: left;"     width="300px" ><%= servicio.getDepartamentos().getNombre()%></td>
                                    <td style="text-align: center;"  width="300px"  ><%= servicio.getProvincias().getNombre()%></td>
                                    <td style="text-align: right;"   width="300px" ><%= servicio.getDistritos().getNombre()%></td>
                                </tr>
                            </tbody>
                            <%}%>
                        </table>
                        <input type="hidden" name="txtId" value="<%= servicio.getId()%>" >        



                    </form>
                    <%}%>
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