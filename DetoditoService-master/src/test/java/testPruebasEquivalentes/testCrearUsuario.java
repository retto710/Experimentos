/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testPruebasEquivalentes;


import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import pe.edu.upc.DataAccess.IServiciosRep;
import pe.edu.upc.DataAccess.IUsuariosRep;
import pe.edu.upc.DataAccess.ServiciosRep;
import pe.edu.upc.DataAccess.UsuariosRep;
import pe.edu.upc.entities.Servicios;
import pe.edu.upc.entities.Usuarios;
/**
 *
 * @author Renato
 */
public class testCrearUsuario {
    
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

        String nombre = "pepe";
        String correoElectronico = "159";
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
        String correoElectronico = "H0la";
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
    public void testCrearUsuario5(){

        IUsuariosRep usuarioRep = new UsuariosRep();

        String nombre = "pepe";
        String correoElectronico = "CERO";
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
    public void testCrearUsuario6(){

        IUsuariosRep usuarioRep = new UsuariosRep();

        String nombre = "pepe";
        String correoElectronico = "CERO@";
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
    public void testCrearUsuario7(){

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
    public void testCrearUsuario8(){

        IUsuariosRep usuarioRep = new UsuariosRep();

        String nombre = "pepe";
        String correoElectronico = "pepe@hotmail.com";
        String password = "12345";        
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
    public void testCrearUsuario9(){

        IUsuariosRep usuarioRep = new UsuariosRep();

        String nombre = "pepe";
        String correoElectronico = "pepe@hotmail.com";
        String password = "";        
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
    public void testCrearUsuario10(){

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
    public void testCrearUsuario11(){

        IUsuariosRep usuarioRep = new UsuariosRep();

        String nombre = "pepe";
        String correoElectronico = "pepe@hotmail.com";
        String password = "123456";        
        String telefono = "1234567891011";
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
    public void testCrearUsuario12(){

        IUsuariosRep usuarioRep = new UsuariosRep();

        String nombre = "pepe";
        String correoElectronico = "pepe@hotmail.com";
        String password = "123456";        
        String telefono = "";
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
    public void testCrearUsuario13(){

        IUsuariosRep usuarioRep = new UsuariosRep();

        String nombre = "pepe";
        String correoElectronico = "pepe@hotmail.com";
        String password = "123456";        
        String telefono = "CERO";
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
    public void testCrearUsuario14(){

        IUsuariosRep usuarioRep = new UsuariosRep();

        String nombre = "pepe";
        String correoElectronico = "pepe@hotmail.com";
        String password = "123456";        
        String telefono = "123ad";
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
    public void testCrearUsuario15(){

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
    
    @Test
    public void testCrearUsuario16(){

        IUsuariosRep usuarioRep = new UsuariosRep();

        String nombre = "159";
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
    public void testCrearUsuario17(){

        IUsuariosRep usuarioRep = new UsuariosRep();

        String nombre = "H0LA";
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
    public void testCrearUsuario18(){

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
    
}
