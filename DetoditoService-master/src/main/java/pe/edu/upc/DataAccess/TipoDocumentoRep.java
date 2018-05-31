/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.DataAccess;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.edu.upc.entities.TipoDocumento;


public class TipoDocumentoRep implements ITipoDocumentoRep {

    @Override
    public List<TipoDocumento> GetAllDocumentos() {
        
         Session session = NewHibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From TipoDocumento as tp" );
        List<TipoDocumento> tipoDocumento = query.list();
          session.close();
        return tipoDocumento;
        
    }

    @Override
    public TipoDocumento GetTipoDocumento(int IdDocumento) {
       Session session = NewHibernateUtil.getSessionFactory().openSession();
       TipoDocumento tipoDocumento;
         try {
            tipoDocumento = (TipoDocumento) session.get(TipoDocumento.class, IdDocumento);
              session.close();
        } finally {
            //session.close();
        }
        return tipoDocumento;
    }
    
    
}
