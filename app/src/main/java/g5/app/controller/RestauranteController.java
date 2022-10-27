package g5.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import g5.app.model.*;
import g5.app.service.*;


@Controller
//@RequestMapping("/restaurante")
public class RestauranteController {
    
    @Autowired
	RestauranteService restauranteService = new RestauranteService();
	

	@GetMapping("/hola")
	public String getUserForm(Model model) {
		return "user-form";
	}

	/* 
    @PostMapping("/insert")
	public String insert(@Valid @RequestBody @ModelAttribute("dishForm")Restaurante restaurante, BindingResult result, Model model) {

		

		if(result.hasErrors()){
			baseAttributerForRestauranteForm(model, new Restaurante());
			
		}else{

			try {
				
				restauranteService.insert(restaurante);

			} catch (Exception e) {

				throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
				//model.addAttribute("formErrorMessage",e.getMessage());
			}
		}

		return "carpeta/archivo.httml";
	}

 
	@PostMapping("/update")
	public void update(@RequestBody Map<String, Object> info) {
		try {
			JSONObject jso = new JSONObject(info);
			this.restauranteService.modify(jso);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
		}
	}

	@GetMapping("/list")
	public void list() {
		try {
			this.restauranteService.list();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
		}
	}
   

	@PostMapping("/delete")
	public void delete(@RequestBody Map<String, Object> info) {
		try {
			JSONObject jso = new JSONObject(info);
			this.restauranteService.delete(jso);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
		}
	}

	*/

	private void baseAttributerForRestauranteForm(Model model, Restaurante restaurante) {

		model.addAttribute("dishForm", restaurante);
		//model.addAttribute(activeTab,"active");
	}
    
}
