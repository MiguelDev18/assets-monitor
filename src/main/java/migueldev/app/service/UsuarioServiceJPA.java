package migueldev.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import migueldev.app.model.Usuario;
import migueldev.app.repository.UsuariosRepository;

@Service
public class UsuarioServiceJPA implements IUsuarioService{
	
	@Autowired
	private UsuariosRepository usuariosRepo;

	@Override
	public List<Usuario> mostrarListaUsuarios() {
		// TODO Auto-generated method stub
		return usuariosRepo.findAll();
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		usuariosRepo.save(usuario);
		
	}

}