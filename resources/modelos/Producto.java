package modelos;

public class Producto {

	private int idprod;
	private String nombre;
	private String categoria;
	private String stock;
	private String precio;
	private String imagen;
	private String email;
	
	
	public Producto() {
		super();
	}
	
	public Producto(int idprod, String nombre, String categoria, String stock, String precio, String imagen) {
		super();
		this.idprod = idprod;
		this.nombre = nombre;
		this.categoria = categoria;
		this.stock = stock;
		this.precio = precio;
		this.imagen = imagen;
	}

	public Producto(String nombre, String categoria,String stock, String precio, String imagen, String email) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.stock=stock;
		this.precio = precio;
		this.imagen = imagen;
		this.email = email;
	}
	
	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	
	public int getIdprod() {
		return idprod;
	}

	public void setIdprod(int idprod) {
		this.idprod = idprod;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Producto [idprod=" + idprod + ", nombre=" + nombre + ", categoria=" + categoria + ", stock=" + stock
				+ ", precio=" + precio + ", imagen=" + imagen + ", email=" + email + "]";
	}

	



	
	
}
