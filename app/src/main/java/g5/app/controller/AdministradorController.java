package g5.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import g5.app.exception.CustomeFieldValidationException;
import g5.app.model.Administrador;
import g5.app.model.Rider;
import g5.app.service.AdministradorService;
import g5.app.service.RiderService;

@Controller
@RequestMapping("/admin")
public class AdministradorController {

    


    @Autowired
    private  AdministradorService adminService;
    @Autowired
    private  RiderService riderService;	

	@GetMapping("/crearAdmin")
	public String crearAdmin(Model model) {
		
		model.addAttribute("crearAdmin",true);
		model.addAttribute("adminForm", new Administrador());
		model.addAttribute("crearRider",true);
		model.addAttribute("riderForm", new Rider());
		return "user-form/admin-view";
	}
	
	
	@PostMapping("/crearAdmin")
	public String signupAction(@Valid @ModelAttribute("adminForm")Administrador admin, BindingResult result, ModelMap model) {
		admin.setRol("ADMIN");
		model.addAttribute("adminForm", admin);
		model.addAttribute("crearAdmin",true);
		
		if(result.hasErrors()) {
			return "user-form/admin-view";
		}else {
			try {
				adminService.guardarAdministrador(admin);

			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
			}
		}
		return index();
	}
	
	@PostMapping("/crearRider")
	public String signupAction(@Valid @ModelAttribute("riderForm") Rider rider, BindingResult result, ModelMap model) {
		rider.setRol("RIDER");
		model.addAttribute("riderForm", rider);
		model.addAttribute("crearRider",true);
		
		if(result.hasErrors()) {
			return "user-form/admin-view";
		}else {
			try {
				riderService.guardarRider(rider);

			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
			}
		}
		return index();
	}
	
	@GetMapping({"/","/login"})
    public String index() {
        return "index";
    }
	
	private void baseAdminForm(Model model, Administrador admin,String activeTab) {
		model.addAttribute("adminForm", admin);
		model.addAttribute(activeTab,"active");
	}
	
	@GetMapping("/adminForm")
	public String adminForm(Model model) {
		baseAdminForm(model, new Administrador(), "listTab" );
		return "user-form/admin-view";
	}
	
	private void baseRiderForm(Model model, Rider rider,String activeTab) {
		model.addAttribute("riderForm", rider);
		model.addAttribute(activeTab,"active");
	}
	
	@GetMapping("/riderForm")
	public String riderForm(Model model) {
		baseRiderForm(model, new Rider(), "listTab" );
		return "user-form/admin-view";
	}
    
}