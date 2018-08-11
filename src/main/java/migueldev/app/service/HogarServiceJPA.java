package migueldev.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import migueldev.app.model.Hogar;
import migueldev.app.model.Usuario;
import migueldev.app.repository.HogaresRepository;

@Service
public class HogarServiceJPA implements IHogarService{

	@Autowired
	private HogaresRepository hogaresRepo;
	
	@Override
	public List<Hogar> mostrarListaHogares() {
		
		return hogaresRepo.findAll();
	}

	@Override
	public List<Hogar> mostrarListaPorUsuario(int idUsuario) {
		
		return hogaresRepo.findByUsuario_IdOrderByIdDesc(idUsuario);
	}

	@Override
	public void guardarHogar(Hogar hogar) {
		hogaresRepo.save(hogar);
		
	}

	@Override
	public void eliminarHogar(int idHogar) {
		hogaresRepo.deleteById(idHogar);		
	}

	@Override
	public Hogar mostrarHogar(int idHogar) {
		Optional<Hogar> hogar = hogaresRepo.findById(idHogar);
		if(hogar.isPresent())
			return hogar.get();
		return null;
	}

	@Override
	public List<Hogar> mostrarListaPorUsername(String nombreUsuario) {
		// TODO Auto-generated method stub
		return hogaresRepo.findByUsuario_UsernameOrderByIdDesc(nombreUsuario);
	}

}
