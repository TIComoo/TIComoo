package ticomo.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ticomo.app.dao.PlatoRepository;
import ticomo.app.exception.CustomException;
import ticomo.app.model.Carta;
import ticomo.app.model.Plato;
import ticomo.app.service.CartaService;
import ticomo.app.service.PlatoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/plato")
public class PlatoController {

	@Autowired
	PlatoService platoService = new PlatoService();
    @Autowired
	CartaService cartaService = new CartaService();
	@Autowired
	PlatoRepository platoRepository;

	@GetMapping("/platos")
	public List<Plato> getPlato() {
		
		List<Carta> cartas = cartaService.getAllCartas();
		List<Plato> platos = platoService.getAllPlatos();
		Carta auxC = new Carta();
		List<Plato> aux = new ArrayList<>();
		for(int i=0;i<cartas.size();i++){
			if(cartas.get(i).getCartaElegida()!=null){
				auxC=cartas.get(i);
			}
		}

		for(int i=0;i<platos.size();i++){
			if(auxC.getCartaElegida().equalsIgnoreCase(platos.get(i).getNombreRestaurante())){
				aux.add(platos.get(i));
			}
		}

		return aux;

	}

	
	@GetMapping("/todos")
	public List<Plato> getPlatosEleccion() {
		

		return platoService.getAllPlatos();

	}

	@GetMapping("/platoForm")
	public String getRestaurantes(Model model) {
		model.addAttribute("platoForm", new Plato());
		model.addAttribute("platoList", platoService.getAllPlatos());
		model.addAttribute("listTab", "active");
		return "plato-form/plato-view";
	}

	@PostMapping("/crearPlato")
	public String insert(@Valid @RequestBody @ModelAttribute("platoForm") Plato plato, BindingResult result,
			Model model) throws Exception {

		if (result.hasErrors()) {

			model.addAttribute("platoForm", plato);
			model.addAttribute("formTab", "active");

		} else {

			try {
				platoService.insert(plato);
				model.addAttribute("platoForm", new Plato());
				model.addAttribute("listTab", "active");

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("platoForm", plato);
				model.addAttribute("formTab", "active");
				model.addAttribute("platoList", platoService.getAllPlatos());
			}
		}

		model.addAttribute("platoList", platoService.getAllPlatos());

		return "plato-form/plato-view";
	}

	@GetMapping("/editPlato/{id}")
	public String updateForm(Model model, @PathVariable(name = "id") long id) throws CustomException {

		Optional<Plato> platoToEdit = platoRepository.findById(id);

		model.addAttribute("platoForm", platoToEdit);
		model.addAttribute("platoList", platoService.getAllPlatos());
		model.addAttribute("formTab", "active");
		model.addAttribute("editMode", "true");

		return "plato-form/plato-view";
	}

	@PostMapping("/editPlato")
	public String update(@Valid @RequestBody @ModelAttribute("platoForm") Plato plato, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			model.addAttribute("platoForm", plato);
			model.addAttribute("editMode", "true");
			model.addAttribute("formTab", "active");

		} else {

			try {
				platoService.update(plato);
				model.addAttribute("platoForm", new Plato());
				model.addAttribute("listTab", "active");

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("platoForm", plato);
				model.addAttribute("formTab", "active");
				model.addAttribute("platoList", platoService.getAllPlatos());
				model.addAttribute("editMode", "true");

			}
		}

		model.addAttribute("platoList", platoService.getAllPlatos());

		return "plato-form/plato-view";
	}

	@GetMapping("/deletePlato/{id}")
	public String delete(Model model, @PathVariable(name = "id") Long id) {

		try {
			platoService.delete(id);

		} catch (Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}

		model.addAttribute("platoForm", new Plato());
		model.addAttribute("platoList", platoService.getAllPlatos());
		model.addAttribute("listTab", "active");

		return "plato-form/plato-view";
	}

}
