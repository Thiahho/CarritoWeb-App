package dao;

import java.util.List;

import modelos.Pedido;

public interface PedidoDao {

		//public int getPedidoNum();

		public boolean guardarPedido(List<Pedido> ped);
		public List<Pedido> getPedido(String uemail);
		public List<Pedido> getAllPedidos();
}
