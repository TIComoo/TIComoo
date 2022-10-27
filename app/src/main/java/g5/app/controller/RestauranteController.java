package g5.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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


@RestController
@RequestMapping("/restaurante")


public class RestauranteController {
    
    @Autowired
	RestauranteService restauranteService = new RestauranteService();
	

    @PostMapping("/insert")
	public String insert(@Valid @RequestBody @ModelAttribute("dishForm")Restaurante restaurante, BindingResult result, Model model) {

			try {
				
				restauranteService.insert(restaurante);

			} catch (Exception e) {

				throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
			}
		

		return "carpeta/archivo.httml";
	}

 
    @PostMapping("/update")
	public String update(@Valid @RequestBody @ModelAttribute("dishForm")Restaurante restaurante, BindingResult result, Model model) {


			try {
				
				restauranteService.update(restaurante);

			} catch (Exception e) {

				throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
				
			}
		

		return "carpeta/archivo.html";
	}

    @PostMapping("/delete")
	public void delete(@Valid @RequestBody @ModelAttribute("dishForm")Restaurante restaurante, BindingResult result, Model model) {

		try {
            
			restauranteService.delete(restaurante);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
		}
	}

    @GetMapping("/list")
	public void list(@Valid @RequestBody @ModelAttribute("dishForm")Restaurante restaurante, BindingResult result, Model model) {

		try {
            
			restauranteService.getAllRestaurantes();

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
		}
	}

		
    
}
