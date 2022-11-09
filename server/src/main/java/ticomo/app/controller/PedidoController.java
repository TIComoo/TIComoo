package ticomo.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ticomo.app.model.Pedido;
import ticomo.app.model.Plato;
import ticomo.app.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    

    @Autowired
	private PedidoService pedidoService;

    @PostMapping("/crearPedido")
	public String crearPedido(@RequestBody Map<String, Object> info) throws Exception {
		try {
			JSONObject jso = new JSONObject(info);
			Pedido pedido = new Pedido();

			JSONArray arr = jso.getJSONArray("platos");
			for(int i=0;i<arr.length();i++){
				Plato aux= new Plato();
				JSONObject jsonAux = arr.getJSONObject(i);

				aux.setId(jsonAux.getLong("id"));
				aux.setNombre(jsonAux.getString("nombre"));
				aux.setNombreRestaurante(jsonAux.getString("nombreRestaurante"));
				aux.setDescripcion(jsonAux.getString("descripcion"));
				aux.setPrecio(jsonAux.getDouble("precio"));
				aux.setAptoVeganos(jsonAux.getBoolean("aptoVeganos"));
				pedido.getPlatos().add(aux);
			}

			 
			pedido.sumarPrecios();

			String dateString = jso.getString("fecha");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date creacionP = sdf.parse(dateString);

			pedido.setFecha((creacionP));  
			pedido.setEstado(jso.getString("estado"));
		
			pedidoService.crearPedido(pedido);


		} catch (ResponseStatusException e) {
			throw e;
		}
		return "Pedido creado";
	}
}
