/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.DataAccess;

import org.hibernate.Session;
import pe.edu.upc.entities.Departamentos;


public class DepartamentosRep implements IDepartamentosRep {

    @Override
    public Departamentos GetDepartamentosById(int departamentoId) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
       Departamentos distritos;
         try {
            distritos = (Departamentos) session.get(Departamentos.class, departamentoId);
        } finally {
            session.close();
        }
        return distritos;
        
        
    }
    
}
