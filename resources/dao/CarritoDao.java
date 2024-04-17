package dao;


import java.util.List;

import modelos.Carrito;
import modelos.Producto;

public interface CarritoDao {

	public boolean addCarrito(Carrito carrito);
	public List<Carrito> getProductoByUsuario(int idusuario);
	public boolean eliminarProducto(int idprod, int idusuario, int idcarrito);
	//public boolean updateDinero(Carrito car);
	//public void deshacerInsercionCarrito(int idProducto, int idUsuario);
	//public double obtenerDineroDisponibleUsuario(int idUsuario);
	  public boolean limpiarCarrito(int idUsuario);
	public boolean updateCarrito(Carrito carrito);
}
