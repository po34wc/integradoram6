package cl.miguelbaillon.integradoraM6.controller;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.miguelbaillon.integradoraM6.model.Transaccion;
import cl.miguelbaillon.integradoraM6.model.Usuario;
import cl.miguelbaillon.integradoraM6.service.TransaccionService;
import cl.miguelbaillon.integradoraM6.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/retiro")
public class RetiroController {
	private final UsuarioService usuarioService;
	private final TransaccionService transaccionService;
	
	public RetiroController(UsuarioService usuarioService, TransaccionService transaccionService) {
		this.usuarioService = usuarioService;
		this.transaccionService = transaccionService;
	}
	
	@GetMapping
	public ModelAndView retiroGet(Authentication authentication) {
		ModelAndView mav = new ModelAndView("gestionfondos/retiro.jsp");
		Usuario usuario = usuarioService.getByUsername(authentication.getName());
		mav.addObject("user", usuario);
		return mav;
	}
	
	@PostMapping
	public String retiroPost(Authentication authentication, HttpServletRequest req) {
		Usuario usuario = usuarioService.getByUsername(authentication.getName());
		String monto = req.getParameter("monto");
		int intMonto = Integer.parseInt(monto);
		
		int intSaldo = usuario.getSaldo();
		if (intSaldo >= intMonto && intMonto > 0) {
			usuario.setSaldo(intSaldo - intMonto);

			int id = usuarioService.editar(usuario);
			
			// id >= 0 significa que se termino correctamente el retiro
			if (id >= 0 ) {
				Transaccion transaccion = new Transaccion();
				float fltMonto = 0.0f;
				fltMonto = (float) intMonto;
				
				transaccion.setFecha(new Date());
				transaccion.setIdOrigen(usuario.getId());
				transaccion.setIdDestino(usuario.getId());
				transaccion.setTipo("RETIRO");
				transaccion.setMonto(fltMonto);
				
				transaccionService.crear(transaccion);
			}
		}
		return "redirect:/home";
	}	
}
