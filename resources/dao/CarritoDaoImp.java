package dao;

import java.awt.desktop.AppReopenedEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Carrito;
import modelos.Producto;

public class CarritoDaoImp implements CarritoDao{

	private Connection con;
	
	public CarritoDaoImp(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public boolean addCarrito(Carrito carrito) {

		boolean f= false;
		try {
			 String sql="INSERT INTO shopc.carrito(idprod,idusuario,nombre,categoria,precio,total) VALUES (?,?,?,?,?,?) ";
			 PreparedStatement ps= con.prepareStatement(sql);
			 ps.setInt(1, carrito.getIdprod());
			 ps.setInt(2, carrito.getIdusuario());
			 ps.setString(3, carrito.getNombre());
			 ps.setString(4, carrito.getCategoria());
			 ps.setDouble(5, carrito.getPrecio());
			 ps.setDouble(6, carrito.getTotal());
			 
			 int i= ps.executeUpdate();
			  if(i==1) {
				  f=true;
			  }
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	/*
	 * public double obtenerDineroDisponibleUsuario(int idUsuario) { double
	 * dineroDisponible = 0; try { String sql =
	 * "SELECT dinero FROM shopc.usuario WHERE idusuario = ?"; PreparedStatement ps
	 * = con.prepareStatement(sql); ps.setInt(1, idUsuario); ResultSet rs =
	 * ps.executeQuery(); if (rs.next()) { dineroDisponible =
	 * rs.getDouble("dinero"); } } catch (Exception e) { e.printStackTrace(); }
	 * return dineroDisponible; }
	 */

	@Override
	public List<Carrito> getProductoByUsuario(int idusuario) {
		List<Carrito> list= new ArrayList<Carrito>();
		Carrito car= null;
		double preciototal=0;
		try {
			String sql="select * from carrito where idusuario=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, idusuario);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				car= new Carrito();
				
				car.setIdcarrito(rs.getInt(1));
				car.setIdprod(rs.getInt(2));
				car.setIdusuario(rs.getInt(3));
				car.setNombre(rs.getString(4));
				car.setCategoria(rs.getString(5));
				car.setPrecio(rs.getDouble(6));
				preciototal=preciototal+ rs.getDouble(7);
				car.setTotal(preciototal);
						
				
				 list.add(car);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return list;
	}
	 @Override
	    public boolean limpiarCarrito(int idUsuario) {
	        boolean limpiezaExitosa = false;
	        try {
	            // Preparar la consulta SQL para eliminar los productos del carrito del usuario
	            String sql = "DELETE FROM carrito WHERE idusuario = ?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, idUsuario);

	            // Ejecutar la consulta
	            int filasEliminadas = ps.executeUpdate();
	            if (filasEliminadas > 0) {
	                limpiezaExitosa = true;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return limpiezaExitosa;
	    }
	@Override
	public boolean eliminarProducto(int idprod, int idusuario, int idcarrito) {
		boolean f= false;
		
		try {
			String sql="delete from carrito where idprod=? and idusuario=? and idcarrito=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, idprod);
			ps.setInt(2, idusuario);
			ps.setInt(3, idcarrito);
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return f;
		
	}

	@Override
	public boolean updateCarrito(Carrito carrito) {
		boolean f= false;
		
		try {
			String sql = "update usuario set estado='PAGADO' WHERE idusuario=?";
    	 	PreparedStatement ps = con.prepareStatement(sql);
    	 	ps.setString(1, carrito.getEstado());
    	 	ps.setInt(2, carrito.getIdusuario());
            
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}


	
}

