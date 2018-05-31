/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestComplejidad;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import pe.edu.upc.DataAccess.IUsuariosRep;
import pe.edu.upc.DataAccess.UsuariosRep;
import pe.edu.upc.entities.Usuarios;

/**
 *
 * @author Renato
 */
public class TestCrearUsuario {
    
    @Test
    public void testCrearUsuario1(){

        IUsuariosRep usuarioRep = new UsuariosRep();

        String nombre = "pepe";
        String telefono = "123456789";
        String direccion = "mi casa 123";
        String correoElectronico = "pepe@hotmail.com";
        String password = "12345678";

        try{
            Usuarios usuario = new Usuarios();
            usuario.setNombre(nombre);
            usuario.setDireccion(direccion);
            usuario.setTelefono(telefono);
            usuario.setCorreoElectronico(correoElectronico);
            usuario.setPassword(password);

            usuarioRep.InsertUsuario(usuario);
            usuarioRep.deleteUsuario(correoElectronico);
            assertTrue(true);
            
        }catch(Exception ex){
            ex.printStackTrace();
            fail();
        }
    }
    
    @Test
    public void testCrearUsuario2(){

        IUsuariosRep usuarioRep = new UsuariosRep();

        String nombre = "";
        String correoElectronico = "pepe@hotmail.com";
        String password = "123456";        
        String telefono = "123456789";
        String direccion = "mi casa 123";

        try{
            Usuarios usuario = new Usuarios();
            usuario.setNombre(nombre);
            usuario.setDireccion(direccion);
            usuario.setTelefono(telefono);
            usuario.setCorreoElectronico(correoElectronico);
            usuario.setPassword(password);

            usuarioRep.InsertUsuario(usuario);
            fail();
            usuarioRep.deleteUsuario(correoElectronico);
            
        }catch(Exception ex){
            assertTrue(true);
        }
    }
    
    @Test
    public void testCrearUsuario3(){

        IUsuariosRep usuarioRep = new UsuariosRep();

        String nombre = "pepe";
        String correoElectronico = "";
        String password = "123456";        
        String telefono = "123456789";
        String direccion = "mi casa 123";

        try{
            Usuarios usuario = new Usuarios();
            usuario.setNombre(nombre);
            usuario.setDireccion(direccion);
            usuario.setTelefono(telefono);
            usuario.setCorreoElectronico(correoElectronico);
            usuario.setPassword(password);

            usuarioRep.InsertUsuario(usuario);
            fail();
            usuarioRep.deleteUsuario(correoElectronico);
             
        }catch(Exception ex){
            assertTrue(true);
        }
    }
    
    @Test
    public void testCrearUsuario4(){

        IUsuariosRep usuarioRep = new UsuariosRep();

        String nombre = "pepe";
        String correoElectronico = "pepe@hotmail.com";
        String password = "123ad";        
        String telefono = "123456789";
        String direccion = "mi casa 123";

        try{
            Usuarios usuario = new Usuarios();
            usuario.setNombre(nombre);
            usuario.setDireccion(direccion);
            usuario.setTelefono(telefono);
            usuario.setCorreoElectronico(correoElectronico);
            usuario.setPassword(password);

            usuarioRep.InsertUsuario(usuario);
            fail();
            usuarioRep.deleteUsuario(correoElectronico);
            
        }catch(Exception ex){
            assertTrue(true);
        }
    }
    
    @Test
    public void testCrearUsuario5(){

        IUsuariosRep usuarioRep = new UsuariosRep();

        String nombre = "pepe";
        String correoElectronico = "pepe@hotmail.com";
        String password = "123456";        
        String telefono = "1234567";
        String direccion = "mi casa 123";

        try{
            Usuarios usuario = new Usuarios();
            usuario.setNombre(nombre);
            usuario.setDireccion(direccion);
            usuario.setTelefono(telefono);
            usuario.setCorreoElectronico(correoElectronico);
            usuario.setPassword(password);

            usuarioRep.InsertUsuario(usuario);
            fail();
            usuarioRep.deleteUsuario(correoElectronico);
            
        }catch(Exception ex){
            assertTrue(true);
        }
    }
    
    @Test
    public void testCrearUsuario6(){

        IUsuariosRep usuarioRep = new UsuariosRep();

        String nombre = "pepe";
        String correoElectronico = "pepe@hotmail.com";
        String password = "123456";        
        String telefono = "123456789";
        String direccion = "";

        try{
            Usuarios usuario = new Usuarios();
            usuario.setNombre(nombre);
            usuario.setDireccion(direccion);
            usuario.setTelefono(telefono);
            usuario.setCorreoElectronico(correoElectronico);
            usuario.setPassword(password);

            usuarioRep.InsertUsuario(usuario);
            fail();
            usuarioRep.deleteUsuario(correoElectronico);
            
        }catch(Exception ex){
            assertTrue(true);
        }
    }
    
}
