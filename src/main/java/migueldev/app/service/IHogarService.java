package migueldev.app.service;

import java.util.List;

import migueldev.app.model.Hogar;
import migueldev.app.model.Usuario;

public interface IHogarService {
	List<Hogar> mostrarListaHogares();
	List<Hogar> mostrarListaPorUsuario(int idUsuario);
	List<Hogar> mostrarListaPorUsername(String nombreUsuario);
	void guardarHogar(Hogar hogar);
	void eliminarHogar(int idHogar);
	Hogar mostrarHogar(int idHogar);
	
}
