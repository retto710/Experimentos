/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upc.DataAccess.IPedidosRep;
import pe.edu.upc.DataAccess.IServiciosRep;
import pe.edu.upc.DataAccess.PedidosRep;
import pe.edu.upc.DataAccess.ServiciosRep;
import pe.edu.upc.entities.Pedidos;
import pe.edu.upc.entities.Servicios;

/**
 *
 * @author CASA
 */
@WebServlet(name = "CancelarPedido", urlPatterns = {"/CancelarPedido"})
public class CancelarPedido extends HttpServlet {

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
            out.println("<title>Servlet CancelarPedido</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CancelarPedido at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String idstring=request.getParameter("btn");
        int id=Integer.valueOf(idstring);
        IPedidosRep repo=new  PedidosRep();
        Pedidos aux=repo.GetPedidoByID(id);
        IServiciosRep repo2=new ServiciosRep();
        Servicios aux2=aux.getServicios();
        aux2.setEstado("espera");
        repo2.UpdateServicio(aux2);
        
        repo.DeletePedido(id);
         response.sendRedirect("mispedidos.jsp");
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
