/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.DataAccess;

import java.util.List;
import pe.edu.upc.entities.TipoDocumento;

/**
 *
 * @author Andre Puente
 */
public interface ITipoDocumentoRep {
    TipoDocumento GetTipoDocumento(int IdDocumento);
    List<TipoDocumento> GetAllDocumentos();
    
}
