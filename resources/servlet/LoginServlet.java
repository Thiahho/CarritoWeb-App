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



@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			UsuarioDaoImp usuariodao= new UsuarioDaoImp(DBConexion.getConnection());
			HttpSession session= request.getSession();
			
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			if("admin@gmail.com".equals(email) && "admin".equals(password)) {
			    Usuario us= new Usuario();
			    us.setNombre("Admin");
			    session.setAttribute("userobj", us);
			    response.sendRedirect("admin/home.jsp");
			}
			else {
			    Usuario us= usuariodao.login(email, password);

			    if(us!=null) {
			        session.setAttribute("userobj", us);
			        response.sendRedirect("index.jsp");
			    }else {
			        session.setAttribute("failMenj", "Email & Password incorrectos!");
			        response.sendRedirect("login.jsp");      
			    }
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
}
