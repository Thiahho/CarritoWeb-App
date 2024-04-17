package modelos;

public class Pedido {
	private int id;
	private String idpedido;
	
	private String unombre;
	private String uemail;
	private String udireccion;
	private String fullAdd;
	
	private String pnombre;
	private String pcategoria;
	private String pprecio;
	private String estado;
	
	public Pedido() {
		super();
	}
	
	
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getUdireccion() {
		return udireccion;
	}


	public void setUdireccion(String udireccion) {
		this.udireccion = udireccion;
	}


	public String getPnombre() {
		return pnombre;
	}


	public void setPnombre(String pnombre) {
		this.pnombre = pnombre;
	}


	public String getPcategoria() {
		return pcategoria;
	}


	public void setPcategoria(String pcategoria) {
		this.pcategoria = pcategoria;
	}


	public String getPprecio() {
		return pprecio;
	}


	public void setPprecio(String pprecio) {
		this.pprecio = pprecio;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(String idpedido) {
		this.idpedido = idpedido;
	}
	public String getUnombre() {
		return unombre;
	}
	public void setUnombre(String unombre) {
		this.unombre = unombre;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getFullAdd() {
		return fullAdd;
	}
	public void setFullAdd(String fullAdd) {
		this.fullAdd = fullAdd;
	}


	@Override
	public String toString() {
		return "Pedido [id=" + id + ", idpedido=" + idpedido + ", unombre=" + unombre + ", uemail=" + uemail
				+ ", udireccion=" + udireccion + ", fullAdd=" + fullAdd + ", pnombre=" + pnombre + ", pcategoria="
				+ pcategoria + ", pprecio=" + pprecio + ", estado=" + estado + "]";
	}


	
	
	
	
	
	
}
