package migueldev.app.service;

import java.util.List;

import migueldev.app.model.Usuario;


public interface IUsuarioService {
	List<Usuario> mostrarListaUsuarios();
	void guardarUsuario(Usuario usuario);
}
