/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testPruebasEquivalentes;

import org.junit.Test;
import static org.junit.Assert.*;
import pe.edu.upc.DataAccess.IUsuariosRep;
import pe.edu.upc.DataAccess.UsuariosRep;
import pe.edu.upc.entities.Usuarios;
/**
 *
 * @author Renato
 */
public class testIngresar {
    
    @Test
    public void testIngresar1(){
        IUsuariosRep usuarioRep = new UsuariosRep(); 
        assertTrue(usuarioRep.usuarioLogin("diego@gmail.com","123456"));
    }
    
    
    @Test
    public void testIngresar2(){
        IUsuariosRep usuarioRep = new UsuariosRep(); 
        assertTrue(!usuarioRep.usuarioLogin("diego@gmail.com","123ad"));
    }
    
    
    @Test
    public void testIngresar3(){
        IUsuariosRep usuarioRep = new UsuariosRep(); 
        assertTrue(!usuarioRep.usuarioLogin("diego@gmail.com","12345"));
    }
    
    
    @Test
    public void testIngresar4(){
        IUsuariosRep usuarioRep = new UsuariosRep(); 
        assertTrue(!usuarioRep.usuarioLogin("diego@gmail.com",""));
    }
    
    @Test
    public void testIngresar5(){
        IUsuariosRep usuarioRep = new UsuariosRep(); 
        assertTrue(!usuarioRep.usuarioLogin("159","123456"));
    }
    
    @Test
    public void testIngresar6(){
        IUsuariosRep usuarioRep = new UsuariosRep(); 
        assertTrue(!usuarioRep.usuarioLogin("H0L4","123456"));
    }
    
    @Test
    public void testIngresar7(){
        IUsuariosRep usuarioRep = new UsuariosRep(); 
        assertTrue(!usuarioRep.usuarioLogin("","123456"));
    }
    
    @Test
    public void testIngresar8(){
        IUsuariosRep usuarioRep = new UsuariosRep(); 
        assertTrue(!usuarioRep.usuarioLogin("CERO","123456"));
    }
    
    @Test
    public void testIngresar9(){
        IUsuariosRep usuarioRep = new UsuariosRep(); 
        assertTrue(!usuarioRep.usuarioLogin("CERO@","123456"));
    }
}
