package modelos;

public class Usuario {

	private int idusuario;
	private String nombre;
	private String email;
	private Double dinero;
	private String direccion;
	private String password;
	
	public Usuario(int idusuario, String nombre, String email,Double dinero, String direccion, String password) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.email = email;
		this.dinero = dinero;
		this.direccion = direccion;
		this.password = password;
	}
	
	public Usuario() {
		super();
	}


	
	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

    public Double getDinero() {
    	return dinero; 
    } 
	  
	  public void setDinero(Double dinero) {
		  this.dinero = dinero; 
	}
	 
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
