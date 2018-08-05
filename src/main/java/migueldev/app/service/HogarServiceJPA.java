package migueldev.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import migueldev.app.model.Hogar;
import migueldev.app.repository.HogaresRepository;

@Service
public class HogarServiceJPA implements IHogarService{

	@Autowired
	private HogaresRepository hogaresRepo;
	
	@Override
	public List<Hogar> mostrarListaHogares() {
		// TODO Auto-generated method stub
		return hogaresRepo.findAll();
	}

	@Override
	public List<Hogar> mostrarListaPorUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return hogaresRepo.findByUsuario_IdOrderByIdDesc(idUsuario);
	}

}
