/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import pe.edu.upc.DataAccess.IUsuariosRep;
import pe.edu.upc.DataAccess.UsuariosRep;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.upc.entities.Usuarios;

/**
 *
 * @author Andre Puente
 */
@WebServlet(name = "Registrar", urlPatterns = {"/Registrar"})
public class Registrar extends HttpServlet {

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
            out.println("<title>Servlet Registrar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registrar at " + request.getContextPath() + "</h1>");
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

        IUsuariosRep usuarioRep = new UsuariosRep();

        String nombre = request.getParameter("txtNombreRegistro");
        String direccion = request.getParameter("txtDireccionRegistro");
        String telefono = request.getParameter("txtTelefonoRegistro");
        String correoElectronico = request.getParameter("txtCorreoRegistro");
        String password = request.getParameter("txtPassRegistro");
        String Confirmpassword = request.getParameter("txtConfirmPassRegistro");

        if (usuarioRep.UsuarioExists(correoElectronico) == true) {
            request.setAttribute("Error", "El correo ya existe");           
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        } else if (!password.equals(Confirmpassword)) {
            request.setAttribute("Error", "Las Contraseñas no coinciden");           
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        } else if (telefono.length()!= 9) {
            request.setAttribute("Error", "El telefono debe contener 9 digitos");           
                request.getRequestDispatcher("registro.jsp").forward(request, response);
        } else if (usuarioRep.UsuarioExists(correoElectronico) != true) {
            Usuarios usuario = new Usuarios();
            usuario.setNombre(nombre);
            usuario.setDireccion(direccion);
            usuario.setTelefono(telefono);
            usuario.setCorreoElectronico(correoElectronico);
            usuario.setPassword(password);

            usuarioRep.InsertUsuario(usuario);

            HttpSession session = request.getSession(true);
            session.setAttribute("Correo", correoElectronico);
            session.setAttribute("Usuario", nombre);
            session.setAttribute("Usuario", usuario.getNombre());
            session.setAttribute("UsuarioId", usuario.getId());
            session.setAttribute("CurrentUser", usuario);
            response.sendRedirect("ConfirmacionRegistro.jsp");

        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
