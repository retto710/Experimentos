/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.DataAccess;

import pe.edu.upc.entities.Usuarios;

/**
 *
 * @author Andre Puente
 */
public interface IChangePassword {
    Usuarios GetUsuario(String correo, String password );
}
