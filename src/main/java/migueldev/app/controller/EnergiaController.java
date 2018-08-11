package migueldev.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import migueldev.app.model.Energia;
import migueldev.app.service.IEnergiaService;

@Controller
@RequestMapping("/energy")
public class EnergiaController {
	
	@Autowired
	private IEnergiaService serviceEnergia;
	
	@GetMapping("/energyhogar/{id}")
	public String energiaHogar(@PathVariable("id") int idHogar, Model model) {
		List<Energia> listaEnergia = serviceEnergia.mostrarEnergiaHogar(idHogar);
		model.addAttribute("energia", listaEnergia);
		return "energia/tablaEnergia";
	}

}
