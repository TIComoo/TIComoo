package g5.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import g5.app.service.UsuarioService;

//@RestController
//@RequestMapping("/user") a lo mejor habría que poner algo así
@Controller
public class UsuarioController {

	@Autowired
	UsuarioService service;

	@GetMapping({ "/", "/login" })
	public String index() {
		return "index";
	}
	
	// mirar como hacer bien el mapeo

	@GetMapping("/users")
	public String loggueado() {
		return "users/" + service.getLoggedUserRol().toLowerCase();
	}

}
