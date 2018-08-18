package migueldev.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import migueldev.app.model.Energia;
import migueldev.app.service.IEnergiaService;

@Controller
@RequestMapping("/energy")
public class EnergiaController {
	
	@Autowired
	private IEnergiaService serviceEnergia;
	
	@PostMapping("/energyhogar")
	public String energiaHogar(@RequestParam("idHogar") int idHogar, Model model) {
		//Mostrar la lista de datos del consumo de energia
		System.out.println(idHogar);
		List<Energia> listaEnergia = serviceEnergia.mostrarEnergiaHogar(idHogar);
		System.out.println(listaEnergia);
		model.addAttribute("energia", listaEnergia);
		return "energia/tablaEnergia";
	}

}
