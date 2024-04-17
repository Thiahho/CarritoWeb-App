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
import dao.UsuarioDaoImp;

@WebServlet("/deleteusu")
public class DeleteUsuarioServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idusuario= Integer.parseInt(request.getParameter("idusuario"));
			UsuarioDaoImp dao= new UsuarioDaoImp(DBConexion.getConnection());
			boolean f= dao.deleteUsuario(idusuario);
			
			HttpSession session= request.getSession();
			
			if(f) {
				session.setAttribute("successMsg", "Usuario Eliminado!");
				response.sendRedirect("admin/allUsuarios.jsp");
			}else {
				session.setAttribute("failedMsg", "Error al Eliminar!");
				response.sendRedirect("admin/allUsuarios.jsp");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
