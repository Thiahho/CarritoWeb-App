package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.DBConexion;
import dao.CarritoDaoImp;
import dao.ProductoDaoImp;
import dao.UsuarioDaoImp;
import modelos.Carrito;
import modelos.Producto;
import modelos.Usuario;

@WebServlet("/carrito")
public class CarritoServlet extends HttpServlet{

	/*
	 * @Override protected void doPost(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 * 
	 * 
	 * 
	 * }
	 */



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idprod = Integer.parseInt(request.getParameter("idprod").trim());
			int idusuario = Integer.parseInt(request.getParameter("idusuario").trim());

			
			ProductoDaoImp dao= new ProductoDaoImp(DBConexion.getConnection());
			Producto prod= dao.getProductoById(idprod);
			
			Carrito carrito= new Carrito();
			carrito.setIdprod(idprod);
			carrito.setIdusuario(idusuario);
			carrito.setNombre(prod.getNombre());
			carrito.setCategoria(prod.getCategoria());
			carrito.setPrecio(Double.parseDouble(prod.getPrecio()));
			carrito.setTotal(Double.parseDouble(prod.getPrecio()));
			
			CarritoDaoImp dao2 = new CarritoDaoImp(DBConexion.getConnection());
			boolean f=dao2.addCarrito(carrito);
			HttpSession session= request.getSession();
			if(f)
			{
				session.setAttribute("addCarrito", "Producto Agregado al Carrito!");
				response.sendRedirect("index.jsp");
			}else{
				session.setAttribute("addCarrito", "Producto Agregado al Carrito!");
				response.sendRedirect("index.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	
}
	  
	 
		/*
		 * protected double obtenerDineroDisponibleUsuario(HttpServletRequest request,
		 * int idUsuario) { double dineroDisponible = 0; try { HttpSession session =
		 * request.getSession(); Usuario usuario = (Usuario)
		 * session.getAttribute("userobj"); dineroDisponible = usuario.getDinero(); }
		 * catch (Exception e) { e.printStackTrace(); } return dineroDisponible; }
		 */


	/*
	 * @Override protected void doPost(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { try { //
	 * Obtener datos del formulario de pago int idUsuario =
	 * Integer.parseInt(request.getParameter("idusuario")); double precioTotal =
	 * Double.parseDouble(request.getParameter("preciototal")); String metodoPago =
	 * request.getParameter("metodopago");
	 * 
	 * // Verificar si el método de pago es EFECTIVO if
	 * ("EFECTIVO".equals(metodoPago)) { // Obtener dinero disponible del usuario
	 * double dineroDisponible = obtenerDineroDisponibleUsuario(request, idUsuario);
	 * 
	 * // Verificar si el usuario tiene suficiente dinero if (dineroDisponible >=
	 * precioTotal) { // Generar el pedido y realizar las operaciones necesarias //
	 * ...
	 * 
	 * // Redirigir a una página de confirmación de pedido exitoso
	 * response.sendRedirect("pedidoExitoso.jsp"); } else { // Mostrar un mensaje de
	 * error al usuario indicando que no tiene suficiente dinero
	 * request.setAttribute("errorMsg",
	 * "No tienes suficiente dinero para pagar el pedido."); RequestDispatcher
	 * dispatcher = request.getRequestDispatcher("formularioPago.jsp");
	 * dispatcher.forward(request, response); } } else { // Mostrar un mensaje de
	 * error al usuario indicando que debe seleccionar un método de pago válido
	 * request.setAttribute("errorMsg",
	 * "Por favor selecciona un método de pago válido."); RequestDispatcher
	 * dispatcher = request.getRequestDispatcher("formularioPago.jsp");
	 * dispatcher.forward(request, response); } } catch (Exception e) {
	 * e.printStackTrace(); // Manejo de excepciones } }
	 */

	/*
	 * @Override protected void doPost(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { try { //
	 * Obtener datos del formulario de pago int idUsuario =
	 * Integer.parseInt(request.getParameter("idusuario")); double precioTotal =
	 * Double.parseDouble(request.getParameter("preciototal"));
	 * 
	 * // Obtener dinero disponible del usuario double dineroDisponible =
	 * obtenerDineroDisponibleUsuario(idUsuario);
	 * 
	 * // Verificar si el usuario tiene suficiente dinero if (dineroDisponible >=
	 * precioTotal) { // Calcular el nuevo dinero disponible después de la compra
	 * double nuevoDineroDisponible = dineroDisponible - precioTotal;
	 * 
	 * // Actualizar el dinero disponible del usuario en la base de datos
	 * actualizarDineroUsuario(idUsuario, nuevoDineroDisponible);
	 * 
	 * // Generar el pedido y realizar otras operaciones necesarias // ...
	 * 
	 * // Redirigir a una página de confirmación de pedido exitoso
	 * response.sendRedirect("pedidoExitoso.jsp"); } else { // Mostrar un mensaje de
	 * error al usuario indicando que no tiene suficiente dinero
	 * request.setAttribute("errorMsg",
	 * "No tienes suficiente dinero para pagar el pedido."); RequestDispatcher
	 * dispatcher = request.getRequestDispatcher("formularioPago.jsp");
	 * dispatcher.forward(request, response); } } catch (Exception e) {
	 * e.printStackTrace(); // Manejo de excepciones } }
	 * 
	 * // Método para actualizar el dinero disponible del usuario en la base de
	 * datos private void actualizarDineroUsuario(int idUsuario, double nuevoDinero)
	 * { try { // Aquí deberías ejecutar una consulta SQL para actualizar el dinero
	 * disponible del usuario // Supongamos que tienes un método en tu DAO para
	 * actualizar el dinero del usuario UsuarioDaoImp dao = new
	 * UsuarioDaoImp(DBConexion.getConnection());
	 * dao.actualizarDineroUsuario(idUsuario, nuevoDinero); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */

