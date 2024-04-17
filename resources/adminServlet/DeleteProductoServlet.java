package adminServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.DBConexion;
import dao.ProductoDaoImp;

@WebServlet("/deleteprod")
public class DeleteProductoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idprod= Integer.parseInt(request.getParameter("idprod"));
			ProductoDaoImp dao= new ProductoDaoImp(DBConexion.getConnection());
			boolean f= dao.deleteProducto(idprod);
			
			HttpSession session= request.getSession();
			
			if(f) {
				session.setAttribute("successMsg", "Producto Eliminado!");
				response.sendRedirect("admin/allProductos.jsp");
			}else {
				session.setAttribute("failedMsg", "Error al Eliminar!");
				response.sendRedirect("admin/allProductos.jsp");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
