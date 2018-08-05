package migueldev.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import migueldev.app.model.Hogar;

@Repository
public interface HogaresRepository extends JpaRepository<Hogar, Integer>{
	//select * from Hogares where idUsuarios = ? order by id desc
	public List<Hogar> findByUsuario_IdOrderByIdDesc(int idUsuario);

}
