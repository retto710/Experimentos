/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.DataAccess;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.edu.upc.entities.Distritos;
import pe.edu.upc.entities.TipoDocumento;


public class DistritosRep implements IDistritosRep {

    @Override
    public List<Distritos> GetAllDistritos() {
       
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
                Query query = session.createQuery("From Distritos as c");
        List<Distritos> list = query.list();
          session.close();
        return list;
    }

    @Override
    public Distritos GetDistritoById(int distritoId) {
               Session session = NewHibernateUtil.getSessionFactory().openSession();
       Distritos distritos;
         try {
            distritos = (Distritos) session.get(Distritos.class, distritoId);
        } finally {
           session.close();
        }
        return distritos;
    }
    
}
