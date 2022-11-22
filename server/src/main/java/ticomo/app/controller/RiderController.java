package ticomo.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ticomo.app.model.Rider;
import ticomo.app.model.Valoracion;
import ticomo.app.service.RiderService;

@RestController
@RequestMapping("/rider")
@CrossOrigin(origins = "http://localhost:3000")
public class RiderController {

	@Autowired
	private RiderService riderService;

	// cambiado
	@PostMapping(value = "/guardarRider")
	public void guardarRider(@RequestBody Map<String, Object> info) {
		JSONObject jso = new JSONObject(info);

		Rider rider = new Rider();
		rider.setEmail(jso.getString("email"));
		rider.setNombre(jso.getString("nombre"));
		rider.setApellido(jso.getString("apellido"));
		rider.setPwd(jso.getString("pwd"));
		rider.setNif(jso.getString("nif"));
		rider.setTipoVehiculo(jso.getString("tipoVehiculo"));
		rider.setMatricula(jso.getString("matricula"));
		rider.setCarnet(jso.getString("carnet"));

		this.riderService.guardarRider(rider);
	}

	@GetMapping(value = "/leerRiders", produces = "application/json")
	@ResponseBody
	public List<Rider> leerRiders() {
		List<Rider> riders = this.riderService.leerRiders();
		return riders;
	}

	@GetMapping(value = "/leerRiderPorEmail", produces = "application/json")
	@ResponseBody
	public Rider leerRiderPorEmail(@RequestHeader String email) {
		Rider rider = this.riderService.leerRiderPorEmail(email);
		return rider;
	}

	// cambiado
	@GetMapping("/borrarRiderPorEmail/{email}")
	public String borrarRiderPorEmail(@PathVariable(name = "email") String email) {
		this.riderService.borrarRiderPorEmail(email);

		return "/admin/admin-view";
	}
	@GetMapping(value = "/leerValoracionesPorEmail", produces = "application/json")
	@ResponseBody
	public String leerValoracionesPorEmail(@RequestHeader String email) {
		Rider rider = this.riderService.leerRiderPorEmail(email);
		String st = "";
		ArrayList<Valoracion> valoraciones = rider.getValoraciones();
		for(Valoracion v : valoraciones){
			st += v.stringValoraciones();
		}
		return st;
	}

}