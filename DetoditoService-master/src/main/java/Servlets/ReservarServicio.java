/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.upc.DataAccess.IPedidosRep;
import pe.edu.upc.DataAccess.IServiciosRep;
import pe.edu.upc.DataAccess.PedidosRep;
import pe.edu.upc.DataAccess.ServiciosRep;
import pe.edu.upc.entities.Pedidos;
import pe.edu.upc.entities.Servicios;
import pe.edu.upc.entities.Usuarios;

/**
 *
 * @author Diego
 */
@WebServlet(name = "ReservarServicio", urlPatterns = {"/ReservarServicio"})
public class ReservarServicio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReservarServicio</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReservarServicio at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       HttpSession session = request.getSession(false);
         int servicioId = Integer.valueOf(request.getParameter("txtId"));
        IServiciosRep serviciosRep = new ServiciosRep();
        Servicios servicio = serviciosRep.GetServicioById(servicioId);
        
        request.setAttribute("Servicio", servicio);
        session.setAttribute("Servicios",servicio);
        RequestDispatcher rd = request.getRequestDispatcher("RealizarPedido.jsp");        
        rd.forward(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
                HttpSession session = request.getSession(false);
                String observaciones = request.getParameter("txtObservaciones");
                String fecha = request.getParameter("datepicker");
                  
                IPedidosRep pedidosRep = new PedidosRep();
                Usuarios objUsuario = (Usuarios) session.getAttribute("CurrentUser");
                Servicios objservicio = (Servicios) session.getAttribute("Servicios");
                                  
                objservicio.setEstado("reservado");
                 IServiciosRep servirep = new ServiciosRep();
                    servirep.UpdateServicio(objservicio);
                
                IPedidosRep pedidosrep = new PedidosRep();
                Pedidos pedidos = new Pedidos();
                
                pedidos.setUsuarios(objUsuario);
                pedidos.setObservaciones(observaciones);
                pedidos.setServicios(objservicio);
                pedidos.setFecha(fecha);
                
                pedidosRep.InsertPedido(pedidos);
                
                response.sendRedirect("ConfirmacionPedido.jsp");
                
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
