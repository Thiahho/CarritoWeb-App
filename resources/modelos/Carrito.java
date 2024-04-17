package modelos;

public class Carrito {

	private int idcarrito;
	private int idusuario;
	private int idprod;
	private String nombre;
	private String categoria;
	private Double precio;
	private Double total;
	private String estado;
	
	public int getIdcarrito() {
		return idcarrito;
	}


	public void setIdcarrito(int idcarrito) {
		this.idcarrito = idcarrito;
	}

	public int getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	


	
	
}
