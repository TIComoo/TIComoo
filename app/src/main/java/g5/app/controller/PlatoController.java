package g5.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import g5.app.CustomException;
import g5.app.dao.PlatoRepository;
import g5.app.service.PlatoService;
import g5.app.model.Plato;

@Controller
//@RequestMapping("plato")
public class PlatoController {

    @Autowired
    PlatoService platoService=new PlatoService();
	@Autowired
    PlatoRepository platoRepository;


	@GetMapping("/platoForm")
    public String getRestaurantes(Model model) {
        model.addAttribute("platoForm", new Plato());
        model.addAttribute("platoList", platoService.getAllPlatos());
        model.addAttribute("listTab", "active");
        return "user-form/user-view";
    }
    
    @PostMapping("/crearPlato")
	public String insert(@Valid @RequestBody @ModelAttribute("platoForm")Plato plato, BindingResult result, Model model)throws Exception {
		

		if(result.hasErrors()){

			model.addAttribute("platoForm",plato);
			model.addAttribute("formTab", "active");
			

		}else{

			try {
				platoService.insert(plato);
				model.addAttribute("platoForm",new Plato());
				model.addAttribute("listTab", "active");


			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("platoForm", plato);
				model.addAttribute("formTab", "active");
				model.addAttribute("platoList", platoService.getAllPlatos());
			}
		}

		model.addAttribute("platoList", platoService.getAllPlatos());

		return "user-form/user-view";
	}

	@GetMapping("/editPlato/{id}")
	public String updateForm(Model model,@PathVariable(name="id" )long id)throws CustomException {

		Optional<Plato> platoToEdit = platoRepository.findById(id);

		model.addAttribute("platoForm", platoToEdit);
		model.addAttribute("platoList", platoService.getAllPlatos());
		model.addAttribute("formTab", "active");
		model.addAttribute("editMode", "true");

		return "user-form/user-view";
	}


    @PostMapping("/editPlato")
	public String update(@Valid @RequestBody @ModelAttribute("platoForm")Plato plato, BindingResult result, Model model) {

		if(result.hasErrors()) {
			model.addAttribute("platoForm", plato);
			model.addAttribute("editMode","true");
			model.addAttribute("formTab", "active");
			
		}else {

			try {
				platoService.update(plato);
				model.addAttribute("platoForm",new Plato());
				model.addAttribute("listTab", "active");
				


			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("platoForm", plato);
				model.addAttribute("formTab", "active");
				model.addAttribute("platoList", platoService.getAllPlatos());
				model.addAttribute("editMode","true");

			}
		}
		

	return "user-form/user-view";
	}

    @GetMapping("/deletePlato/{id}")
	public String delete(Model model, @PathVariable(name="id")Long id) {

		try {
			platoService.delete(id);;
		
		}catch (Exception e) {
		model.addAttribute("listErrorMessage",e.getMessage());
		}

		model.addAttribute("platoForm", new Plato());
		model.addAttribute("platoList", platoService.getAllPlatos());
		model.addAttribute("listTab", "active");

		return "user-form/user-view";
	}
	
}
