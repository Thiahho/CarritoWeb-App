package adminServlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DB.DBConexion;
import dao.ProductoDaoImp;
import modelos.Producto;

@WebServlet("/addProductos")
@MultipartConfig
public class AddProductosServlet extends HttpServlet{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nombre= request.getParameter("nombre");
			String categoria= request.getParameter("categoria");
			String stock = request.getParameter("stock");
			String precio= request.getParameter("precio");
			Part part = request.getPart("imagen");
			//String file= part.getSubmittedFileName();
			String file=(part !=null) ? part.getSubmittedFileName() :null;
			Producto prod= new Producto(nombre,categoria,stock,precio,file,"admin");
			
			ProductoDaoImp dao= new ProductoDaoImp(DBConexion.getConnection());
			
			 boolean f=dao.addProductos(prod); 
			 HttpSession session= request.getSession();
			 if(f) {
			  
			   String path= getServletContext().getRealPath("")+"img";
			      
			   File arch = new File(path);
			   part.write(path+File.separator + file);
			        
				  
			  session.setAttribute("successMsg", "Producto Agregado Correctamente!");
			  response.sendRedirect("admin/addProductos.jsp"); 
			  }
			 else{
				  
				 session.setAttribute("failedMsg", "Error al Agregar Producto!");
				 response.sendRedirect("admin/addProductos.jsp");
			  	 }

			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
}
