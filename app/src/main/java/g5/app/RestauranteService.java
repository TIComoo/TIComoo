package g5.app;

import org.springframework.stereotype.Service;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

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

        

		if (nombre.isEmpty() || razon.isEmpty() || CIF.isEmpty() || direccion.isEmpty()|| tlf.isEmpty()|| categoria.isEmpty()|| email.isEmpty())
			throw new Exception("Rellene todos los campos");

		if (this.restauranteDAO.findById(nombre).isPresent())
			throw new Exception("El restaurante ya existe en el sistema");
			
		if (!email.contains("@"))
			throw new Exception("Introduzca un correo valido");

		if (this.restauranteDAO.findByemail(email).isPresent()) {
			throw new Exception("El correo introducido ya esta asociado a un restaurante");

		}
        

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

	public void modify(JSONObject jso) throws Exception {

		String nombre = jso.getString("nombre");
		java.util.Optional<Restaurante>  restauranteAux = this.restauranteDAO.findById(nombre);

		if (!restauranteAux.isPresent()){
			throw new Exception("No hay un restaurante con este nombre en el sistema");	

		}else{

			restauranteAux.get().setRazon(jso.getString("razon"));
			restauranteAux.get().setCIF(jso.getString("CIF"));
			restauranteAux.get().setDireccion(jso.getString("direccion"));
			restauranteAux.get().setTlf(jso.getString("tlf"));
			restauranteAux.get().setCategoria(jso.getString("categoria"));
			restauranteAux.get().setEmail(jso.getString("email"));
			this.restauranteDAO.save(restauranteAux.get());


		}

	}

	public void delete(JSONObject jso) throws Exception {

		String nombre = jso.getString("nombre");
		java.util.Optional<Restaurante>  restauranteAux = this.restauranteDAO.findById(nombre);

		if (!restauranteAux.isPresent()){
			throw new Exception("No hay un restaurante con este nombre en el sistema");	

		}else{
			this.restauranteDAO.delete(restauranteAux.get());

	}
	
	
}

}
