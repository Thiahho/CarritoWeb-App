package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelos.Pedido;

public class PedidoDaoImp implements PedidoDao{

	private Connection con;

	public PedidoDaoImp(Connection con) {
		super();
		this.con = con;
	}



	@Override
	public boolean guardarPedido(List<Pedido> plista) {
		boolean f=false;
		try {
			
			String sql="insert into pedidos (idpedido,unombre,uemail,udireccion,pnombre,pcategoria,pprecio,estado) values (?,?,?,?,?,?,?,?)";
			con.setAutoCommit(false);
			
			PreparedStatement ps= con.prepareStatement(sql);
			for(Pedido ped:plista) 
			{
				ps.setString(1, ped.getIdpedido());
				ps.setString(2, ped.getUnombre());
				ps.setString(3, ped.getUemail());
				ps.setString(4, ped.getUdireccion());
				ps.setString(5, ped.getPnombre());
				ps.setString(6, ped.getPcategoria());
				ps.setString(7, ped.getPprecio());
				ps.setString(8, ped.getEstado());
				ps.addBatch();
			}
				int[]count =ps.executeBatch();
				con.commit();
				f=true;
				con.setAutoCommit(true);
				
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<Pedido> getPedido(String uemail) {
		List<Pedido>list=new ArrayList<Pedido>();
		Pedido ped= null;
				
		try {
			String sql="select * from pedidos where uemail=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, uemail);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				ped = new Pedido();
				ped.setId(rs.getInt(1));
				ped.setIdpedido(rs.getString(2));
				ped.setUnombre(rs.getString(3));
				ped.setUemail(rs.getString(4));
				ped.setFullAdd(rs.getString(5));
				ped.setPnombre(rs.getString(6)); 
				ped.setPcategoria(rs.getString(7));
				ped.setPprecio(rs.getString(8));
				
				list.add(ped);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



	@Override
	public List<Pedido> getAllPedidos() {
		List<Pedido>list=new ArrayList<Pedido>();
		Pedido ped= null;
				
		try {
			String sql="select * from pedidos";
			PreparedStatement ps= con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				ped = new Pedido();
				ped.setId(rs.getInt(1));
				ped.setIdpedido(rs.getString(2));
				ped.setUnombre(rs.getString(3));
				ped.setUemail(rs.getString(4));
				ped.setUdireccion(rs.getString(5));
				ped.setPnombre(rs.getString(6)); 
				ped.setPcategoria(rs.getString(7));
				ped.setPprecio(rs.getString(8));
				ped.setEstado(rs.getString(9));
				list.add(ped);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}



	
}
