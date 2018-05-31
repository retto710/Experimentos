/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.DataAccess;

import org.hibernate.Session;
import pe.edu.upc.entities.Provincias;


public class ProvinciasRep implements IProvinciasRep {

    @Override
    public Provincias GetProvinciasById(int provinciaId) {
                  Session session = NewHibernateUtil.getSessionFactory().openSession();
       Provincias provincias;
         try {
            provincias = (Provincias) session.get(Provincias.class, provinciaId);
        } finally {
           session.close();
        }
        return provincias;
    }
    
}
    