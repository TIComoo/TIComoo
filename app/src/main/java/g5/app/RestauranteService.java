package g5.app;

import org.springframework.stereotype.Service;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
@Service
public class RestauranteService {

    @Autowired
	private RestauranteRepository restauranteDAO;

	public void register(JSONObject jso) throws Exception {

		String nombre = jso.getString("nombre");
		String razon = jso.getString("razon");
		String CIF = jso.getString("CIF");
        String direccion = jso.getString("direccion");
		String tlf = jso.getString("tlf");
		String categoria = jso.getString("categoria");
        String email = jso.getString("email");

        /* 

		if (user_name.isEmpty() || pwd1.isEmpty() || pwd2.isEmpty() || email.isEmpty())
			throw new Exception("Rellene todos los campos");

		if (this.restauranteDAO.findById(user_name).isPresent())
			throw new Exception("El usuario ya existe en el sistema");
		if (user_name.length() < 5)
			throw new Exception("La contraseña ha de tener más de  5 caracteres ");
		if (!pwd1.equals(pwd2))
			throw new Exception("Las contraseñas no coinciden ");
		if (pwd1.length() < 5)
			throw new Exception("La contraseña ha de tener más de  5 caracteres ");
		if (!email.contains("@"))
			throw new Exception("Introduzca un correo valido");

		if (this.restauranteDAO.findByEmailIgnoreCase(email).isPresent()) {
			throw new Exception("El correo introducido ya esta asociado a una cuenta");

		}
        */

		Restaurante restaurante = new Restaurante ();
		restaurante.setNombre(jso.getString("nombre"));
		restaurante.setRazon(jso.getString("razon"));
		restaurante.setCIF(jso.getString("CIF"));
		restaurante.setDireccion(jso.getString("direccion"));
        restaurante.setTlf(jso.getString("tlf"));
        restaurante.setCategoria(jso.getString("categoria"));
        restaurante.setEmail(jso.getString("email"));


		this.restauranteDAO.save(restaurante);

	}

	
}
