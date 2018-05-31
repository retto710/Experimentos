

<%@page import="pe.edu.upc.entities.Categorias"%>
<%@page import="pe.edu.upc.DataAccess.ICategoriasRep"%>
<%@page import="pe.edu.upc.DataAccess.CategoriasRep"%>
<%@page import="pe.edu.upc.entities.TipoDocumento"%>
<%@page import="pe.edu.upc.DataAccess.TipoDocumentoRep"%>
<%@page import="pe.edu.upc.DataAccess.ITipoDocumentoRep"%>
<%@page import="pe.edu.upc.entities.Distritos"%>
<%@page import="java.util.List"%>
<%@page import="pe.edu.upc.DataAccess.DistritosRep"%>
<%@page import="pe.edu.upc.DataAccess.IDistritosRep"%>
<%@page import="pe.edu.upc.DataAccess.ServiciosRep"%>
<%@page import="pe.edu.upc.DataAccess.IServiciosRep"%>
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

        <link rel="stylesheet" href="jquery-ui-1.12.1/jquery-ui.min.css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet"> 
        <script src="jquery-ui-1.12.1/external/jquery/jquery.js"></script>
        <script src="jquery-ui-1.12.1/jquery-ui.min.js"></script>
        <script src="validations.js"></script>


        <%--boton--%>
        <link href="csscreados/btn.css" type="text/css" rel="stylesheet">
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



    <body background="image/background5.jpg" align="center">
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

            <div class="row"> 

                <div class="col-sm-9 col-sm-offset- col-md-10 col-md-offset-1 main">
                    <center class="page-header classname" style="color:#fff ; "><img src="image/logofinal.png" width="280" height="280"></center>

                    <div id="formRegistro">
                        <div id="confirm">
                            <h1 style="color: gray">Registro de Servicios</h1>
                            <center>
                                
                                <form id="Formulario" method="Post" action="RegistrarServicio" >

                              <% IDistritosRep disRep = new DistritosRep(); %>
                                <% List<Distritos> distritos = disRep.GetAllDistritos();%>
                                <select id="selectDistrito" class=" form-control"  style="background-color:  #fff" name="slDistritos" width="500" required="required">
                                    <option value="" >Distrito</option>

                                    <% for (Distritos distrito : distritos) {%>
                                    <option value="<%=distrito.getId()%>"><%= distrito.getNombre()%> </option>
                                    <% }%> 
                                </select>
                               
                                
                                <% ICategoriasRep catRep = new CategoriasRep(); %>
                                    <% List<Categorias> categorias = catRep.GetAllCategorias(); %>
                                <select class=" form-control"  style="background-color:  #fff " name="slCategorias" required="required" >
                                        <option value="" >Categoría</option>

                                        <% for (Categorias categoria : categorias) {%>
                                        <option value="<%=categoria.getId()%>" > <%= categoria.getNombre()%> </option>
                                        <% }%> 
                                    </select>
                 
                                    
                                    

                                <br>

                                <% ITipoDocumentoRep tipRep = new TipoDocumentoRep(); %>
                                <% List<TipoDocumento> tipoDocs = tipRep.GetAllDocumentos();%>
                                <select class="form-control"  style="background-color:  #fff"name="slTipoDocumento" required="required" >
                                    <option value="" >Tipo de Documento</option>

                                    <% for (TipoDocumento tipoDoc : tipoDocs) {%>
                                    <option value="<%=tipoDoc.getId()%>"><%= tipoDoc.getNombre()%> </option>
                                    <% }%> 
                                </select>


                                <input type="number" class="form-control" name="txtCodigoDocumento" id="txtCodigoDocumento" required="required" placeholder="Numero del Documento" style="background: white" onchange="ValidateRegisterService()" min="0">
                                <div id="validateDni"></div>
                                <br>
                                <input type="text"  class="form-control" name="txtServicioOfrecer" id="txtServicioOfrecer" required="required" placeholder="Servicio a Ofrecer" style="background: white">

                                <textarea type="text"  name="txtDescripcionServicio" class="form-control" id="txtDescripcionServicio" required="required" placeholder="Descripcion del Servicio" style="background: white" rows="5" cols="31"></textarea>
                                <textarea type="text"  class="form-control"name="txtObservaciones" id="txtObservaciones" required="required" placeholder="Observaciones" style="background: white" rows="5" cols="31" ></textarea>

                                <br>
                                <% if (request.getAttribute("Error") != null) {%>
                                <p class="error" style="color: red;font-family: cursive;"><%= request.getAttribute("Error").toString()%></p>
                                    <% }%>
                              
                                    <input type="submit"  class="botn" value="Registrar Servicio" onsubmit="return ValidateRegisterService()" style="margin: 10px !important;" >   
                                <button onclick="location.href='home.jsp'" class="botn" style="width: 230px;">Ir al Inicio</button>
                                <br><br>
                            </form>
                            </center>      
                        </div></div>
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