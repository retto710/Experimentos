/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.DataAccess;

import java.io.IOException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pe.edu.upc.entities.Usuarios;

/**
 *
 * @author Andre Puente
 */
public class ChangePassword implements IChangePassword{

    @Override
    public Usuarios GetUsuario(String correo , String password){ 
        Usuarios usuario = new Usuarios();
        
        if(correo != null && !"".equals(correo)){
           
            
           Session session = NewHibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Usuarios.class);
            criteria.add(Restrictions.eq("correoElectronico", correo));
            usuario = (Usuarios) criteria.uniqueResult();
            session.close();
           if(!usuario.getPassword().equals(password) &&
                    password.length()>= 6)
            {
               return usuario;
            }else{
                String message = "La contraseña debe diferente a la actual y debe de tener mas de 6 caracteres.";
                System.out.println(message);
            }
            
        }else{
            String message = "Correo incorrecto.";
            System.out.println(message);
        }
        usuario = null;
        return usuario;
    }

//    @Override
//    public Usuarios GetPassword(String password) {
//        Session session = NewHibernateUtil.getSessionFactory().openSession();
//        Criteria criteria = session.createCriteria(Usuarios.class);
//        criteria.add(Restrictions.eq("password", password));
//        Usuarios usuario = (Usuarios) criteria.uniqueResult();
//          session.close();
//        return usuario;
//    }
    
}
