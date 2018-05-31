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
import javax.servlet.http.HttpSession;
import pe.edu.upc.DataAccess.IUsuariosRep;
import pe.edu.upc.DataAccess.UsuariosRep;
import pe.edu.upc.entities.Usuarios;

/**
 *
 * @author Andre Puente
 */
@WebServlet(name = "CambioPassword", urlPatterns = {"/CambioPassword"})
public class CambioPassword extends HttpServlet {

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
            out.println("<title>Servlet CambioPassword</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CambioPassword at " + request.getContextPath() + "</h1>");
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
       
         String password=request.getParameter("passwordActual");
        String Newpassword1 = request.getParameter("passwordNew1");
        String Newpassword2 = request.getParameter("passwordNew2");
        HttpSession session=request.getSession(false);
       /* session.getAttribute("CurrentUser");*/
        IUsuariosRep usuarioRep = new UsuariosRep();
        
        
        Usuarios objUsuarios = (Usuarios) session.getAttribute("CurrentUser");
      
        if(objUsuarios.getPassword().equals(password) && Newpassword1.equals(Newpassword2) )
        {
            objUsuarios.setPassword(Newpassword1);
            usuarioRep.UpdateUSer(objUsuarios);
         
            response.sendRedirect("CambiarPassword.jsp");
            
        }
        
        
        
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
