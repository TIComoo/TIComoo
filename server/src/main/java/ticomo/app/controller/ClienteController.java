package ticomo.app.controller;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ticomo.app.model.Cliente;
import ticomo.app.service.ClienteService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	
	@GetMapping("/signup")
	public String signup(Model model) {
		
		model.addAttribute("signup",true);
		model.addAttribute("clientesForm", new Cliente());
		return "users/cliente-signup";
	}

	
	@PostMapping("/signup")
	public String signupAction(@RequestBody Map<String, Object> info) throws Exception {
		try {
			JSONObject jso = new JSONObject(info);
			Cliente cliente = new Cliente();
			cliente.setApellido(jso.getString("email"));
			cliente.setNombre(jso.getString("nombre"));
			cliente.setApellido(jso.getString("apellido"));
			cliente.setPwd(jso.getString("pwd"));
			cliente.setNif(jso.getString("nif"));
			cliente.setDireccion(jso.getString("direccion"));
			cliente.setTelefono(jso.getString("telefono"));
			
			clienteService.guardarCliente(cliente);


		} catch (ResponseStatusException e) {
			throw e;
		}
		return index();
	}
	
	@GetMapping({"/","/login"})
    public String index() {
        return "index";
    }

	@PostMapping(value = "/guardarCliente")
	public void guardarUsuario(@RequestBody @ModelAttribute("Cliente") Cliente cliente) {
		this.clienteService.guardarCliente(cliente);
	}

	@GetMapping(value = "/leerClientes", produces = "application/json")
	@ResponseBody
	public List<Cliente> leerClientes() {
		List<Cliente> clientes = this.clienteService.consultarClientes();
		return clientes;
	}

	@PostMapping("/leerClientePorEmail")
	public Cliente leerClientePorEmail(@RequestBody String email) {
		JSONObject jso = new JSONObject(email);

		Cliente cliente = this.clienteService.leerClientePorEmail(jso.getString("email"));
		
		return cliente;
	}

	@GetMapping("/borrarClientePorEmail/{email}")
	public String borrarClientePorEmail(Model model, @PathVariable(name = "email") String email) {
		try {
			this.clienteService.borrarClientePorEmail(email);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		
		return "users/admin-view";
	}

}
