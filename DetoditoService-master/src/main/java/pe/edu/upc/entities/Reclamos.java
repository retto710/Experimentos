package pe.edu.upc.entities;
// Generated 01-jul-2017 17:48:51 by Hibernate Tools 4.3.1



/**
 * Reclamos generated by hbm2java
 */
public class Reclamos  implements java.io.Serializable {


     private int id;
     private Pedidos pedidos;
     private Servicios servicios;
     private String fecha;
     private String observaciones;

    public Reclamos() {
    }

	
    public Reclamos(int id, Pedidos pedidos, Servicios servicios, String fecha) {
        this.id = id;
        this.pedidos = pedidos;
        this.servicios = servicios;
        this.fecha = fecha;
    }
    public Reclamos(int id, Pedidos pedidos, Servicios servicios, String fecha, String observaciones) {
       this.id = id;
       this.pedidos = pedidos;
       this.servicios = servicios;
       this.fecha = fecha;
       this.observaciones = observaciones;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Pedidos getPedidos() {
        return this.pedidos;
    }
    
    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }
    public Servicios getServicios() {
        return this.servicios;
    }
    
    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }
    public String getFecha() {
        return this.fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }




}

