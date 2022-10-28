package g5.app;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("carta")
public class CartaController {

    @Autowired
    CartaService cartaService=new CartaService();

    @GetMapping("/insert")
	public String insertForm(Model model) {
		
		model.addAttribute("cartaForm", new Carta());
		
		return "carpeta/archivo.httml";
	}

    @PostMapping("/insert")
	public String insert(@Valid @RequestBody @ModelAttribute("cartaForm")Carta carta, BindingResult result, Model model) {

		

		if(result.hasErrors()){
			baseAttributerForPlatoForm(model, new Carta());
			
		}else{

			try {
				
				cartaService.insert(carta);

			} catch (Exception e) {

				throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
				//model.addAttribute("formErrorMessage",e.getMessage());
			}
		}

		return "carpeta/archivo.httml";
	}

    @GetMapping("/delete/{id}")
	public void delete(Model model, @PathVariable(name="id")Long id) {

		try {
            
			cartaService.delete(id);

		} catch (Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
		}
	}

    private void baseAttributerForPlatoForm(Model model, Carta carta) {

		model.addAttribute("cartaForm", carta);
		//model.addAttribute(activeTab,"active");
	}
    
}
