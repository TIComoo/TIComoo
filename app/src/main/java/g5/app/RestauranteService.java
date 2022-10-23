package g5.app;

import org.springframework.stereotype.Service;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RestauranteService {

    @Autowired
	private RestauranteRepository restauranteDAO;


	public void register(JSONObject jso) {

		String nombre = jso.getString("nombre");
		String razon = jso.getString("razon");
		String cif = jso.getString("cif");
        String direccion = jso.getString("direccion");
		Integer tlf = jso.getInt("tlf");
		String categoria = jso.getString("categoria");
        String email = jso.getString("email");

        

		if (nombre.isEmpty() || razon.isEmpty() || cif.isEmpty() || direccion.isEmpty()|| tlf==0|| categoria.isEmpty()|| email.isEmpty())
			throw new IllegalArgumentException("Rellene todos los campos");

		if (this.restauranteDAO.findById(nombre).isPresent())
			throw new IllegalArgumentException("El restaurante ya existe en el sistema");

		if (tlf <600000000 && tlf>999999999)
			throw new IllegalArgumentException("Introduzca un telefono valido");
			
		if (!email.contains("@"))
			throw new IllegalArgumentException("Introduzca un correo valido");

		if (this.restauranteDAO.findByemail(email).isPresent()) {
			throw new IllegalArgumentException("El correo introducido ya esta asociado a un restaurante");

		}

		Restaurante restaurante = new Restaurante ();
		restaurante.setNombre(nombre);
		restaurante.setRazon(razon);
		restaurante.setCIF(cif);		
		restaurante.setDireccion(direccion);
		restaurante.setTlf(tlf);
        restaurante.setCategoria(categoria);
        restaurante.setEmail(email);


		this.restauranteDAO.save(restaurante);

		


	}

	public void modify(JSONObject jso) {


		String nombre = jso.getString("nombre");
		String razon = jso.getString("razon");
		String cif = jso.getString("cif");
        String direccion = jso.getString("direccion");
		Integer tlf = jso.getInt("tlf");
		String categoria = jso.getString("categoria");
        String email = jso.getString("email");


		java.util.Optional<Restaurante>  restauranteAux = this.restauranteDAO.findById(nombre);
		java.util.Optional<Restaurante>  emailAux = this.restauranteDAO.findByemail(email);


		if (!restauranteAux.isPresent())
			throw new IllegalArgumentException("No hay un restaurante con este nombre en el sistema");	

		if (razon.isEmpty() || cif.isEmpty() || direccion.isEmpty()|| tlf==0|| categoria.isEmpty()|| email.isEmpty())
			throw new IllegalArgumentException("Rellene todos los campos");

		if (tlf <600000000 && tlf>999999999)
			throw new IllegalArgumentException("Introduzca un telefono valido");
			
		if (!email.contains("@"))
			throw new IllegalArgumentException("Introduzca un correo valido");

		if (emailAux.isPresent() && !(emailAux.get().getEmail().equals(restauranteAux.get().getEmail()))) 
			throw new IllegalArgumentException("El correo introducido ya esta asociado a un restaurante");


			restauranteAux.get().setRazon(razon);
			restauranteAux.get().setCIF(cif);
			restauranteAux.get().setDireccion(direccion);
			restauranteAux.get().setTlf(tlf);
			restauranteAux.get().setCategoria(categoria);			
			restauranteAux.get().setEmail(email);
			this.restauranteDAO.save(restauranteAux.get());


		

	}

	public void delete(JSONObject jso) {

		String nombre = jso.getString("nombre");
		java.util.Optional<Restaurante>  restauranteAux = this.restauranteDAO.findById(nombre);

		if (!restauranteAux.isPresent()){
			throw new IllegalArgumentException("No hay un restaurante con este nombre en el sistema");	

		}else{
			this.restauranteDAO.delete(restauranteAux.get());

	}
	
	
}

}
