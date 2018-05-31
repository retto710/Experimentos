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
import pe.edu.upc.DataAccess.CategoriasRep;
import pe.edu.upc.DataAccess.DepartamentosRep;
import pe.edu.upc.DataAccess.DistritosRep;
import pe.edu.upc.DataAccess.ICategoriasRep;
import pe.edu.upc.DataAccess.IDepartamentosRep;
import pe.edu.upc.DataAccess.IDistritosRep;
import pe.edu.upc.DataAccess.IProveedoresRep;
import pe.edu.upc.DataAccess.IProvinciasRep;
import pe.edu.upc.DataAccess.IServiciosRep;
import pe.edu.upc.DataAccess.ITipoDocumentoRep;
import pe.edu.upc.DataAccess.IUsuariosRep;
import pe.edu.upc.DataAccess.ProveedoresRep;
import pe.edu.upc.DataAccess.ProvinciasRep;
import pe.edu.upc.DataAccess.ServiciosRep;
import pe.edu.upc.DataAccess.TipoDocumentoRep;
import pe.edu.upc.DataAccess.UsuariosRep;
import pe.edu.upc.entities.Categorias;
import pe.edu.upc.entities.Departamentos;
import pe.edu.upc.entities.Distritos;
import pe.edu.upc.entities.Proveedores;
import pe.edu.upc.entities.Provincias;
import pe.edu.upc.entities.Servicios;
import pe.edu.upc.entities.TipoDocumento;
import pe.edu.upc.entities.Usuarios;

/**
 *
 * @author Andre Puente
 */
@WebServlet(name = "RegistrarServicio", urlPatterns = {"/RegistrarServicio"})
public class RegistrarServicio extends HttpServlet {

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
            out.println("<title>Servlet RegistrarServicio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarServicio at " + request.getContextPath() + "</h1>");
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
        
        HttpSession session = request.getSession(false);
        String numeroDocumento = request.getParameter("txtCodigoDocumento");
        String ServicioOfrecer = request.getParameter("txtServicioOfrecer");
        String Observaciones = request.getParameter("txtObservaciones");
        String Descripcion = request.getParameter("txtDescripcionServicio");
        int usuarioId= (int)session.getAttribute("UsuarioId");
        int Categoria=Integer.valueOf(request.getParameter("slCategorias"));
        int TipoDocumentoId= Integer.valueOf(request.getParameter("slTipoDocumento"));
        int Distrito= Integer.valueOf(request.getParameter("slDistritos"));
        int Departamento = '1';
        int Provincia = '1';
        
        int dni = Integer.valueOf(request.getParameter("txtCodigoDocumento"));
        if(dni%1 != 0 || numeroDocumento.length() != 8 || "00000000".equals(numeroDocumento) ){
        request.setAttribute("Error","El campo debe contener 8 digitos, ser mayor a 0 y ser entero.");
        request.getRequestDispatcher("Registro_Servicio.jsp").forward(request, response);
        }else {
            /*llamada de Interfaces*/

            IServiciosRep serRep=  new ServiciosRep();
            IDistritosRep distritosRep = new DistritosRep();
            ITipoDocumentoRep tipoDocumentoRep = new TipoDocumentoRep();
            IProveedoresRep provedorRep = new ProveedoresRep();
            IUsuariosRep usuarioRep = new UsuariosRep();
            ICategoriasRep catRep = new CategoriasRep();
            IDepartamentosRep depRep = new DepartamentosRep();
            IProvinciasRep proRep = new ProvinciasRep();


            Categorias categorias = catRep.GetCategoriasID(Categoria);
            TipoDocumento tipodoc= tipoDocumentoRep.GetTipoDocumento(TipoDocumentoId);
            Distritos distritos = distritosRep.GetDistritoById(Distrito);        
            Usuarios usuario = usuarioRep.GetUsuarioById(usuarioId);

            Departamentos departamentos = depRep.GetDepartamentosById(1);
            Provincias provincias = proRep.GetProvinciasById(1);

            Proveedores proveedor = new Proveedores();
            proveedor.setTipoDocumento(tipodoc);
            proveedor.setCodigoDocumento(numeroDocumento);
            proveedor.setUsuarioId(usuarioId);        
            provedorRep.InsertProveedor(proveedor);


            Servicios servicios = new Servicios();
            /*crear objeto departamento para jalar el id*/
            servicios.setDistritos(distritos);
            servicios.setCategorias(categorias);
            servicios.setObservaciones(Observaciones);
            servicios.setDescripcion(Descripcion);
            servicios.setNombre(ServicioOfrecer);
            servicios.setProveedores(proveedor);
            servicios.setDepartamentos(departamentos);
            servicios.setProvincias(provincias);
            servicios.setContactar(true);
            servicios.setEstado("espera");
            serRep.InsertServicio(servicios);
            session.setAttribute("UsuarioNombre", usuario.getNombre());
            response.sendRedirect("ConfirmacionRegistroServicio.jsp");
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
