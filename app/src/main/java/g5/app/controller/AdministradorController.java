package g5.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import g5.app.model.Administrador;
import g5.app.service.AdministradorService;
import g5.app.service.ClienteService;
import g5.app.service.RestauranteService;
import g5.app.service.RiderService;

@Controller
@RequestMapping("/admin")
public class AdministradorController {

	@Autowired
	private AdministradorService adminService;

	@Autowired
	private RiderService riderService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private RestauranteService restauranteService;

	@GetMapping("/admin-view")
	public String getAdministradorView(Model model) {
		model.addAttribute("listTab", "active");
		/*
		 * model.addAttribute("listTab1", "active"); model.addAttribute("listTab2",
		 * "active"); model.addAttribute("listTab3", "active");
		 */

		model.addAttribute("adminList", adminService.leerAdministradores());
		model.addAttribute("riderList", riderService.leerRiders());
		model.addAttribute("clienteList", clienteService.consultarClientes());
		model.addAttribute("restauranteList", restauranteService.getAllRestaurantes());

		return "users/admin-view";

	}

	@PostMapping(value = "/guardarAdmin")
	public void crearAdmin(@RequestBody @ModelAttribute("Administrador") Administrador admin) {
		this.adminService.guardarAdministrador(admin);
	}

	@GetMapping(value = "/leerAdminPorEmail", produces = "application/json")
	@ResponseBody
	public Administrador leerAdminPorEmail(@RequestHeader String email) {
		Administrador admin = this.adminService.leerAdminPorEmail(email);
		return admin;

	}

	@GetMapping(value = "/leerAdministradores", produces = "application/json")
	@ResponseBody
	public Iterable<Administrador> leerAdministradores() {
		Iterable<Administrador> administradores = this.adminService.leerAdministradores();
		return administradores;
	}

	@GetMapping("/borrarAdminPorEmail/{email}")
	public void borrarAdminPorEmail(@PathVariable(name = "email") String email) {
		this.adminService.borrarAdminPorEmail(email);
	}

}
