package migueldev.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import migueldev.app.model.Hogar;
import migueldev.app.model.Usuario;
import migueldev.app.service.IHogarService;
import migueldev.app.service.IUsuarioService;

@Controller
@RequestMapping("/hogar")
public class HogarController {
	private int idUsuario;
	
	@Autowired
	private IHogarService serviceHogar;
	
	@Autowired
	private IUsuarioService seviceUsuario;
	
	/*
	@GetMapping("/index")
	public String mostrarTablaHogar(Model model) {
		List<Hogar> listaHogares = serviceHogar.mostrarListaHogares();
		model.addAttribute("hogares", listaHogares);
		return "hogar/hogar";
	}*/
	/*
	@GetMapping("/hogarusuario/{id}")
	public String mostrarHogarUsuario(@PathVariable("id") int idUsuario, Model model) {
		this.idUsuario = idUsuario;
		//model.addAttribute("idUsuario", idUsuario);
		List<Hogar> listaHogaresU = serviceHogar.mostrarListaPorUsuario(idUsuario);
		model.addAttribute("hogares", listaHogaresU);
		System.out.println("listaHogaresU: "+listaHogaresU);
		return "hogar/tablaHogar";
	}*/
	
	@PostMapping("/hogarxusuario")
	public String mostrarHogarUsario(@RequestParam("idUsuario") int idUsuario, Model model) {
		this.idUsuario = idUsuario;
		List<Hogar> listaHogaresU = serviceHogar.mostrarListaPorUsuario(idUsuario);
		model.addAttribute("hogares", listaHogaresU);
		return "hogar/tablaHogar";
	}
	
	
	
	@GetMapping("/hogarusuario")
	public String mostrarHogarUsername(Authentication authentication, Model model) {
		//Obtener el usuario a partir del username
		Usuario usuario = seviceUsuario.mostrarUsuario(authentication.getName());
		this.idUsuario = usuario.getId();
		System.out.println(idUsuario);
		
		List<Hogar> listaHogares = serviceHogar.mostrarListaPorUsername(authentication.getName());
		model.addAttribute("hogares", listaHogares);
		System.out.println(authentication.getName());
		return "hogar/tablaHogar";
	}
	
	@GetMapping("/form")
	public String nuevoHogar(@ModelAttribute Hogar hogar) {
		return "hogar/regHogar";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Hogar hogar, BindingResult result,  RedirectAttributes attributes) {
		if (result.hasErrors()) {
			//se muestra un mensaje de error en la consola si el registro de los datos falla
			System.out.println("Existieron errores");
			return "hogar/regHogar";
		}
		System.out.println("hogar (controller):" + hogar);
		serviceHogar.guardarHogar(hogar);
		attributes.addFlashAttribute("mensaje", "Registrado exitosamente");
		return "redirect:/hogar/hogarusuario/"; 
	}
	
	
	@PostMapping("/edit")
	public String editarHogar(@RequestParam("idHogar") int idHogar, Model model) {
		Hogar hogar = serviceHogar.mostrarHogar(idHogar);
		model.addAttribute("hogar", hogar);
		return "hogar/regHogar";
	}
	
	@PostMapping("/delete")
	public String eliminarHogar(@RequestParam("idHogar") int idHogar, RedirectAttributes attributes) {
		serviceHogar.eliminarHogar(idHogar);
		attributes.addFlashAttribute("mensaje", "Hogar eliminado exitosamente");
		return "redirect:/hogar/hogarusuario/";
	}
	
	/*	
	@GetMapping("/consumoh")
	public String mostrarTablaConsumo() {
		return "hogar/consumoHogar";
	}
	@GetMapping("/seguridadh")
	public String mostrarTablaSeguridad() {
		return "hogar/seguridadHogar";
	}
	
	@ModelAttribute("idUsuario")
	public int getIdUsuario(){
		return idUsuario;
	}*/

}
