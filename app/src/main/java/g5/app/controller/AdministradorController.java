package g5.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import g5.app.model.Administrador;
import g5.app.service.AdministradorService;

@RestController
@RequestMapping("/admin")
public class AdministradorController {

    @Autowired
    private  AdministradorService adminService;

    @PostMapping(value = "/guardarAdmin")
    public void crearAdmin(@RequestBody @ModelAttribute("Administrador") Administrador admin ) {
  
        this.adminService.guardarAdministrador(admin);
    }

    
    @GetMapping(value = "/leerAdminPorEmail", produces = "application/json")
    @ResponseBody
    public Administrador leerAdminPorEmail(@RequestHeader String email){
        Administrador admin = this.adminService.leerAdminPorEmail(email);
        return admin;

    }
    @GetMapping(value = "/leerAdministradores", produces = "application/json")
    @ResponseBody
    public List<Administrador> leerAdministradores(){
       List<Administrador> administradores = this.adminService.leerAdministradores();
       return administradores;
    }
    
}
