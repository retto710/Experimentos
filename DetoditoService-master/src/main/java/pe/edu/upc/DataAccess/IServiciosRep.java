/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.DataAccess;

import java.util.List;
import pe.edu.upc.entities.Servicios;

/**
 *
 * @author Diego
 */
public interface IServiciosRep {
    List<Servicios> GetAllServicios();
    List<Servicios> GetAllServicios(String busqueda, int categoriaId);
    List<Servicios> GetServiciosByProveedorId(int id);
    Servicios GetServicioById(int servicioId);
   void InsertServicio(Servicios servicio);
   void UpdateServicio(Servicios servicio);
   void deleteServicio(int id);
   
   void deleteServicioByNombre(String nombre);
   Servicios getServicioByNombre(String nombre);
}
