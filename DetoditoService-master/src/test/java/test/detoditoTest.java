/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pe.edu.upc.entities.Usuarios;

/**
 *
 * @author Diego
 */
public class detoditoTest {

    Usuarios usuario;

    public detoditoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        usuario = new Usuarios();
        usuario.setNombre("Diego");
        usuario.setPassword("contrasena");
        usuario.setTelefono("2226644");
        usuario.setDireccion("Lima - Chorrillos");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testNombreUsuario() {
        assertEquals("Diego", usuario.getNombre());
    }

    @Test
    public void testPasswordUsuario() {
        assertEquals("contrasena", usuario.getPassword());
    }

    @Test
    public void testTelefonoUsuario() {
        assertEquals("2226644", usuario.getTelefono());
    }

    @Test
    public void testDireccionUsuario() {
        assertEquals("Lima - Chorrillos", usuario.getDireccion());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
