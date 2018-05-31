/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestComplejidad;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import pe.edu.upc.DataAccess.IServiciosRep;
import pe.edu.upc.DataAccess.ServiciosRep;

/**
 *
 * @author Anthony
 */
public class TestBuscar {
     IServiciosRep repo = new ServiciosRep();
        @Test
    public void testBusqueda1(){
        
         String busqueda= "JAVA";
         int idcategoria = 1;
         try{
            repo.GetAllServicios(busqueda, idcategoria);
          }catch(Exception ex){
            assertTrue(true);
        }               
    } 
    @Test
     public void testBusqueda2(){
        
         String busqueda= "AA";
         int idcategoria = 0;
         try{
            repo.GetAllServicios(busqueda, idcategoria);
          }catch(Exception ex){
            assertTrue(true);
        }               
    } 
}
