package migueldev.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import migueldev.app.model.Usuario;
import migueldev.app.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService serviceUsuario;
	
	@GetMapping("/index")
	public String mostrarTablaUsuarios(Model model) {
		List<Usuario> listaUsuarios = serviceUsuario.mostrarListaUsuarios();
		model.addAttribute("usuarios", listaUsuarios);
		return "usuarios/tablaUsuarios";
	}
	
	@GetMapping("/form")
	public String formulario() {
		return "usuarios/regUsuario";
	}
	
	@PostMapping("/save")
	public String guardar(Usuario usuario, BindingResult result,  RedirectAttributes attributes) {
		if (result.hasErrors()) {
			System.out.println("Existieron errores");
			return "usuarios/regUsuario";
		}
		
		serviceUsuario.guardarUsuario(usuario);
		attributes.addFlashAttribute("mensaje", "Registrado exitosamente");
		return "redirect:/usuario/index"; 
	}

}
