<<<<<<< HEAD:app/src/main/java/g5/app/controller/RestauranteController.java
package g5.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
=======
package ticomo.app.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

>>>>>>> main:server/src/main/java/ticomo/app/controller/RestauranteController.java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

<<<<<<< HEAD:app/src/main/java/g5/app/controller/RestauranteController.java
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import g5.app.model.*;
import g5.app.service.*;
import g5.app.dao.*;



@Controller


public class RestauranteController {
    
    @Autowired
	RestauranteService restauranteService;
    @Autowired
	RestauranteRepository restauranteRepository;

	

	@GetMapping("/restauranteForm")

=======
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ticomo.app.dao.RestauranteRepository;
import ticomo.app.model.Restaurante;
import ticomo.app.service.RestauranteService;



@RestController
@RequestMapping("restaurantes")
public class RestauranteController {

	@Autowired
	RestauranteService restauranteService;
	
	@Autowired
	RestauranteRepository restauranteRepository;
	
	
	@GetMapping("/restauranteForm")
	public List<Restaurante> getAllRestaurantes() {
		
		return restauranteService.getAllRestaurantes();


	}
	

	
	@PostMapping("/createRestaurante")
	public void postCrearRestaurante(@RequestBody Map<String, Object> info) throws Exception {

		try {
			JSONObject jso = new JSONObject(info);
			Restaurante restaurante = new Restaurante();
			restaurante.setNombre(jso.getString("nombre"));
			restaurante.setRazon(jso.getString("razon"));
			restaurante.setCIF(jso.getString("CIF"));
			restaurante.setDireccion(jso.getString("direccion"));
			restaurante.setTlf(jso.getString("tlf"));
			restaurante.setCategoria(jso.getString("categoria"));
			restaurante.setEmail(jso.getString("email"));
			
			restauranteService.createRestaurante(restaurante);


		} catch (ResponseStatusException e) {
			throw e;
		}
		
	}

	
	@PostMapping("/editRestaurante")
	public void postEditarRestaurante(@RequestBody Map<String, Object> info) throws Exception {

		try {
			JSONObject jso = new JSONObject(info);
			Restaurante restaurante = new Restaurante();
			restaurante.setNombre(jso.getString("nombre"));
			restaurante.setRazon(jso.getString("razon"));
			restaurante.setCIF(jso.getString("CIF"));
			restaurante.setDireccion(jso.getString("direccion"));
			restaurante.setTlf(jso.getString("tlf"));
			restaurante.setCategoria(jso.getString("categoria"));
			restaurante.setEmail(jso.getString("email"));
			
			restauranteService.editarRestaurante(restaurante);


		} catch (ResponseStatusException e) {
			throw e;
		}
	}
	

