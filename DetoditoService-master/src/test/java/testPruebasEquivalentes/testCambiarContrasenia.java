/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testPruebasEquivalentes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import pe.edu.upc.DataAccess.ChangePassword;
import pe.edu.upc.DataAccess.IChangePassword;

import pe.edu.upc.entities.Usuarios;

/**
 *
 * @author Renato
 */
public class testCambiarContrasenia {
    @Test
    public void testCambiarPassword1(){
        Usuarios us = new Usuarios();     
        IChangePassword passRep = new ChangePassword();
        String newpass= "123457";
        us = passRep.GetUsuario("diego@gmail.com" ,newpass );
        assertTrue(("123456").equals(us.getPassword()) && 
                !newpass.equals(us.getPassword())
                && !newpass.isEmpty()
                && newpass.length() >= 6);
    }
    
      @Test
    public void testCambiarPassword2(){
        Usuarios us = new Usuarios();
         IChangePassword passRep = new ChangePassword();  
         try{
             String newpass= "123ad";
             us = passRep.GetUsuario("diego@gmail.com",newpass);
             assertFalse(("123456").equals(us.getPassword()) && 
                        !newpass.equals(us.getPassword()) && !newpass.isEmpty()
                        && newpass.length() >= 6);
        }catch(Exception ex){
            assertTrue(true);
        }
    }
    
    
    @Test
    public void testCambiarPassword3(){
        Usuarios us = new Usuarios();
       

        IChangePassword passRep = new ChangePassword();
                String newpass = null;        

         try{
        us = passRep.GetUsuario("diego@gmail.com",newpass);        
        assertFalse(("123456").equals(us.getPassword()) && 
                !newpass.equals(us.getPassword()) 
                && !newpass.isEmpty()
                && newpass.length() >= 6);
        }catch(Exception ex){
            assertTrue(true);
        }
    }
    @Test
    public void testCambiarPassword4(){
        Usuarios us = new Usuarios();
        IChangePassword passRep = new ChangePassword();
          try{
                String newpass= "123456"; 
                 us = passRep.GetUsuario("diego@gmail.com",newpass); 
         
                assertFalse(("123456").equals(us.getPassword()) && 
                              !newpass.equals(us.getPassword())
                                && !newpass.isEmpty()
                                && newpass.length() >= 6);
        }catch(Exception ex){
           assertTrue(true);
        }
    }
     @Test
    public void testCambiarPassword5(){
        Usuarios us = new Usuarios();
        IChangePassword passRep = new ChangePassword();  
         try{
             String newpass= "123457";

             us = passRep.GetUsuario("159",newpass);
             assertFalse(("123456").equals(us.getPassword()) && 
                           !newpass.equals(us.getPassword()) && !newpass.isEmpty()
                            && newpass.length() >= 6);
            }catch(Exception ex){
                assertTrue(true);
        }
    }
     
       @Test
    public void testCambiarPassword6(){
        Usuarios us = new Usuarios();
   

         IChangePassword passRep = new ChangePassword();  

         try{
                String newpass= "123457";
                us = passRep.GetUsuario("H0L4",newpass);
                assertFalse(("123456").equals(us.getPassword()) && 
                            !newpass.equals(us.getPassword()) && !newpass.isEmpty()
                            && newpass.length() >= 6);
        }catch(Exception ex){
            assertTrue(true);
        }
    }
    
    
       @Test
    public void testCambiarPassword7(){
        Usuarios us = new Usuarios();
   

         IChangePassword passRep = new ChangePassword();  

         try{
                String newpass= "123457";
                us = passRep.GetUsuario("",newpass);
                assertFalse(("123456").equals(us.getPassword()) && 
                            !newpass.equals(us.getPassword()) && !newpass.isEmpty()
                            && newpass.length() >= 6);
        }catch(Exception ex){
            assertTrue(true);
        }
    }
    
       @Test
    public void testCambiarPassword8(){
        Usuarios us = new Usuarios();
        IChangePassword passRep = new ChangePassword();  
         try{
             String newpass= "123457";
             us = passRep.GetUsuario("CERO",newpass);
             assertFalse(("123456").equals(us.getPassword()) && 
                           !newpass.equals(us.getPassword()) && !newpass.isEmpty()
                            && newpass.length() >= 6);
        }catch(Exception ex){
            assertTrue(true);
        }
    }    

       @Test
    public void testCambiarPassword9(){
        Usuarios us = new Usuarios();
        IChangePassword passRep = new ChangePassword();  
         try{
             String newpass= "123457";
             us = passRep.GetUsuario("CERO@",newpass);
             assertFalse(("123456").equals(us.getPassword()) && 
                           !newpass.equals(us.getPassword()) && !newpass.isEmpty()
                            && newpass.length() >= 6);
        }catch(Exception ex){
            assertTrue(true);
        }
    }    
    
}

