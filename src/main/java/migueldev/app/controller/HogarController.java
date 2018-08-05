package migueldev.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import migueldev.app.model.Hogar;
import migueldev.app.service.IHogarService;

@Controller
@RequestMapping("/hogar")
public class HogarController {
	@Autowired
	private IHogarService serviceHogar;
	
	@GetMapping("/index")
	public String mostrarTablaHogar(Model model) {
		List<Hogar> listaHogares = serviceHogar.mostrarListaHogares();
		model.addAttribute("hogares", listaHogares);
		return "hogar/hogar";
	}
	
	@GetMapping("/hogarusuario/{id}")
	public String mostrarHogarUsuario(@PathVariable("id") int idUsuario, Model model) {
		List<Hogar> listaHogaresU = serviceHogar.mostrarListaPorUsuario(idUsuario);
		model.addAttribute("hogares", listaHogaresU);
		System.out.println("listaHogaresU: "+listaHogaresU);
		return "hogar/hogar";
	}
	
	@GetMapping("/consumoh")
	public String mostrarTablaConsumo() {
		return "hogar/consumoHogar";
	}
	@GetMapping("/seguridadh")
	public String mostrarTablaSeguridad() {
		return "hogar/seguridadHogar";
	}

}
