package migueldev.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import migueldev.app.model.Hogar;
import migueldev.app.model.RoleUsuario;
import migueldev.app.model.Usuario;
import migueldev.app.repository.HogaresRepository;
import migueldev.app.repository.RolesUsuarioRepository;
import migueldev.app.repository.UsuariosRepository;

@Service
public class UsuarioServiceJPA implements IUsuarioService{
	
	
	@Autowired
	private UsuariosRepository usuariosRepo;
	
	@Autowired
	private RolesUsuarioRepository roleRepo;
	
	
	@Override
	public List<Usuario> mostrarListaUsuarios() {
		// TODO Auto-generated method stub
		return usuariosRepo.findAll();
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		System.out.println("usuario: " + usuario);
		usuariosRepo.save(usuario);
		
	}
	

	@Override
	public Usuario mostrarUsuario(int idUsuario) {
		Optional<Usuario> usuario = usuariosRepo.findById(idUsuario);
		if(usuario.isPresent())
			return usuario.get();
		return null;
	}

	@Override
	public void eliminarUsuario(int idUsuario) {
		usuariosRepo.deleteById(idUsuario);
		
	}

	@Override
	public Usuario mostrarUsuario(String username) {
		return usuariosRepo.findByUsername(username);
	}

	@Override
	public void guardarRole(RoleUsuario role) {
		roleRepo.save(role);
		
	}

	@Override
	public boolean existeRole(String username) {
		return roleRepo.existsByUsername(username);
	}




}