	@GetMapping("/deleteRestaurante/{nombre}")
		public void getEliminarrRestaurante(@PathVariable String nombre) {
			try {
				this.restauranteService.eliminarRestaurante(nombre);
			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
			}
		}
	/*
	@GetMapping("/restauranteForm")
>>>>>>> main:server/src/main/java/ticomo/app/controller/RestauranteController.java
	public String getRestaurantes(Model model) {

		model.addAttribute("restauranteForm", new Restaurante());
		model.addAttribute("restauranteList", restauranteService.getAllRestaurantes());
		model.addAttribute("listTab", "active");

		return "restaurante-form/restaurante-view";
	}
<<<<<<< HEAD:app/src/main/java/g5/app/controller/RestauranteController.java
	

	@PostMapping("/crearRestaurante")
	
	public String postCrearRestaurante(@Valid @RequestBody @ModelAttribute("restauranteForm")Restaurante restaurante, BindingResult result, Model model) {

		if(result.hasErrors()){

			model.addAttribute("restauranteForm",restaurante);
			model.addAttribute("formTab", "active");

		}else{

			try {
				restauranteService.createRestaurante(restaurante);
				model.addAttribute("restauranteForm",new Restaurante());
				model.addAttribute("listTab", "active");


			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
=======

	@PostMapping("/crearRestaurante")
	public String postCrearRestaurante(@RequestBody @ModelAttribute("restauranteForm") Restaurante restaurante,
			BindingResult result, Model model) {

		if (result.hasErrors()) {

			model.addAttribute("restauranteForm", restaurante);
			model.addAttribute("formTab", "active");

		} else {

			try {
				restauranteService.createRestaurante(restaurante);
				model.addAttribute("restauranteForm", new Restaurante());
				model.addAttribute("listTab", "active");

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
>>>>>>> main:server/src/main/java/ticomo/app/controller/RestauranteController.java
				model.addAttribute("restauranteForm", restaurante);
				model.addAttribute("formTab", "active");
				model.addAttribute("restauranteList", restauranteService.getAllRestaurantes());
			}
		}

		model.addAttribute("restauranteList", restauranteService.getAllRestaurantes());

		return "restaurante-form/restaurante-view";
	}

<<<<<<< HEAD:app/src/main/java/g5/app/controller/RestauranteController.java

	@GetMapping("/editRestaurante/{nombre}")
	public String getEditarRestaurante(Model model, @PathVariable(name ="nombre")String nombre)throws Exception{

=======
	@GetMapping("/editRestaurante/{nombre}")
	public String getEditarRestaurante(Model model, @PathVariable(name = "nombre") String nombre) throws Exception {
>>>>>>> main:server/src/main/java/ticomo/app/controller/RestauranteController.java

		Optional<Restaurante> restauranteToEdit = restauranteRepository.findById(nombre);

		model.addAttribute("restauranteForm", restauranteToEdit);
		model.addAttribute("restauranteList", restauranteService.getAllRestaurantes());
		model.addAttribute("formTab", "active");
		model.addAttribute("editMode", "true");

		return "restaurante-form/restaurante-view";
	}

<<<<<<< HEAD:app/src/main/java/g5/app/controller/RestauranteController.java

	@PostMapping("/editRestaurante")
	public String postEditarRestaurante(@Valid @ModelAttribute("RestauranteForm")Restaurante restaurante, BindingResult result, ModelMap model) {


			try {
				restauranteService.editarRestaurante(restaurante);
				model.addAttribute("restauranteForm",new Restaurante());
				model.addAttribute("listTab", "active");


			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("restauranteForm", restaurante);
				model.addAttribute("formTab", "active");
				model.addAttribute("restauranteList", restauranteService.getAllRestaurantes());
				model.addAttribute("editMode","true");

			}
		
			
=======
	@PostMapping("/editRestaurante")
	public String postEditarRestaurante( @ModelAttribute("RestauranteForm") Restaurante restaurante,
			BindingResult result, ModelMap model) {

		try {
			restauranteService.editarRestaurante(restaurante);
			model.addAttribute("restauranteForm", new Restaurante());
			model.addAttribute("listTab", "active");

		} catch (Exception e) {
			model.addAttribute("formErrorMessage", e.getMessage());
			model.addAttribute("restauranteForm", restaurante);
			model.addAttribute("formTab", "active");
			model.addAttribute("restauranteList", restauranteService.getAllRestaurantes());
			model.addAttribute("editMode", "true");

		}

>>>>>>> main:server/src/main/java/ticomo/app/controller/RestauranteController.java
		model.addAttribute("restauranteList", restauranteService.getAllRestaurantes());

		return "restaurante-form/restaurante-view";

	}
<<<<<<< HEAD:app/src/main/java/g5/app/controller/RestauranteController.java
	

	@GetMapping("/deleteRestaurante/{nombre}")
	public String getEliminarrRestaurante(Model model, @PathVariable(name ="nombre")String nombre)throws Exception{
		try {
			restauranteService.eliminarRestaurante(nombre);
		
		}catch (Exception e) {
		model.addAttribute("listErrorMessage",e.getMessage());
=======

	@GetMapping("/deleteRestaurante/{nombre}")
	public String getEliminarrRestaurante(Model model, @PathVariable(name = "nombre") String nombre) throws Exception {
		try {
			restauranteService.eliminarRestaurante(nombre);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
>>>>>>> main:server/src/main/java/ticomo/app/controller/RestauranteController.java
		}

		model.addAttribute("restauranteForm", new Restaurante());
		model.addAttribute("restauranteList", restauranteService.getAllRestaurantes());
		model.addAttribute("listTab", "active");
		return "restaurante-form/restaurante-view";
	}
<<<<<<< HEAD:app/src/main/java/g5/app/controller/RestauranteController.java


}
    
=======
*/
}

>>>>>>> main:server/src/main/java/ticomo/app/controller/RestauranteController.java
