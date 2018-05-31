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
import pe.edu.upc.entities.Categorias;


public class CategoriasRep implements ICategoriasRep {

    @Override
    public List<Categorias> GetAllCategorias() {
        Session session;
           session = NewHibernateUtil.getSessionFactory().openSession();
        
        Query query = session.createQuery("From Categorias as c");
        List<Categorias> list = query.list();
          session.close();
        return list;
    }

    @Override
    public Categorias GetCategoriasID(int cat) {
        
         Session session = NewHibernateUtil.getSessionFactory().openSession();
       Categorias categoria;
         try {
            categoria = (Categorias) session.get(Categorias.class, cat);
        } finally {
            session.close();
        }
        return categoria;
    }
    
}
