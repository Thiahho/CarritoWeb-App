package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.DBConexion;
import dao.CarritoDaoImp;

@WebServlet("/eliminarprod")
public class EliminarProductoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
		
	  @Override protected void doGet(HttpServletRequest request,
	  HttpServletResponse response) throws ServletException, IOException 
	  { 
		  try {
	  
	  int idprod = Integer.parseInt(request.getParameter("idprod").trim()); 
	  int idusuario = Integer.parseInt(request.getParameter("idusuario").trim());
	  int idcarrito= Integer.parseInt(request.getParameter("idcarrito"));
	  CarritoDaoImp dao = new CarritoDaoImp(DBConexion.getConnection()); 
	  boolean f=dao.eliminarProducto(idprod, idusuario, idcarrito);
	  
	  HttpSession session= request.getSession();
	  
	  if(f) 
	  {
		  session.setAttribute("successMsg","Producto ELiminado correctamente"); 
		  response.sendRedirect("carrito.jsp");
	  }else { 
		  session.setAttribute("failedMsg", "Error al eliminar el Producto");
		  response.sendRedirect("carrito.jsp"); 
		  }
	  } catch (Exception e) {
		  e.printStackTrace(); }
	 
	  }
	 
	
}
