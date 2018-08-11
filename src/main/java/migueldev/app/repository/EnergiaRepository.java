package migueldev.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import migueldev.app.model.Energia;

@Repository
public interface EnergiaRepository extends JpaRepository<Energia, Integer>{
	public List<Energia> findByHogar_IdOrderByIdDesc(int idHogar);
}
