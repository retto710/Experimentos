/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.DataAccess;

import java.io.IOException;
import pe.edu.upc.entities.Usuarios;

/**
 *
 * @author Diego
 */
public interface IUsuariosRep {
    void InsertUsuario (Usuarios usuario)  throws IOException;
    Usuarios GetUsuarioById(int usuarioId);
    boolean UsuarioExists(String correo);
    Usuarios GetUsuario(String correo);
    Usuarios GetPassword(String password);

   void deleteUsuario(String correo);
    String UpdateUSer(Usuarios objUser);
    
    boolean usuarioLogin(String correo, String password);
}
