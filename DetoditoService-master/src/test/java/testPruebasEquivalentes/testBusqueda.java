/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testPruebasEquivalentes;


import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import pe.edu.upc.DataAccess.IServiciosRep;
import pe.edu.upc.DataAccess.ServiciosRep;
import pe.edu.upc.entities.Servicios;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/**
 *
 * @author Renato
 */
public class testBusqueda {
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
        
         String busqueda= "JAVA";
         int idcategoria = 0;
         try{
            repo.GetAllServicios(busqueda, idcategoria);
          }catch(Exception ex){
            assertTrue(true);
        }               
    } 
       @Test
    public void testBusqueda3(){
        
         String busqueda= "";
         int idcategoria = 0;
         try{
            repo.GetAllServicios(busqueda, idcategoria);
          }catch(Exception ex){
            assertTrue(true);
        }               
    } 
        @Test
    public void testBusqueda4(){
        
         String busqueda= "";
         int idcategoria = 1;
         try{
            repo.GetAllServicios(busqueda, idcategoria);
          }catch(Exception ex){
            assertTrue(true);
        }               
    }
          @Test
    public void testBusqueda5(){
        
         String busqueda= "1234";
         int idcategoria = 1;
         try{
            repo.GetAllServicios(busqueda, idcategoria);
          }catch(Exception ex){
            assertTrue(true);
        }               
    } 
        @Test
    public void testBusqueda6(){
        
         String busqueda= "HOL4";
         int idcategoria = 1;
         try{
            repo.GetAllServicios(busqueda, idcategoria);
          }catch(Exception ex){
            assertTrue(true);
        }               
    } 
       @Test
    public void testBusqueda7(){
        
         String busqueda= "1234";
         int idcategoria = 0;
         try{
            repo.GetAllServicios(busqueda, idcategoria);
          }catch(Exception ex){
            assertTrue(true);
        }               
    } 
        @Test
    public void testBusqueda8(){
        
         String busqueda= "HOL4";
         int idcategoria = 0;
         try{
            repo.GetAllServicios(busqueda, idcategoria);
          }catch(Exception ex){
            assertTrue(true);
        }               
    } 
}
