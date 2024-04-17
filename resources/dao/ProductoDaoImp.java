package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelos.Producto;

public class ProductoDaoImp implements ProductoDao{

	private Connection con;
	
	public ProductoDaoImp(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public boolean addProductos(Producto prod) {
		boolean f= false;
		try {
			
			String sql="insert into productos (nombre, categoria,stock,precio,imagen,email) values(?,?,?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, prod.getNombre());
			ps.setString(2, prod.getCategoria());
			ps.setString(3, prod.getStock());
			ps.setString(4, prod.getPrecio());
			ps.setString(5, prod.getImagen());
			ps.setString(6, prod.getEmail());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	@Override
	public boolean updateProducto(Producto prod) {
		boolean f= false;
		
		try {
			String sql="update productos set nombre=?, categoria=?, stock=?, precio=? where idprod=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, prod.getNombre());
			ps.setString(2, prod.getCategoria());
			ps.setString(3, prod.getStock());
			ps.setString(4, prod.getPrecio());
			//ps.setString(5, prod.getImagen());
			ps.setInt(5, prod.getIdprod());
			
			int i =ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	@Override
	public List<Producto> getAllProductos() {
			
		List<Producto> list= new ArrayList<Producto>();
		Producto prod= null;
		try {
			String sql="select * from productos";
			PreparedStatement ps= con.prepareStatement(sql);
			
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				
				prod= new Producto();
				prod.setIdprod(rs.getInt(1));
				prod.setNombre(rs.getString(2));
				prod.setCategoria(rs.getString(3));
				prod.setStock(rs.getString(4));
				prod.setPrecio(rs.getString(5));
				prod.setImagen(rs.getString(6));
				prod.setEmail(rs.getString(7));
				list.add(prod);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Producto getProductoById(int idprod) {
		Producto prod= null;
		try {
			String sql= "select * from productos where idprod=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, idprod);
			
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				prod = new Producto();
				prod.setIdprod(rs.getInt(1));
				prod.setNombre(rs.getString(2));
				prod.setCategoria(rs.getString(3));
				prod.setStock(rs.getString(4));
				prod.setPrecio(rs.getString(5));
				prod.setImagen(rs.getString(6));
				prod.setEmail(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prod;
	}

	

	@Override
	public boolean deleteProducto(int idprod) {
		boolean f= false;
		try {
		String sql="delete from productos where idprod=?";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setInt(1, idprod);
		
		int i= ps.executeUpdate();
		if(i==1) {
			f=true;
		}
		
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return f;
	}




	

	@Override
	public List<Producto> getByZapatillas() {
		List<Producto> list= new ArrayList<Producto>();
		
		Producto prod= null;
		try {
			String sql="select * from productos where categoria=? order by idprod desc";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, "Zapatilla");
		
			ResultSet rs = ps.executeQuery();
			int i =1;
			while(rs.next() && i<4) {
				prod= new Producto();
				prod.setIdprod(rs.getInt(1));
				prod.setNombre(rs.getString(2));
				prod.setCategoria(rs.getString(3));
				prod.setStock(rs.getString(4));
				prod.setPrecio(rs.getString(5));
				prod.setImagen(rs.getString(6));
				prod.setEmail(rs.getString(7));
				list.add(prod);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Producto> getByRemeras() {
		List<Producto> list= new ArrayList<Producto>();
		
		Producto prod= null;
		try {
			String sql="select * from productos where categoria=? order by idprod desc";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, "Remeras");
		
			ResultSet rs = ps.executeQuery();
			int i =1;
			while(rs.next() && i<4) {
				prod= new Producto();
				prod.setIdprod(rs.getInt(1));
				prod.setNombre(rs.getString(2));
				prod.setCategoria(rs.getString(3));
				prod.setStock(rs.getString(4));
				prod.setPrecio(rs.getString(5));
				prod.setImagen(rs.getString(6));
				prod.setEmail(rs.getString(7));
				list.add(prod);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Producto> getAllPantalones() {
		List<Producto> list= new ArrayList<Producto>();
		
		Producto prod= null;
		try {
			String sql="select * from productos where categoria=? order by idprod desc";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, "Pantalones");
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				prod= new Producto();
				prod.setIdprod(rs.getInt(1));
				prod.setNombre(rs.getString(2));
				prod.setCategoria(rs.getString(3));
				prod.setStock(rs.getString(4));
				prod.setPrecio(rs.getString(5));
				prod.setImagen(rs.getString(6));
				prod.setEmail(rs.getString(7));
				list.add(prod);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Producto> getAllRemeras() {
		List<Producto> list= new ArrayList<Producto>();
		
		Producto prod= null;
		try {
			String sql="select * from productos where categoria=? order by idprod desc";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, "Remeras");
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				prod= new Producto();
				prod.setIdprod(rs.getInt(1));
				prod.setNombre(rs.getString(2));
				prod.setCategoria(rs.getString(3));
				prod.setStock(rs.getString(4));
				prod.setPrecio(rs.getString(5));
				prod.setImagen(rs.getString(6));
				prod.setEmail(rs.getString(7));
				list.add(prod);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Producto> getAllZapatillas() {
		List<Producto> list= new ArrayList<Producto>();
		
		Producto prod= null;
		try {
			String sql="select * from productos where categoria=? order by idprod desc";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, "Zapatilla");
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				prod= new Producto();
				prod.setIdprod(rs.getInt(1));
				prod.setNombre(rs.getString(2));
				prod.setCategoria(rs.getString(3));
				prod.setStock(rs.getString(4));
				prod.setPrecio(rs.getString(5));
				prod.setImagen(rs.getString(6));
				prod.setEmail(rs.getString(7));
				list.add(prod);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Producto> getByPantalones() {
		List<Producto> list= new ArrayList<Producto>();
		
		Producto prod= null;
		try {
			String sql="select * from productos where categoria=? order by idprod desc";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, "Pantalones");
		
			ResultSet rs = ps.executeQuery();
			int i =1;
			while(rs.next() && i<4) {
				prod= new Producto();
				prod.setIdprod(rs.getInt(1));
				prod.setNombre(rs.getString(2));
				prod.setCategoria(rs.getString(3));
				prod.setStock(rs.getString(4));
				prod.setPrecio(rs.getString(5));
				prod.setImagen(rs.getString(6));
				prod.setEmail(rs.getString(7));
				list.add(prod);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Producto> busquedaProducto(String search) {
	List<Producto> list= new ArrayList<Producto>();
		
		Producto prod= null;
		try {
			String sql="select * from productos where nombre like ? and categoria like ? ";
			PreparedStatement ps= con.prepareStatement(sql);
			
			ps.setString(1, "%"+search +"%");
			ps.setString(2, "%"+search +"%");
		
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
				prod= new Producto();
				prod.setIdprod(rs.getInt(1));
				prod.setNombre(rs.getString(2));
				prod.setCategoria(rs.getString(3));
				prod.setStock(rs.getString(4));
				prod.setPrecio(rs.getString(5));
				prod.setImagen(rs.getString(6));
				prod.setEmail(rs.getString(7));
				list.add(prod);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	

	

}

