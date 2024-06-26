package cl.miguelbaillon.integradoraM6.controller;

import java.util.Date;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.miguelbaillon.integradoraM6.dao.CuentaDao;
import cl.miguelbaillon.integradoraM6.model.Cuenta;
import cl.miguelbaillon.integradoraM6.model.Transaccion;
import cl.miguelbaillon.integradoraM6.model.Usuario;
import cl.miguelbaillon.integradoraM6.service.TransaccionService;
import cl.miguelbaillon.integradoraM6.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/transferencia")
public class TransferenciaController {
	private final UsuarioService usuarioService;
	private final TransaccionService transaccionService;
	private final CuentaDao cuentaDao;
	
	public TransferenciaController(UsuarioService usuarioService, TransaccionService transaccionService,
			                       CuentaDao cuentaDao) {
		this.usuarioService = usuarioService;
		this.transaccionService = transaccionService;
		this.cuentaDao = cuentaDao;
	}
	
	@GetMapping
	public ModelAndView transferenciaGet(Authentication authentication) {
		ModelAndView mav = new ModelAndView("gestionfondos/transferencia.jsp");
		Usuario usuario = usuarioService.getByUsername(authentication.getName());
		mav.addObject("user", usuario);
		
		List<Cuenta> cuenta = cuentaDao.obtenerListadoCuentas(usuario.getId());
		mav.addObject("listaCuentas", cuenta);
		
		return mav;
	}
	
	@PostMapping
	public String transferenciaPost(Authentication authentication, HttpServletRequest req) {
		Usuario usuario = usuarioService.getByUsername(authentication.getName());
		String monto = req.getParameter("monto");
		String cuentaid = req.getParameter("cuentaid");
		int intMonto = Integer.parseInt(monto);
		int intCuentaid = Integer.parseInt(cuentaid);
		
		int intSaldo = usuario.getSaldo();
		if (intMonto > 0 && intMonto <= intSaldo && intCuentaid > 0) {
			usuario.setSaldo(intSaldo - intMonto);
		
			int idEd = usuarioService.editar(usuario);
			int idAc = usuarioService.actualizaSaldo(intCuentaid, intMonto);
			
			// id >= 0 significa que se termino correctamente la transferencia
			
			if (idEd >= 0 && idAc >= 0) {
				Transaccion transaccion = new Transaccion();
				float fltMonto = 0.0f;
				fltMonto = (float) intMonto;
				
				transaccion.setFecha(new Date());
				transaccion.setIdOrigen(usuario.getId());
				transaccion.setIdDestino(intCuentaid);
				transaccion.setTipo("TRANSFERENCIA");
				transaccion.setMonto(fltMonto);
				
				transaccionService.crear(transaccion);
			}
		}
		return "redirect:/home";
	}	
}
