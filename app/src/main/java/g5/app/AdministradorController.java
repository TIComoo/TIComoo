package g5.app;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdministradorController {

    @Autowired
    private  AdministradorService adminService;

    @PostMapping(value = "/crearAdmin")
    public void crearAdmin(@RequestBody @ModelAttribute("Administrador") Administrador admin ) {
  
        this.adminService.crearAdministrador(admin);
    }
    
}
