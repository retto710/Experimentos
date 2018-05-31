package pe.edu.upc.entities;
// Generated 01-jul-2017 17:48:51 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * TipoDocumento generated by hbm2java
 */
public class TipoDocumento  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String descripcion;
     private Set proveedoreses = new HashSet(0);

    public TipoDocumento() {
    }

	
    public TipoDocumento(String nombre) {
        this.nombre = nombre;
    }
    public TipoDocumento(String nombre, String descripcion, Set proveedoreses) {
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.proveedoreses = proveedoreses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getProveedoreses() {
        return this.proveedoreses;
    }
    
    public void setProveedoreses(Set proveedoreses) {
        this.proveedoreses = proveedoreses;
    }




}


