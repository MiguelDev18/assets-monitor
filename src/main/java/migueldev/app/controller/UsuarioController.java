package migueldev.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import migueldev.app.model.RoleUsuario;
import migueldev.app.model.Usuario;
import migueldev.app.service.IHogarService;
import migueldev.app.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService serviceUsuario;
	
	@GetMapping(value="/welcome")
	public String mostrarBienvenida() {
		return "bienvenida";
	}
	
	@GetMapping(value="/logout")
	public String cerrarSesion(HttpServletRequest request) {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/index")
	public String mostrarTablaUsuarios(Model model) {
		List<Usuario> listaUsuarios = serviceUsuario.mostrarListaUsuarios();
		model.addAttribute("usuarios", listaUsuarios);
		return "usuarios/tablaUsuarios";
	}
	
	@GetMapping("/form")
	public String nuevoUsuario(@ModelAttribute Usuario usuario) {
		return "usuarios/regUsuario";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Usuario usuario, BindingResult result,  RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			//se muestra un mensaje de error en la consola si el registro falla
			System.out.println("Existieron errores");
			return "usuarios/regUsuario";
		}
		
		//concatenar la cadena "{noop}" con la contraseña 
		//para que se reconozca como no encriptada
		if(!usuario.getPassword().startsWith("{noop}"))
			usuario.setPassword("{noop}"+usuario.getPassword());
		
		System.out.println("usuario (controller): " + usuario);
		
		serviceUsuario.guardarUsuario(usuario);
		
		//Se crea y se guarda el role de usuario (si no existe)
		if (!serviceUsuario.existeRole(usuario.getUsername())) {
			RoleUsuario role = new RoleUsuario();
			role.setRole("usuario");
			role.setUsername(usuario.getUsername());
			System.out.println("role (controller): " + role);
			serviceUsuario.guardarRole(role);
		}
		attributes.addFlashAttribute("mensaje", "Registrado exitosamente");
		return "redirect:/usuario/index"; 
	}
	
	@PostMapping("/edit")
	public String editarUsuario(@RequestParam("idUsuario") int idUsuario, Model model) {
		Usuario usuario = serviceUsuario.mostrarUsuario(idUsuario);
		model.addAttribute("usuario", usuario);
		return "usuarios/regUsuario";
	}
	
	/*
	@PostMapping("/delete")
	public String eliminarUsuario(@RequestParam("idUsuario") int idUsuario, RedirectAttributes attributes) {
		serviceUsuario.eliminarUsuario(idUsuario);
		attributes.addFlashAttribute("mensaje", "Usuario eliminado exitosamente");
		return "redirect:/usuario/index";
	}
	*/
	
	/*
	
	@GetMapping("/edit/{id}")
	public String editarUsuario(@PathVariable("id") int idUsuario, Model model) {
		Usuario usuario = serviceUsuario.mostrarUsuario(idUsuario);
		model.addAttribute("usuario", usuario);
		return "usuarios/regUsuario";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminarUsuario(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {
		serviceUsuario.eliminarUsuario(idUsuario);
		attributes.addFlashAttribute("mensaje", "Usuario eliminado exitosamente");
		return "redirect:/usuario/index";
	}
*/
}
