package cl.miguelbaillon.integradoraM6.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.miguelbaillon.integradoraM6.model.Usuario;
import cl.miguelbaillon.integradoraM6.service.UsuarioService;


@Controller
@RequestMapping("/home")
public class HomeController {
	private final UsuarioService usuarioService;
	
	public HomeController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public ModelAndView home(Authentication authentication) {
		ModelAndView mav = new ModelAndView("home.jsp");
		Usuario usuario = usuarioService.getByUsername(authentication.getName());
		mav.addObject("user", usuario);
		return mav;
	}
}
