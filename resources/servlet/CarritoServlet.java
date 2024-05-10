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
	  
	
