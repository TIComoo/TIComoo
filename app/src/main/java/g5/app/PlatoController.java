package g5.app;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("plato")
public class PlatoController {

    @Autowired
    PlatoService platoService=new PlatoService();

	@GetMapping("/insert")
	public String insertForm(Model model) {
		
		baseAttributerForPlatoForm(model, new Plato());
		
		return "carpeta/archivo.httml";
	}
    
    @PostMapping("/insert")
	public String insert(@Valid @RequestBody @ModelAttribute("dishForm")Plato plato, BindingResult result, Model model) {

		

		if(result.hasErrors()){
			baseAttributerForPlatoForm(model, new Plato());
			
		}else{

			try {
				
				platoService.insert(plato);

			} catch (Exception e) {

				throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
				//model.addAttribute("formErrorMessage",e.getMessage());
			}
		}

		return "carpeta/archivo.httml";
	}

	@GetMapping("/update/{id}")
	public String updateForm(Model model,@PathVariable(name="id" )long id)throws CustomException {

		Plato platoToUpdate=platoService.getPlatorById(id);
		
		baseAttributerForPlatoForm(model, platoToUpdate);
		model.addAttribute("editMode", "true");
		
		return "carpeta/archivo.httml";
	}


    @PostMapping("/update")
	public String update(@Valid @RequestBody @ModelAttribute("dishForm")Plato plato, BindingResult result, Model model) {

		

		if(result.hasErrors()){
			baseAttributerForPlatoForm(model, plato);
			model.addAttribute("editMode", "true");
			
		}else{

			try {
				
				platoService.update(plato);

			} catch (Exception e) {

				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("editMode", "true");
				throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
				
			}
		}

		return "carpeta/archivo.httml";
	}

    @GetMapping("/delete/{id}")
	public void delete(Model model, @PathVariable(name="id")Long id) {

		try {
            
			platoService.delete(id);

		} catch (Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
		}
	}
	
	private void baseAttributerForPlatoForm(Model model, Plato plato) {

		model.addAttribute("dishForm", plato);
		//model.addAttribute(activeTab,"active");
	}
}
