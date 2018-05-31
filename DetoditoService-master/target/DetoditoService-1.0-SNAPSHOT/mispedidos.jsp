<%-- 
    Document   : mispedidos
    Created on : 15/04/2018, 12:06:23 AM
    Author     : CASA
--%>

<%@page import="pe.edu.upc.DataAccess.UsuariosRep"%>
<%@page import="pe.edu.upc.DataAccess.IUsuariosRep"%>
<%@page import="pe.edu.upc.DataAccess.IPedidosRep"%>
<%@page import="pe.edu.upc.DataAccess.PedidosRep"%>
<%@page import="pe.edu.upc.entities.Pedidos"%>
<%@page import="java.util.List"%>
<%@page import="pe.edu.upc.entities.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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

                <div class="col-sm-9 col-sm-offset- col-md-10 col-md-offset-1 main">
                    <center class="page-header classname" style="color:#fff ; "><img src="image/logofinal.png" width="280" height="280"></center>

                    <div id="formRegistro">
                        <div id="confirm">
                            <h1 style="color:gray;text-align: center">Mis Pedidos</h1>
                            
                            <center>
                            <%Usuarios actual= (Usuarios)session.getAttribute("CurrentUser");
                                IPedidosRep repo=new PedidosRep();
                                IUsuariosRep repo2=new UsuariosRep();
                            %>
                            <%List <Pedidos> listita=repo.getPedidosByUserId(actual.getId());
                            %>
                            <form method="POST" action="CancelarPedido">
                            <table class="table table-striped table-hover table-bordered " >
                                <th style="text-align: center">Servicio</th>
                                <th style="text-align: center">Descripcion</th>
                                <th style="text-align: center">Fecha</th>
                                <th style="text-align: center">Proveedor</th>
                                <th style="text-align: center">Distrito</th>
                                <th style="text-align: center">Cancelar Pedido</th>
                                <%for(Pedidos p:listita){%>



                                <tr class="info" style="text-align: center">
                                <td><%=p.getServicios().getNombre()%></td>
                                <td><%=p.getServicios().getDescripcion()%></td>
                                <td><%=p.getFecha()%></td>
                                <td><%Usuarios aux=repo2.GetUsuarioById(p.getServicios().getProveedores().getUsuarioId());%><%=aux.getNombre()%></td>
                                <td><%=p.getServicios().getDistritos().getNombre()%></td>
                                <td><button id="eliminar<%=p.getId()%>" name="btn" value="<%=p.getId()%>">Cancelar</button> </td>
                                </tr>                
                                <%}%>
                            </table>
                            </form>
                          </center>
                        </div>
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
