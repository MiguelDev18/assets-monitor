package migueldev.app.service;

import java.util.List;

import migueldev.app.model.Hogar;

public interface IHogarService {
	List<Hogar> mostrarListaHogares();
	List<Hogar> mostrarListaPorUsuario(int idUsuario);
}
