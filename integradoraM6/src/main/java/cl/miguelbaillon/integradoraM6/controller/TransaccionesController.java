package cl.miguelbaillon.integradoraM6.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.miguelbaillon.integradoraM6.model.Historial;
import cl.miguelbaillon.integradoraM6.model.Usuario;
import cl.miguelbaillon.integradoraM6.service.HistorialService;
import cl.miguelbaillon.integradoraM6.service.TransaccionService;
import cl.miguelbaillon.integradoraM6.service.UsuarioService;

@Controller
@RequestMapping("/transacciones")
public class TransaccionesController {
	private final UsuarioService usuarioService;
	private final TransaccionService transaccionService;
	private final HistorialService historialService;
	
	public TransaccionesController(UsuarioService usuarioService, TransaccionService transaccionService,
			                       HistorialService historialService) {
		this.usuarioService = usuarioService;
		this.transaccionService = transaccionService;
		this.historialService = historialService;
	}
	
	@GetMapping
	public ModelAndView depositoGet(Authentication authentication) {
		ModelAndView mav = new ModelAndView("gestionfondos/transacciones.jsp");
		Usuario usuario = usuarioService.getByUsername(authentication.getName());
		int id = usuario.getId();
		
		List<Historial> listado = historialService.obtenerListadoTransacciones(id);
		
		mav.addObject("historial", listado);
		return mav;
	}
}