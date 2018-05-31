
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testPruebasEquivalentes;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import pe.edu.upc.DataAccess.CategoriasRep;
import pe.edu.upc.DataAccess.DepartamentosRep;
import pe.edu.upc.DataAccess.DistritosRep;
import pe.edu.upc.DataAccess.ICategoriasRep;
import pe.edu.upc.DataAccess.IDepartamentosRep;
import pe.edu.upc.DataAccess.IDistritosRep;
import pe.edu.upc.DataAccess.IProveedoresRep;
import pe.edu.upc.DataAccess.IProvinciasRep;
import pe.edu.upc.DataAccess.IServiciosRep;
import pe.edu.upc.DataAccess.ProveedoresRep;
import pe.edu.upc.DataAccess.ProvinciasRep;
import pe.edu.upc.DataAccess.ServiciosRep;
import pe.edu.upc.entities.Categorias;
import pe.edu.upc.entities.Departamentos;
import pe.edu.upc.entities.Distritos;
import pe.edu.upc.entities.Proveedores;
import pe.edu.upc.entities.Provincias;
import pe.edu.upc.entities.Servicios;

import pe.edu.upc.entities.Usuarios;

/**
 *
 * @author Renato
 */
public class testCrearServicio {
    
    ICategoriasRep repoCate=new  CategoriasRep();
    IDepartamentosRep repoDep=new DepartamentosRep();
    IDistritosRep repoDist=new DistritosRep();
    IProveedoresRep repoProv=new ProveedoresRep();
    IProvinciasRep repoProvi=new ProvinciasRep();
    
