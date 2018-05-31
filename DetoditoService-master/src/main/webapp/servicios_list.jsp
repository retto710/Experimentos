<%-- 
    Document   : servicios_list
    Created on : Jun 30, 2017, 5:14:25 PM
    Author     : Diego
--%>
<%@page import="java.util.List"%>
<%@page import="pe.edu.upc.entities.Servicios"%>
<%@page import="pe.edu.upc.DataAccess.ServiciosRep"%>
<%@page import="pe.edu.upc.DataAccess.IServiciosRep"%>
<%@page contentType="application/x-www-form-urlencoded; charset=UTF-8"%>
<%
    IServiciosRep serviciosRep = new ServiciosRep();
    List<Servicios> servicios = serviciosRep.GetAllServicios();
    String query = request.getParameter("term");

    int numeroMaximoServicios = 1;
    for (Servicios servicio : servicios) {
        if (servicio.getNombre().toLowerCase().startsWith(query.toLowerCase())) {
            out.print(servicio.getNombre());
            if (numeroMaximoServicios >= 5) {
                break;
            }
            numeroMaximoServicios++;
        }
    }
%>