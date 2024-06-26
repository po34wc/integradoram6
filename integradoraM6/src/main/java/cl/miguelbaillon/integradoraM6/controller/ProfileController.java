package cl.miguelbaillon.integradoraM6.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.miguelbaillon.integradoraM6.model.Usuario;
import cl.miguelbaillon.integradoraM6.service.UsuarioService;



@Controller
@RequestMapping("/profile")
public class ProfileController {
	private final UsuarioService userService;
	
	public ProfileController(UsuarioService userService){
		this.userService = userService;
	}
	
	@GetMapping
	public ModelAndView home(Authentication authentication) {
		ModelAndView mav = new ModelAndView("usuario/profile.jsp");
		Usuario usuario = userService.getByUsername(authentication.getName());
		mav.addObject("user",usuario);
		return mav;
	}
}
