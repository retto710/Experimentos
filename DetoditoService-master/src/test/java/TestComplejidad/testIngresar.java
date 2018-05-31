/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestComplejidad;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import pe.edu.upc.DataAccess.IUsuariosRep;
import pe.edu.upc.DataAccess.UsuariosRep;

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
        assertTrue(!usuarioRep.usuarioLogin("H0L4","123456"));
    }
    
    
}
