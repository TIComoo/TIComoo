package g5.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import g5.app.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService service;

	@GetMapping({ "/", "/login" })
	public String index() {
		return "index";
	}

	@GetMapping("/users")
	public String loggueado() {
		return "users/" + service.getLoggedUserRol().toLowerCase();
	}

}
