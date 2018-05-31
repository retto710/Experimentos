/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.DataAccess;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.edu.upc.entities.Pedidos;
import pe.edu.upc.entities.Servicios;


public class PedidosRep implements IPedidosRep {

    @Override
    public void InsertPedido(Pedidos pedido) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(pedido);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Pedidos> getPedidosByUserId(int id) {
          Session session = NewHibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Pedidos p join fetch p.servicios"
                + " join fetch p.usuarios where p.usuarios.id =" + id);
        List<Pedidos> servicios = query.list();
        session.close();
        return servicios;
    }

    @Override
    public void DeletePedido(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Pedidos aux=new Pedidos();
        aux.setId(id);
        session.delete(aux);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Pedidos GetPedidoByID(int id) {
         Session session = NewHibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Pedidos where id="+ id);
       Pedidos servicios = (Pedidos)query.uniqueResult();
        session.close();
        return servicios;
    }
    
}
