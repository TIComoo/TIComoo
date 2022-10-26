package g5.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import g5.app.model.Usuario;
import g5.app.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioService service;

    @GetMapping({"/","/login"})
    public String index() {
        return "index";
    }
    
    @GetMapping("/userForm")
    public String loggueado() {
    	String url = "user-form/";
    	Usuario usr = null;
    	
    	try {
			usr = service.getLoggedUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	switch(usr.getClass().getSimpleName()) {
    	case "Usuario":
    		url += "usuario";
    		break;
    	case "Administrador":
    		url += "admin";
    		break;
    	case "Rider":
    		url += "rider";
    		break;
    	}
    	
        return url;
    }
    
}
