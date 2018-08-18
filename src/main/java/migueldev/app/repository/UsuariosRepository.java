package migueldev.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import migueldev.app.model.Usuario;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
	public Usuario findByUsername(String userName);

}
