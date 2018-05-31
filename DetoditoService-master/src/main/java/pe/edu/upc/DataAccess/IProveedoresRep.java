/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.DataAccess;

import pe.edu.upc.entities.Proveedores;

/**
 *
 * @author Diego
 */
public interface IProveedoresRep {

    void InsertProveedor(Proveedores proveedor);
    Proveedores getProv(int id) ;
}
