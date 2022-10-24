package g5.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    @GetMapping({"/","/login"})
    public String index() {
        return "index";
    }
    
    @GetMapping("/userForm")
    public String loggueado() {
        return "user-form/introduccion";
    }
    
}
