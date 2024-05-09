package dao;

import java.util.List;

import modelos.Producto;

public interface ProductoDao {

	public boolean addProductos(Producto prod);
	public boolean updateProducto(Producto prod);
	public boolean deleteProducto(int idprod);
	
	
	public List<Producto> getAllProductos();
	public Producto getProductoById(int idprod);

	
	public List<Producto> getByZapatillas();
	public List<Producto> getByRemeras();
	public List<Producto> getByPantalones();


	public List<Producto> getAllPantalones();
	public List<Producto> getAllRemeras();
	public List<Producto> getAllZapatillas();
	
	public List<Producto> busquedaProducto(String search);
	
	
}
