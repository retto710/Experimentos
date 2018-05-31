/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.DataAccess;

import java.util.List;
import pe.edu.upc.entities.Pedidos;

/**
 *
 * @author Diego
 */
public interface IPedidosRep {

    void InsertPedido(Pedidos pedido);
    List <Pedidos> getPedidosByUserId(int id);
    void DeletePedido(int id);
    Pedidos GetPedidoByID(int id);
}
