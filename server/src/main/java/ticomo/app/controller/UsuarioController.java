package ticomo.app.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ticomo.app.exception.UsernameNotFound;
import ticomo.app.model.Usuario;
import ticomo.app.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService service;

	@GetMapping({ "/", "/login" })
	public String index() {
		return "index";
	}

	@PostMapping("/leerUsuarioPorEmail")
	public Usuario leerClientePorEmail(@RequestBody String email) throws UsernameNotFound, JSONException {
		JSONObject jso = new JSONObject(email);

		Usuario usuario = this.service.buscarPorEmail(jso.getString("email"));
		
		return usuario;
	}
	@GetMapping("/users")
	public String loggueado() {
		return "users/" + service.getLoggedUserRol().toLowerCase(); // cambiar redirección a las views
	}

}
