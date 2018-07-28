package migueldev.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hogar")
public class HogarController {
	@GetMapping("/consumoh")
	public String mostrarTablaConsumo() {
		return "hogar/consumoHogar";
	}
	@GetMapping("/seguridadh")
	public String mostrarTablaSeguridad() {
		return "hogar/seguridadHogar";
	}

}
