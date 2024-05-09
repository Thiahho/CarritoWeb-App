package adminServlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DB.DBConexion;
import dao.ProductoDaoImp;
import modelos.Producto;

@WebServlet("/editarProductos")
public class EditarProductosServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	    	String idprodParam = request.getParameter("idprod");
	        int idprod =  Integer.parseInt(idprodParam);
	        String nombre = request.getParameter("nombre");
	        String categoria = request.getParameter("categoria");
	        String stock = request.getParameter("stock");
	        String precio = request.getParameter("precio");
	        //Part part = request.getPart("imagen");
	        //String file = (part != null) ? part.getSubmittedFileName() : null;
	        //String file =null;
	        
	        if (idprodParam ==null || idprodParam.isEmpty() ||idprod ==0 || nombre == null || nombre.isEmpty() || stock == null || stock.isEmpty() || precio == null || precio.isEmpty()) {
	            throw new IllegalArgumentException("Los campos nombre, stock y precio son obligatorios.");
	        }
			/*
			 * if(part!=null && part.getSize()>0) { String fileName=
			 * obtenerNombreArchivo(part); guardarArchivo(part, fileName); file=fileName; }
			 */
	        Producto prod = new Producto(); 
	        prod.setIdprod(idprod);
	        prod.setNombre(nombre); 
	        prod.setCategoria(categoria); 
	        prod.setStock(stock);
	        prod.setPrecio(precio); 
	        //prod.setImagen(file); 
	        
	        HttpSession session = request.getSession(); 
	        ProductoDaoImp dao = new ProductoDaoImp(DBConexion.getConnection()); 
	        boolean f = dao.updateProducto(prod);
	        
	        if (f) { 
	            session.setAttribute("successMsg", "Producto Actualizado!");
	            response.sendRedirect("admin/allProductos.jsp"); 
	        } else {
	            session.setAttribute("failedMsg", "Error al Actualizar!");
	            response.sendRedirect("admin/allProductos.jsp"); 
	        }
	    } catch (NumberFormatException e) {
	        e.printStackTrace();
	        HttpSession session = request.getSession();
	        session.setAttribute("failedMsg", "El ID del producto no es válido");
	        response.sendRedirect("admin/allProductos.jsp"); 
	    } catch (IllegalArgumentException e) {
	        e.printStackTrace();
	        HttpSession session = request.getSession();
	        session.setAttribute("failedMsg", e.getMessage());
	        response.sendRedirect("admin/allProductos.jsp");
	    } catch (Exception e) {
	        e.printStackTrace();
	        HttpSession session = request.getSession();
	        session.setAttribute("failedMsg", "Error al procesar la solicitud");
	        response.sendRedirect("admin/allProductos.jsp");
	    }
	}

	
	
}
