package migueldev.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import migueldev.app.model.Energia;
import migueldev.app.repository.EnergiaRepository;

@Service
public class EnergiaServiceJPA implements IEnergiaService{
	
	@Autowired
	private EnergiaRepository energiaRepo;

	@Override
	public List<Energia> mostrarEnergiaHogar(int idHogar) {
		//encontrar la lista de consumo de energia correspondiente al hogar con el id solicitado
		return energiaRepo.findByHogar_IdOrderByIdDesc(idHogar);
	}

}
