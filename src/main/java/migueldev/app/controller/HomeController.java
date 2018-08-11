package migueldev.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	/*@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome() {
		return "home";
	}*/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal() {
		return "home";
	}
	
	@RequestMapping(value="/loginUser", method=RequestMethod.GET)
	public String mostrarLogin() {
		return "login";
	}
	
	
}
