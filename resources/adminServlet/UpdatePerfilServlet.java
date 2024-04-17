package adminServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.DBConexion;
import dao.UsuarioDaoImp;
import modelos.Usuario;
@WebServlet("/editarPerfil")
public class UpdatePerfilServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idusuario= Integer.parseInt(request.getParameter("idusuario"));
			String nombre=request.getParameter("nombre");
			String email= request.getParameter("email");
			String direccion= request.getParameter("direccion");
			String password= request.getParameter("password");
			Double dinero= Double.parseDouble(request.getParameter("dinero"));
			
			Usuario us=new Usuario();
			us.setIdusuario(idusuario);
			us.setNombre(nombre);
			us.setEmail(email);
			us.setDireccion(direccion);
			us.setPassword(password);
			us.setDinero(dinero);
			HttpSession session= request.getSession();
			
			
			UsuarioDaoImp dao= new UsuarioDaoImp(DBConexion.getConnection());
		    //boolean f= dao.verificarPass(idusuario, password);
			boolean f=dao.updatePerfil(us);
			//HttpSession session2 = request.getSession();
			
			if(f) {
				session.setAttribute("successMsg", "Usuario Actualizado!");
				response.sendRedirect("admin/allUsuarios.jsp");
			}else {
				session.setAttribute("failedMsg", "Error al Actualizar!");
				response.sendRedirect("admin/allUsuarios.jsp");
			}
			
	
		}catch (Exception e) {
			e.printStackTrace();
		}
		}

	
}
