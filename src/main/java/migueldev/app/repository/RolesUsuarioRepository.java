package migueldev.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import migueldev.app.model.RoleUsuario;

@Repository
public interface RolesUsuarioRepository extends JpaRepository<RoleUsuario, Integer>{
	public boolean existsByUsername(String username);
}
