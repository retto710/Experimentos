/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.DataAccess;

import org.hibernate.Session;
import pe.edu.upc.entities.Reclamos;

public class ReclamosRep implements IReclamosRep {

    @Override
    public void InsertReclamo(Reclamos reclamo) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(reclamo);
        session.getTransaction().commit();
        session.close();
    }

}
