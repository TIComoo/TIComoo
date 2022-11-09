package ticomo.app.controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ticomo.app.model.Pedido;
import ticomo.app.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    

    @Autowired
	private PedidoService pedidoService;

    @PostMapping("/crearPedido")
	public String signupAction(@RequestBody Map<String, Object> info) throws Exception {
		try {
			JSONObject jso = new JSONObject(info);
			Pedido pedido = new Pedido();
			// pedido.setPlatos(jso.getNames("platos")); DUDA
			pedido.setPrecio(jso.getDouble("precio"));
			// pedido.setFecha(jso.get("fecha"));  DUDA
			pedido.setEstado(jso.getString("estado"));
		
			pedidoService.crearPedido(pedido);


		} catch (ResponseStatusException e) {
			throw e;
		}
		return "Pedido creado";
	}
}
