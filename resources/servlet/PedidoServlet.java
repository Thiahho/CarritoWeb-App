package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import DB.DBConexion;
import dao.CarritoDaoImp;
import dao.PedidoDaoImp;
import dao.UsuarioDaoImp;
import modelos.Carrito;
import modelos.Pedido;
import modelos.Producto;
import modelos.Usuario;

@WebServlet("/pedido")
public class PedidoServlet extends HttpServlet{

	/*
	 * @Override protected void doPost(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { try {
	 * HttpSession session= request.getSession();
	 * 
	 * int idusuario= Integer.parseInt(request.getParameter("idusuario")); String
	 * unombre=request.getParameter("unombre"); String
	 * uemail=request.getParameter("uemail"); String
	 * udireccion=request.getParameter("udireccion"); String
	 * pnombre=request.getParameter("pnombre"); String
	 * pcategoria=request.getParameter("pcategoria"); String
	 * pprecio=request.getParameter("pprecio"); String
	 * metodopago=request.getParameter("metodopago"); String
	 * estado=request.getParameter("estado");
	 * 
	 * String fullAdd=udireccion +","+uemail;
	 * 
	 * //System.out.println(unombre+ " " + uemail+ " " +fullAdd+" "+ metodopago);
	 * 
	 * CarritoDaoImp dao = new CarritoDaoImp(DBConexion.getConnection());
	 * List<Carrito> plista=dao.getProductoByUsuario(idusuario);
	 * 
	 * 
	 * if(plista.isEmpty()) { session.setAttribute("failedsMsg",
	 * "Agregue un producto!"); response.sendRedirect("carrito.jsp");
	 * 
	 * }else {
	 * 
	 * 
	 * PedidoDaoImp dao2= new PedidoDaoImp(DBConexion.getConnection()); Pedido ped=
	 * null; //int i=dao2.getPedidoNum();
	 * 
	 * 
	 * ArrayList<Pedido> pedidoList= new ArrayList<Pedido>(); Random random= new
	 * Random(); for(Carrito car:plista) { ped= new Pedido();
	 * ped.setIdpedido("PROD-ID-00"+ random.nextInt(1000)); ped.setUnombre(unombre);
	 * ped.setUemail(uemail); ped.setUdireccion(udireccion);
	 * ped.setFullAdd(fullAdd); ped.setPnombre(car.getNombre());
	 * ped.setPcategoria(car.getCategoria()); ped.setPprecio(car.getPrecio()+"");
	 * ped.setMetodopago(metodopago); pedidoList.add(ped);
	 * 
	 * }
	 * 
	 * 
	 * boolean f= dao2.guardarPedido(pedidoList); if(f) {
	 * response.sendRedirect("pedido_realizado.jsp");
	 * 
	 * } else { session.setAttribute("failedsMsg", "Error al cargar el pedido!");
	 * response.sendRedirect("carrito.jsp"); }
	 * 
	 * 
	 * } } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * 
	 * }
	 */
	
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        try {
	            HttpSession session = request.getSession();

	            int idusuario = Integer.parseInt(request.getParameter("idusuario"));
	            String unombre = request.getParameter("unombre");
	            String uemail = request.getParameter("uemail");
	            String udireccion = request.getParameter("udireccion");
	            String pprecio = request.getParameter("preciototal");
	            //String metodopago = request.getParameter("metodopago");

	            // Obtener el dinero disponible del usuario desde la base de datos
	            UsuarioDaoImp usuarioDao = new UsuarioDaoImp(DBConexion.getConnection());
	            Usuario usuario = usuarioDao.getUsuarioById(idusuario);
	            double dineroDisponible = usuario.getDinero();

	            // Verificar si el usuario tiene suficiente dinero para realizar la compra
	            double totalPrecio = Double.parseDouble(pprecio);
	            if (dineroDisponible >= totalPrecio) {
	                // Realizar la resta del total del precio al dinero disponible
	                double nuevoDineroDisponible = dineroDisponible - totalPrecio;

	                // Actualizar el dinero del usuario en la base de datos
	                boolean actualizacionExitosa = usuarioDao.actualizarDineroUsuario(idusuario, nuevoDineroDisponible);
	                if (actualizacionExitosa) {
	                    // Generar el pedido y realizar otras operaciones necesarias
	                    CarritoDaoImp carritoDao = new CarritoDaoImp(DBConexion.getConnection());
	                    List<Carrito> carritoList = carritoDao.getProductoByUsuario(idusuario);

	                    ArrayList<Pedido> pedidoList = new ArrayList<>();
	                    
	                    for (Carrito car : carritoList) {
	                        Pedido pedido = new Pedido();
	                        pedido.setIdpedido("PROD-ID-00" + car.getIdprod());
	                        pedido.setUnombre(unombre);
	                        pedido.setUemail(uemail);
	                        pedido.setUdireccion(udireccion);
	                        pedido.setPnombre(car.getNombre());
	                        pedido.setPcategoria(car.getCategoria());
	                        pedido.setPprecio(car.getPrecio().toString());
	                        pedido.setEstado("PAGADO");
	                        pedidoList.add(pedido);
	                    }

	                    PedidoDaoImp pedidoDao = new PedidoDaoImp(DBConexion.getConnection());
	                    boolean pedidoGuardado = pedidoDao.guardarPedido(pedidoList);
	                    if (pedidoGuardado) {
	                        // Limpiar el carrito después de realizar el pedido
	                        carritoDao.limpiarCarrito(idusuario);
	                        response.sendRedirect("pedido_realizado.jsp");
	                    } else {
	                        session.setAttribute("failedsMsg", "Error al cargar el pedido!");
	                        response.sendRedirect("carrito.jsp");
	                    }
	                } else {
	                    session.setAttribute("failedsMsg", "Error al actualizar el dinero del usuario!");
	                    response.sendRedirect("carrito.jsp");
	                }
	            } else {
	                // Mostrar un mensaje de que el usuario no tiene suficiente dinero para realizar la compra
	                session.setAttribute("failedsMsg", "No tienes suficiente dinero para realizar la compra. Por favor, carga más dinero.");
	                response.sendRedirect("carrito.jsp");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
}