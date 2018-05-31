/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.DataAccess;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import pe.edu.upc.entities.Servicios;

public class ServiciosRep implements IServiciosRep {

    @Override
    public void InsertServicio(Servicios servicio) {

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(servicio);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Servicios> GetAllServicios() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Servicios as sr "
                + "join fetch sr.categorias join fetch sr.distritos ");
        List<Servicios> servicios = query.list();
        session.close();
        return servicios;
    }

    @Override
    public List<Servicios> GetAllServicios(String busqueda, int categoriaId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session session = NewHibernateUtil.getSessionFactory().openSession();

        Criteria criteria = session.createCriteria(Servicios.class);
        if (categoriaId != 0) {
            criteria.add(Restrictions.eq("categorias.id", categoriaId));
        }

        criteria.add(Restrictions.like("nombre", busqueda, MatchMode.ANYWHERE).ignoreCase()).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        //criteria.add(Restrictions.like("nombre", busqueda));
        List<Servicios> servicios = criteria.list();
        session.close();
        return servicios;
    }

    @Override
    public Servicios GetServicioById(int servicioId) {
        Session session;

        session = NewHibernateUtil.getSessionFactory().openSession();

        Servicios servicio = (Servicios) session.get(Servicios.class, servicioId);
        session.close();
        return servicio;
    }

    @Override
    public void UpdateServicio(Servicios servicio) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(servicio);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Servicios> GetServiciosByProveedorId(int id) {
       Session session = NewHibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Servicios as sr "
                + "join fetch sr.categorias join fetch sr.distritos "
                + "join fetch sr.proveedores join fetch sr.provincias "
                + " where sr.proveedores.usuarioId = "+id);
        List<Servicios> servicios = query.list();
        session.close();
        return servicios;
    }
   @Override
    public void deleteServicio(int id) {
       Session objSession = NewHibernateUtil.getSessionFactory().openSession();
 
        Servicios obj = this.GetServicioById(id);
        
        objSession.beginTransaction();
        objSession.delete(obj);
        objSession.getTransaction().commit();
        
        objSession.close();
    }
   

	@Override
	public void deleteServicioByNombre(String nombre) {
		   Session objSession = NewHibernateUtil.getSessionFactory().openSession();
		   
		   Servicios obj = getServicioByNombre(nombre);
	       
	       objSession.beginTransaction();
	       objSession.delete(obj);
	       objSession.getTransaction().commit();
	       
	       objSession.close();
		
	}
	
	@Override
	public Servicios getServicioByNombre(String nombre) {
		   Session session = NewHibernateUtil.getSessionFactory().openSession();
	       Criteria criteria = session.createCriteria(Servicios.class);
	       criteria.add(Restrictions.eq("nombre", nombre));
	       Servicios servicio = (Servicios) criteria.uniqueResult();
	       session.close();
	       return servicio;
	}

}
