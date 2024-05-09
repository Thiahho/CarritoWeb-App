package dao;

import java.util.List;

import modelos.Usuario;

public interface UsuarioDao{
	
	public boolean usuarioRegistro(Usuario usuario);
	
	public Usuario login(String email, String password);
	
	//public boolean verificarPass(int idusuario,String password); 
	public boolean updatePerfil(Usuario usuario);
	
	public boolean verificarUsuario(String email);
	
	//public Usuario cargarDinero(int idusuario, String dinero);
	//public boolean updateDinero(Usuario usu);
	public Usuario getUsuarioById(int idusuario);
	public List<Usuario> getAllUsuarios();
	public boolean deleteUsuario(int idusuario);
	
}