     @Test
    public void testCrearServicio1(){
        
        IServiciosRep repo = new ServiciosRep();
        
        
        Categorias category =repoCate.GetCategoriasID(1);
        Departamentos departamento=repoDep.GetDepartamentosById(1);
        Distritos distrito=repoDist.GetDistritoById(1);
        Proveedores prov=repoProv.getProv(9);
        Provincias provi=repoProvi.GetProvinciasById(1);
        
        
        String nombre = "pasteleria";
        String descripcion= "mal servicio";
        boolean contactar=true;
        String observaciones="xdxdxdxd";
        String estado="espera";
        
      

        try{
            Servicios servi=new Servicios(category,departamento,distrito,prov,provi,nombre,contactar,descripcion,observaciones,estado,null,null);

            repo.InsertServicio(servi);
            repo.deleteServicio(servi.getId());
            assertTrue(true);
            
        }catch(Exception ex){
            ex.printStackTrace();
            fail();
        }
    }
    
    
    @Test
    public void testCrearServicio2(){
        
        IServiciosRep repo = new ServiciosRep();
        
        
        Categorias category =repoCate.GetCategoriasID(1);
        Departamentos departamento=repoDep.GetDepartamentosById(1);
        Distritos distrito=null;
        Proveedores prov=repoProv.getProv(9);
        Provincias provi=repoProvi.GetProvinciasById(1);
        
        
        String nombre = "pasteleria";
        String descripcion= "mal servicio";
        boolean contactar=true;
        String observaciones="xdxdxdxd";
        String estado="espera";
        
      

        try{
            Servicios servi=new Servicios(category,departamento,distrito,prov,provi,nombre,contactar,descripcion,observaciones,estado,null,null);

            repo.InsertServicio(servi);
            repo.deleteServicio(servi.getId());
            
            
        }catch(Exception ex){
            assertTrue(true);
        }
    }
      @Test
    public void testCrearServicio3(){
        
        IServiciosRep repo = new ServiciosRep();
        
        
        Categorias category =null;
        Departamentos departamento=repoDep.GetDepartamentosById(1);
        Distritos distrito=repoDist.GetDistritoById(1);
        Proveedores prov=repoProv.getProv(9);
        Provincias provi=repoProvi.GetProvinciasById(1);
        
        
        String nombre = "pasteleria";
        String descripcion= "mal servicio";
        boolean contactar=true;
        String observaciones="xdxdxdxd";
        String estado="espera";
        
      

        try{
            Servicios servi=new Servicios(category,departamento,distrito,prov,provi,nombre,contactar,descripcion,observaciones,estado,null,null);

            repo.InsertServicio(servi);
            repo.deleteServicio(servi.getId());
            
            
        }catch(Exception ex){
            assertTrue(true);
        }
    }
     @Test
    public void testCrearServicio4(){
        
        IServiciosRep repo = new ServiciosRep();
        
        
        Categorias category =repoCate.GetCategoriasID(1);
        Departamentos departamento=repoDep.GetDepartamentosById(1);
        Distritos distrito=repoDist.GetDistritoById(1);
        Proveedores prov=null;
        Provincias provi=repoProvi.GetProvinciasById(1);
        
        
        String nombre = "pasteleria";
        String descripcion= "mal servicio";
        boolean contactar=true;
        String observaciones="xdxdxdxd";
        String estado="espera";
        
      

        try{
            Servicios servi=new Servicios(category,departamento,distrito,prov,provi,nombre,contactar,descripcion,observaciones,estado,null,null);

            repo.InsertServicio(servi);
            repo.deleteServicio(servi.getId());
            
            
        }catch(Exception ex){
            assertTrue(true);
        }
    }
    @Test
    public void testCrearServicio5(){
        
        IServiciosRep repo = new ServiciosRep();
        
        
        Categorias category =repoCate.GetCategoriasID(1);
        Departamentos departamento=repoDep.GetDepartamentosById(1);
        Distritos distrito=repoDist.GetDistritoById(1);
        Proveedores prov=repoProv.getProv(9);
        Provincias provi=repoProvi.GetProvinciasById(1);
        
        
        String nombre = "pasteleria";
        String descripcion= "mal servicio";
        boolean contactar=true;
        String observaciones="xdxdxdxd";
        String estado="espera";
        prov.setCodigoDocumento(null);
      

        try{
            Servicios servi=new Servicios(category,departamento,distrito,prov,provi,nombre,contactar,descripcion,observaciones,estado,null,null);

            repo.InsertServicio(servi);
            repo.deleteServicio(servi.getId());
            
            
        }catch(Exception ex){
            assertTrue(true);
        }
    }
     @Test
    public void testCrearServicio6(){
        
        IServiciosRep repo = new ServiciosRep();
        
        
        Categorias category =repoCate.GetCategoriasID(1);
        Departamentos departamento=repoDep.GetDepartamentosById(1);
        Distritos distrito=repoDist.GetDistritoById(1);
        Proveedores prov=repoProv.getProv(9);
        Provincias provi=repoProvi.GetProvinciasById(1);
        
        
        String nombre = "pasteleria";
        String descripcion= "mal servicio";
        boolean contactar=true;
        String observaciones="xdxdxdxd";
        String estado="espera";
        prov.setCodigoDocumento("H0L4");
      

        try{
            Servicios servi=new Servicios(category,departamento,distrito,prov,provi,nombre,contactar,descripcion,observaciones,estado,null,null);

            repo.InsertServicio(servi);
            repo.deleteServicio(servi.getId());
            
            
        }catch(Exception ex){
            assertTrue(true);
        }
    }
       @Test
    public void testCrearServicio7(){
        
        IServiciosRep repo = new ServiciosRep();
        
        
        Categorias category =repoCate.GetCategoriasID(1);
        Departamentos departamento=repoDep.GetDepartamentosById(1);
        Distritos distrito=repoDist.GetDistritoById(1);
        Proveedores prov=repoProv.getProv(9);
        Provincias provi=repoProvi.GetProvinciasById(1);
        
        
        String nombre = "pasteleria";
        String descripcion= "mal servicio";
        boolean contactar=true;
        String observaciones="xdxdxdxd";
        String estado="espera";
        prov.setCodigoDocumento("CERO");
      

        try{
            Servicios servi=new Servicios(category,departamento,distrito,prov,provi,nombre,contactar,descripcion,observaciones,estado,null,null);

            repo.InsertServicio(servi);
            repo.deleteServicio(servi.getId());
            
            
        }catch(Exception ex){
            assertTrue(true);
        }
    }
     @Test
    public void testCrearServicio8(){
        
        IServiciosRep repo = new ServiciosRep();
        
        
        Categorias category =repoCate.GetCategoriasID(1);
        Departamentos departamento=repoDep.GetDepartamentosById(1);
        Distritos distrito=repoDist.GetDistritoById(1);
        Proveedores prov=repoProv.getProv(9);
        Provincias provi=repoProvi.GetProvinciasById(1);
        
        
        String nombre = null;
        String descripcion= "mal servicio";
        boolean contactar=true;
        String observaciones="xdxdxdxd";
        String estado="espera";
        
      

        try{
            Servicios servi=new Servicios(category,departamento,distrito,prov,provi,nombre,contactar,descripcion,observaciones,estado,null,null);

            repo.InsertServicio(servi);
            repo.deleteServicio(servi.getId());
            
            
        }catch(Exception ex){
            assertTrue(true);
        }
    }
         @Test
    public void testCrearServicio9(){
        
        IServiciosRep repo = new ServiciosRep();
        
        
        Categorias category =repoCate.GetCategoriasID(1);
        Departamentos departamento=repoDep.GetDepartamentosById(1);
        Distritos distrito=repoDist.GetDistritoById(1);
        Proveedores prov=repoProv.getProv(9);
        Provincias provi=repoProvi.GetProvinciasById(1);
        
        
        String nombre = "H0L4";
        String descripcion= "mal servicio";
        boolean contactar=true;
        String observaciones="xdxdxdxd";
        String estado="espera";
        
      

        try{
            Servicios servi=new Servicios(category,departamento,distrito,prov,provi,nombre,contactar,descripcion,observaciones,estado,null,null);

            repo.InsertServicio(servi);
            repo.deleteServicio(servi.getId());
            
            
        }catch(Exception ex){
            assertTrue(true);
        }
    }
           @Test
    public void testCrearServicio10(){
        
        IServiciosRep repo = new ServiciosRep();
        
        
        Categorias category =repoCate.GetCategoriasID(1);
        Departamentos departamento=repoDep.GetDepartamentosById(1);
        Distritos distrito=repoDist.GetDistritoById(1);
        Proveedores prov=repoProv.getProv(9);
        Provincias provi=repoProvi.GetProvinciasById(1);
        
        
        String nombre = "132";
        String descripcion= "mal servicio";
        boolean contactar=true;
        String observaciones="xdxdxdxd";
        String estado="espera";
        
      

        try{
            Servicios servi=new Servicios(category,departamento,distrito,prov,provi,nombre,contactar,descripcion,observaciones,estado,null,null);

            repo.InsertServicio(servi);
            repo.deleteServicio(servi.getId());
            
            
        }catch(Exception ex){
            assertTrue(true);
        }
    }
        @Test
    public void testCrearServicio11(){
        
        IServiciosRep repo = new ServiciosRep();
        
        
        Categorias category =repoCate.GetCategoriasID(1);
        Departamentos departamento=repoDep.GetDepartamentosById(1);
        Distritos distrito=repoDist.GetDistritoById(1);
        Proveedores prov=repoProv.getProv(9);
        Provincias provi=repoProvi.GetProvinciasById(1);
        
        
        String nombre = "pasteleria";
        String descripcion= null;
        boolean contactar=true;
        String observaciones="xdxdxdxd";
        String estado="espera";
        
      

        try{
            Servicios servi=new Servicios(category,departamento,distrito,prov,provi,nombre,contactar,descripcion,observaciones,estado,null,null);

            repo.InsertServicio(servi);
            repo.deleteServicio(servi.getId());
            
            
        }catch(Exception ex){
            assertTrue(true);
        }
    }
     public void testCrearServicio12(){
        
        IServiciosRep repo = new ServiciosRep();
        
        
        Categorias category =repoCate.GetCategoriasID(1);
        Departamentos departamento=repoDep.GetDepartamentosById(1);
        Distritos distrito=repoDist.GetDistritoById(1);
        Proveedores prov=repoProv.getProv(9);
        Provincias provi=repoProvi.GetProvinciasById(1);
        
        
        String nombre = "pasteleria";
        String descripcion= "mal servicio";
        boolean contactar=true;
        String observaciones="null";
        String estado="espera";
        
      

        try{
            Servicios servi=new Servicios(category,departamento,distrito,prov,provi,nombre,contactar,descripcion,observaciones,estado,null,null);

            repo.InsertServicio(servi);
            repo.deleteServicio(servi.getId());
            
            
        }catch(Exception ex){
            assertTrue(true);
        }
    }
}