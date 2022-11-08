<<<<<<< HEAD:app/src/main/java/g5/app/service/RestauranteServiceImpl.java
package g5.app.service;
=======
package ticomo.app.service;

import java.util.List;
>>>>>>> main:server/src/main/java/ticomo/app/service/RestauranteServiceImpl.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD:app/src/main/java/g5/app/service/RestauranteServiceImpl.java
import g5.app.dao.RestauranteRepository;
import g5.app.model.*;
=======
import ticomo.app.dao.RestauranteRepository;
import ticomo.app.model.Restaurante;


>>>>>>> main:server/src/main/java/ticomo/app/service/RestauranteServiceImpl.java
 
@Service
public class RestauranteServiceImpl implements RestauranteService{

	@Autowired
	RestauranteRepository restauranteRepository;
	

	public Restaurante createRestaurante(Restaurante restaurante) {

		
<<<<<<< HEAD:app/src/main/java/g5/app/service/RestauranteServiceImpl.java
		if (restaurante.getNombre().isEmpty() || restaurante.getRazon().isEmpty() || restaurante.getCif().isEmpty() || restaurante.getDireccion().isEmpty()|| restaurante.getTlf().isEmpty()|| restaurante.getCategoria().isEmpty()|| restaurante.getEmail().isEmpty())
=======
		if (restaurante.getNombre().isEmpty() || restaurante.getRazon().isEmpty() || restaurante.getCIF().isEmpty() || restaurante.getDireccion().isEmpty()|| restaurante.getTlf().isEmpty()|| restaurante.getCategoria().isEmpty()|| restaurante.getEmail().isEmpty())
>>>>>>> main:server/src/main/java/ticomo/app/service/RestauranteServiceImpl.java
			throw new IllegalArgumentException("Rellene todos los campos");


		if (this.restauranteRepository.findById(restaurante.getNombre()).isPresent())
			throw new IllegalArgumentException("El restaurante ya existe en el sistema");
		
<<<<<<< HEAD:app/src/main/java/g5/app/service/RestauranteServiceImpl.java
		if (this.restauranteRepository.findByemail(restaurante.getEmail()).isPresent()) 
=======
		if (this.restauranteRepository.findByEmail(restaurante.getEmail()).isPresent()) 
>>>>>>> main:server/src/main/java/ticomo/app/service/RestauranteServiceImpl.java
			throw new IllegalArgumentException("El correo introducido ya esta asociado a un restaurante");
	
				
		
		restauranteRepository.save(restaurante);
		return restaurante;	
		
		
		}



	public Restaurante editarRestaurante(Restaurante restaurante) {


		java.util.Optional<Restaurante>  restauranteAux = this.restauranteRepository.findById(restaurante.getNombre());
<<<<<<< HEAD:app/src/main/java/g5/app/service/RestauranteServiceImpl.java
		java.util.Optional<Restaurante>  emailAux = this.restauranteRepository.findByemail(restaurante.getEmail());


		if (restaurante.getNombre().isEmpty() || restaurante.getRazon().isEmpty() || restaurante.getCif().isEmpty() || restaurante.getDireccion().isEmpty()|| restaurante.getTlf().isEmpty()|| restaurante.getCategoria().isEmpty()|| restaurante.getEmail().isEmpty())
=======
		java.util.Optional<Restaurante>  emailAux = this.restauranteRepository.findByEmail(restaurante.getEmail());


		if (restaurante.getNombre().isEmpty() || restaurante.getRazon().isEmpty() || restaurante.getCIF().isEmpty() || restaurante.getDireccion().isEmpty()|| restaurante.getTlf().isEmpty()|| restaurante.getCategoria().isEmpty()|| restaurante.getEmail().isEmpty())
>>>>>>> main:server/src/main/java/ticomo/app/service/RestauranteServiceImpl.java
		throw new IllegalArgumentException("Rellene todos los campos");

		if (!restauranteAux.isPresent())
			throw new IllegalArgumentException("No hay un restaurante con este nombre en el sistema");	

			
		if (!restaurante.getEmail().contains("@"))
			throw new IllegalArgumentException("Introduzca un correo valido");

		if (emailAux.isPresent() && !(emailAux.get().getEmail().equals(restauranteAux.get().getEmail()))) 
			throw new IllegalArgumentException("El correo introducido ya esta asociado a un restaurante");

	
		this.restauranteRepository.save(restaurante);		
		return restaurante;

	}


	public void eliminarRestaurante(String nombre) {

		java.util.Optional<Restaurante>  restauranteAux = this.restauranteRepository.findById(nombre);

		if (!restauranteAux.isPresent()){
			throw new IllegalArgumentException("No hay un restaurante con este nombre en el sistema");	

		}else{
			this.restauranteRepository.deleteById(nombre);

	}

}

<<<<<<< HEAD:app/src/main/java/g5/app/service/RestauranteServiceImpl.java
	public Iterable<Restaurante> getAllRestaurantes() {
=======
	public List<Restaurante> getAllRestaurantes() {
		
>>>>>>> main:server/src/main/java/ticomo/app/service/RestauranteServiceImpl.java
		return restauranteRepository.findAll();
	}










<<<<<<< HEAD:app/src/main/java/g5/app/service/RestauranteServiceImpl.java
}

=======
}
>>>>>>> main:server/src/main/java/ticomo/app/service/RestauranteServiceImpl.java
