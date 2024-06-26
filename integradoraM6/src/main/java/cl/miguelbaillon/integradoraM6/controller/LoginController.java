package cl.miguelbaillon.integradoraM6.controller;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String login(Model model, @RequestParam(name="error", required = false) String error) {
		model.addAttribute("error", error);
		
//		String hashPass = new BCryptPasswordEncoder().encode("12345");
//		hashPass = hashPass + "-";
		
		return "login.jsp";
	}
}
