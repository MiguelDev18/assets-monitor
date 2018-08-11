package migueldev.app.service;

import java.util.List;

import migueldev.app.model.Energia;

public interface IEnergiaService {
	List<Energia> mostrarEnergiaHogar(int idHogar);
}
