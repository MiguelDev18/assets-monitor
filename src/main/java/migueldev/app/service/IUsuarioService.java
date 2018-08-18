package migueldev.app.service;

import java.util.List;

import migueldev.app.model.Hogar;
import migueldev.app.model.RoleUsuario;
import migueldev.app.model.Usuario;


public interface IUsuarioService {

	List<Usuario> mostrarListaUsuarios();
	void guardarUsuario(Usuario usuario);
	void guardarRole(RoleUsuario role);
	boolean existeRole(String username);
	Usuario mostrarUsuario(int idUsuario);
	void eliminarUsuario(int idUsuario);
	Usuario mostrarUsuario(String username);
}
