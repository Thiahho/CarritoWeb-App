package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DB.DBConexion;
import modelos.Producto;
import modelos.Usuario;

public class UsuarioDaoImp implements UsuarioDao {

    private Connection con;

    public UsuarioDaoImp(Connection con) {
        this.con = con;
    }
    public boolean actualizarDineroUsuario(int idUsuario, double nuevoDinero) {
        boolean f = false;
        try {
            String sql = "UPDATE usuario SET dinero = ? WHERE idusuario = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setDouble(1, nuevoDinero);
                ps.setInt(2, idUsuario);
                int filasActualizadas = ps.executeUpdate();
                f = filasActualizadas > 0; // Actualización exitosa si se actualizó al menos una fila
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    public boolean usuarioRegistro(Usuario usuario) {
        boolean f = false;

        try {
        	 	String sql = "insert into usuario (nombre, email, direccion, password) values (?,?,?,?)";
        	 	PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, usuario.getNombre());
                ps.setString(2, usuario.getEmail());
                ps.setString(3, usuario.getDireccion());
                ps.setString(4, usuario.getPassword());

                int i = ps.executeUpdate();
                if (i == 1) {
                    f = true;
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return f;
    }
    @Override
	public boolean deleteUsuario(int idusuario) {
		boolean f= false;
		try {
		String sql="delete from usuario where idusuario=?";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setInt(1, idusuario);
		
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
	public Usuario login(String email, String password) {
		Usuario us= null;
		
		try {
			String sql="select * from usuario where email=? and password=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				us= new Usuario();
				us.setIdusuario(rs.getInt(1));
				us.setNombre(rs.getString(2));
				us.setEmail(rs.getString(3));
				us.setDireccion(rs.getString(4));
				us.setPassword(rs.getString(5));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return us;
	}


	@Override
	public boolean verificarPass(int idusuario,String password) {
		boolean f= true;
		
		try {
			String sql="select password from usuario where idusuario=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, idusuario);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				f=false;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}


	@Override
	public boolean updatePerfil(Usuario usuario) {
	boolean f= true;
		
		try {
			String sql = "update usuario set nombre=?,email=?,direccion=?,password=?,dinero=? WHERE idusuario=?";
    	 	PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getDireccion());
            ps.setString(4, usuario.getPassword());
            ps.setDouble(5, usuario.getDinero());
            ps.setInt(6, usuario.getIdusuario());
            
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}


	@Override
	public boolean verificarUsuario(String email) {
			boolean f= true;
		
		try {
			String sql = "select * from usuario where email =?";
    	 	PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
            	f=false;
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}


	/*
	 * @Override public Usuario cargarDinero(int idusuario, String dinero) {
	 * 
	 * //List<Usuario> list= new ArrayList<Usuario>(); Usuario usu= null; try {
	 * String sql = "update usuario set dinero=? WHERE idusuario =? ";
	 * PreparedStatement ps = con.prepareStatement(sql); ps.setInt(1,
	 * usu.getIdusuario()); ps.setDouble(2, usu.getDinero());
	 * 
	 * int rs= ps.executeUpdate(); if(rs>0) { usu=getUsuarioById(idusuario); } }
	 * catch (Exception e) { e.printStackTrace(); } return usu; }
	 */


	@Override
	public Usuario getUsuarioById(int idusuario) {
		Usuario usu = null;
	    try {
	        String sql = "select * from usuario where idusuario=?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, idusuario);
	        
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            // Si se encuentra un usuario con el ID dado, crear un objeto Usuario y establecer sus atributos
	            usu = new Usuario();
	            usu.setIdusuario(rs.getInt("idusuario"));
	            usu.setNombre(rs.getString("nombre"));
	            usu.setEmail(rs.getString("email"));
	            usu.setDireccion(rs.getString("direccion"));
	            usu.setPassword(rs.getString("password"));
	            usu.setDinero(rs.getDouble("dinero"));
	            // Agrega más campos según tu estructura de tabla Usuario
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return usu;
	}


	@Override
	public List<Usuario> getAllUsuarios() {
		List<Usuario> list= new ArrayList<Usuario>();
		Usuario usu= null;
		try {
			String sql="select * from usuario";
			PreparedStatement ps= con.prepareStatement(sql);
			
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				
				usu= new Usuario();
				usu.setIdusuario(rs.getInt(1));
				usu.setNombre(rs.getString(2));
				usu.setEmail(rs.getString(3));
				usu.setDireccion(rs.getString(4));
				usu.setPassword(rs.getString(5));
				usu.setDinero(rs.getDouble(6));
				list.add(usu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}


	/*
	 * @Override public boolean updateDinero(Usuario usu) { boolean f=false; try {
	 * String sql="update usuario set dinero=? where idusuario=?"; PreparedStatement
	 * ps= con.prepareStatement(sql); ps.setDouble(1, usu.getDinero()); ps.setInt(2,
	 * usu.getIdusuario());
	 * 
	 * int i=ps.executeUpdate(); if(i==1) { f=true; } } catch (Exception e) {
	 * e.printStackTrace(); } return f; }
	 */


}

