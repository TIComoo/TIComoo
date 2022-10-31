package g5.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;

import g5.app.exception.CustomeFieldValidationException;
import g5.app.model.Cliente;
import g5.app.model.Usuario;
import g5.app.service.ClienteService;

@Controller
public class clienteController {

	@Autowired
	private ClienteService cService;
	

	@GetMapping("/signup")
	public String signup(Model model) {
		
		model.addAttribute("signup",true);
		model.addAttribute("userForm", new Cliente());
		return "user-form/user-signup";
	}
	
	@PostMapping("/signup")
	public String signupAction(@Valid @ModelAttribute("userForm")Cliente cliente, BindingResult result, ModelMap model) {
		cliente.setRol("USUARIO");
		model.addAttribute("userForm", cliente);
		model.addAttribute("signup",true);
		
		if(result.hasErrors()) {
			return "user-form/user-signup";
		}else {
			try {
				cService.guardarCliente(cliente);
			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
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
	
	private void baseAttributerForUserForm(Model model, Cliente cliente,String activeTab) {
		model.addAttribute("userForm", cliente);
		model.addAttribute("userList", cService.consultarClientes());
		model.addAttribute(activeTab,"active");
	}
	
	@GetMapping("/userForm")
	public String userForm(Model model) {
		baseAttributerForUserForm(model, new Cliente(), "listTab" );
		return "user-form/user-view";
	}
	
	@PostMapping("/userForm")
	public String createUser(@Valid @ModelAttribute("userForm")Cliente cliente, BindingResult result, Model model) {
		if(result.hasErrors()) {
			baseAttributerForUserForm(model, cliente, "formTab");
		}else {
			try {
				cService.guardarCliente(cliente);
				baseAttributerForUserForm(model, new Cliente(), "listTab" );
				
			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				baseAttributerForUserForm(model, cliente, "formTab" );
			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				baseAttributerForUserForm(model, cliente, "formTab" );
			}
		}
		return "user-form/user-view";
	}
}
	
 