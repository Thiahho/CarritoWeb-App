package servlet;

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


@WebServlet("/registro")
public class RegistroServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nombre=request.getParameter("nombre");
			String email= request.getParameter("email");
			String direccion= request.getParameter("direccion");
			String password= request.getParameter("password");
			String check = request.getParameter("check");
			
			Usuario usuario = new Usuario();
			usuario.setNombre(nombre);
			usuario.setEmail(email);
			usuario.setDireccion(direccion);
			usuario.setPassword(password);
			
			HttpSession session= request.getSession();
			
			
			if(check!=null) 
			{
				
				UsuarioDaoImp dao = new UsuarioDaoImp(DBConexion.getConnection());
				boolean f2= dao.verificarUsuario(email);
				if(f2) 
				{
					boolean  f= dao.usuarioRegistro(usuario);
					if(f) 
					{
						//System.out.println("Usuario Regostrado");
						session.setAttribute("successMsg", "Registro Exitoso!");
						response.sendRedirect("registro.jsp");
					}else {	
							
					    session.setAttribute("failMens","Error al registrar!");
						response.sendRedirect("registro.jsp");
						}	
					
				}else {
					 session.setAttribute("failMens","Ya existe un usuario con este Email.");
						response.sendRedirect("registro.jsp");
				}
			}else {
			    session.setAttribute("failMens","Acepte los Terminos & Condiciones!");
				response.sendRedirect("registro.jsp");
		
			}
		
			
		 } catch (Exception e) {
			e.printStackTrace();
		 }
	}
}
		