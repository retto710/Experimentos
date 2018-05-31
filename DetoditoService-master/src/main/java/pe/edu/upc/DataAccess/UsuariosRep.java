/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.DataAccess;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pe.edu.upc.entities.Usuarios;

public class UsuariosRep implements IUsuariosRep {

    @Override
    public void InsertUsuario(Usuarios usuario) throws IOException{
        
        //validaiocn creacion de usuario
        
        //validaicone nombre
        boolean validNombre1 = usuario.getNombre().matches("[a-zA-Z]+");
        //validaicone e-mail
        boolean validCorreo1 = usuario.getCorreoElectronico().matches(".+@.+");      
        //validate password
        boolean valiPassword1 = (usuario.getPassword().length()>=6)? true: false;
        //validate telefono
        boolean validTelefono1 = (   usuario.getTelefono().matches("^[0-9]{9}$"))? true: false;    
        //validate direccion
        boolean validDireccion1 = (usuario.getDireccion().isEmpty())? false: true;      
        
        if(
                validNombre1  && validCorreo1 && valiPassword1
                 && validTelefono1 && validDireccion1
                ){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(usuario);
        session.getTransaction().commit();
        session.close();
        }else{
            throw new IOException();
        }
        
    }

    @Override
    public Usuarios GetUsuarioById(int usuarioId) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Usuarios usuario = (Usuarios) session.get(Usuarios.class, usuarioId);
              session.close();
            return usuario;
        } catch (Exception e) {
              session.close();
            return null;
        }

    }

    @Override
    public boolean UsuarioExists(String correo) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuarios.class);
        criteria.add(Restrictions.eq("correoElectronico", correo));
        Usuarios usuarios = (Usuarios) criteria.uniqueResult();
          session.close();
        return usuarios != null;
    }

    @Override
    public Usuarios GetUsuario(String correo) {
     
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuarios.class);
        criteria.add(Restrictions.eq("correoElectronico", correo));
        Usuarios usuario = (Usuarios) criteria.uniqueResult();
        session.close();
        return usuario;
    }

    @Override
    public String UpdateUSer(Usuarios objUser) {
       String errorMessage=""; 
    try
        {
            
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(objUser);
        session.getTransaction().commit();
        session.close();
        }
    catch (Exception e)
        {
          System.err.println("Got an exception!");
          System.err.println(e.getMessage());
          errorMessage=e.getMessage();
          
        }
    return errorMessage;
    }

    @Override
    public Usuarios GetPassword(String password) {
        
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuarios.class);
        criteria.add(Restrictions.eq("password", password));
        Usuarios usuario = (Usuarios) criteria.uniqueResult();
          session.close();
        return usuario;
    }

    @Override
    public void deleteUsuario(String correo) {
        Session objSession = NewHibernateUtil.getSessionFactory().openSession();
 
        Usuarios obj = GetUsuario(correo);
        
        objSession.beginTransaction();
        objSession.delete(obj);
        objSession.getTransaction().commit();
        
        objSession.close();
        
    }
    
    

    @Override
    public boolean usuarioLogin(String correo, String password) {
        
        if(UsuarioExists(correo)){
            Usuarios us = GetUsuario(correo);
            
            if(us.getPassword().equals(password)){
            return true;
            }else{
                return false;    
            }
            
        }else{
            return false;
        }
    }

}
