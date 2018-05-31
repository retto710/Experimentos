/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestComplejidad;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pe.edu.upc.DataAccess.ChangePassword;
import pe.edu.upc.DataAccess.IChangePassword;
import pe.edu.upc.entities.Usuarios;

/**
 *
 * @author Andre Puente
 */
public class TestChangePassword {
    
    @Test
    public void testChangePassword1(){
        
        IChangePassword passRep = new ChangePassword();
        String correo = null;
        String password = "123457";
        try{ 
        
            Usuarios user = new Usuarios();
            user = passRep.GetUsuario(correo, password);
            if(correo == null)
                  assertTrue(true);
        }catch (Exception ex) {
          fail();
        }
    }
    @Test
    public void testChangePassword2(){
        
        IChangePassword passRep = new ChangePassword();
        String correo = "";
        String password = "123457";
        try{ 
            Usuarios user = new Usuarios();
            user = passRep.GetUsuario(correo, password);
            if(correo.equals(""))
               assertTrue(true); 
        }catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    }
    @Test
    public void testChangePassword3(){
        
        IChangePassword passRep = new ChangePassword();
        String correo = "diego@gmail.com";
        String password = "123456";
        try{ 
        
            Usuarios user = new Usuarios();
            user = passRep.GetUsuario(correo, password);
            if(user == null || user.getPassword().equals(password))
              assertTrue(true);  
        }catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    }

    
    @Test
    public void testChangePassword4(){
        
        IChangePassword passRep = new ChangePassword();
        String correo = "diego@gmail.com";
        String password = "123ad";
        try{ 
        
            Usuarios user = new Usuarios();
            user = passRep.GetUsuario(correo, password);
            if(password.length() < 6)
                   assertTrue(true);
        }catch (Exception ex) {
             ex.printStackTrace();
            fail();
        }
    }
    
    @Test
    public void testChangePassword5(){
        
        IChangePassword passRep = new ChangePassword();
        String correo = "diego@gmail.com";
        String password = "123457";
        try{ 
        
            Usuarios user = new Usuarios();
           user = passRep.GetUsuario(correo, password);
           if(!user.getPassword().equals(password))
                assertTrue(true);

        }catch (Exception ex) {
            ex.printStackTrace();
            fail();

        }
    }

}
