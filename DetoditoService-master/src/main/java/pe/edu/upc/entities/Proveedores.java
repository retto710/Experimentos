package pe.edu.upc.entities;
// Generated 01-jul-2017 17:48:51 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Proveedores generated by hbm2java
 */
public class Proveedores  implements java.io.Serializable {


     private Integer id;
     private TipoDocumento tipoDocumento;
     private String codigoDocumento;
     private int usuarioId;
     private Set servicioses = new HashSet(0);

    public Proveedores() {
    }

	
    public Proveedores(TipoDocumento tipoDocumento, String codigoDocumento, int usuarioId) {
        this.tipoDocumento = tipoDocumento;
        this.codigoDocumento = codigoDocumento;
        this.usuarioId = usuarioId;
    }
    public Proveedores(TipoDocumento tipoDocumento, String codigoDocumento, int usuarioId, Set servicioses) {
       this.tipoDocumento = tipoDocumento;
       this.codigoDocumento = codigoDocumento;
       this.usuarioId = usuarioId;
       this.servicioses = servicioses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }
    
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public String getCodigoDocumento() {
        return this.codigoDocumento;
    }
    
    public void setCodigoDocumento(String codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
    }
    public int getUsuarioId() {
        return this.usuarioId;
    }
    
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    public Set getServicioses() {
        return this.servicioses;
    }
    
    public void setServicioses(Set servicioses) {
        this.servicioses = servicioses;
    }




}


