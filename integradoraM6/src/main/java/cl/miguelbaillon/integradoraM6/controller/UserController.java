package cl.miguelbaillon.integradoraM6.controller;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.miguelbaillon.integradoraM6.model.Usuario;
import cl.miguelbaillon.integradoraM6.service.UsuarioService;


@Controller
@RequestMapping("/usuario")
public class UserController {
	
	private final UsuarioService usuarioService;
	
	public UserController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_MANAGER"})
	@GetMapping("/form")
	public ModelAndView formGet(@RequestParam(defaultValue = "false") boolean creado ) {		
		ModelAndView mav = new ModelAndView("usuario/usuario-form.jsp");
		mav.addObject("creado", creado);
		return mav;
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_MANAGER"})
	@PostMapping("/form")
	public String formPost(@ModelAttribute Usuario usuario) {
		int id = usuarioService.crear(usuario);
		int resultado = (id > 0) ? 1 : 0;
		return "redirect:/usuario/form?creado=" + resultado;
	}
	
	@GetMapping("/listado")
	public ModelAndView listadoGet() {	
		ModelAndView mav = new ModelAndView("usuario/usuario-listado.jsp");
		List<Usuario> list = usuarioService.listado();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/{id}")
	public ModelAndView usuarioGet(@PathVariable int id) {	
		ModelAndView mav = new ModelAndView("usuario/usuario-muestra.jsp");
		Usuario usuario = usuarioService.getById(id);
		mav.addObject("user", usuario);
		return mav;
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_MANAGER"})
	@GetMapping("/{id}/edit")
	public ModelAndView usuarioEditGet(@PathVariable int id) {	
		ModelAndView mav = new ModelAndView("usuario/usuario-muestra-edit.jsp");
		Usuario usuario = usuarioService.getById(id);
		mav.addObject("user", usuario);
		return mav;
	}
	
	@Secured({"ROLE_ADMIN","ROLE_MANAGER"})
	@PostMapping("/edit")
	public String usuarioEditPost(@ModelAttribute Usuario usuario) {	
		usuarioService.editar(usuario);
		return "redirect:/usuario/" + usuario.getId();
	}
}
