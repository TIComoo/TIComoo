package g5.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g5.app.dao.RestauranteRepository;
import g5.app.model.*;

@Service
public class RestauranteService {

    @Autowired
	private RestauranteRepository restauranteDAO;


	public void insert(Restaurante restaurante) {

		if (restaurante.getNombre().isEmpty() || restaurante.getRazon().isEmpty() || restaurante.getCIF().isEmpty() || restaurante.getDireccion().isEmpty()|| restaurante.getTlf()==0|| restaurante.getCategoria().isEmpty()|| restaurante.getEmail().isEmpty())
			throw new IllegalArgumentException("Rellene todos los campos");

		if (this.restauranteDAO.findById(restaurante.getNombre()).isPresent())
			throw new IllegalArgumentException("El restaurante ya existe en el sistema");

		if (restaurante.getTlf() <600000000 && restaurante.getTlf()>999999999)
			throw new IllegalArgumentException("Introduzca un telefono valido");
			
		if (!restaurante.getEmail().contains("@"))
			throw new IllegalArgumentException("Introduzca un correo valido");

		if (this.restauranteDAO.findByemail(restaurante.getEmail()).isPresent()) {
			throw new IllegalArgumentException("El correo introducido ya esta asociado a un restaurante");

		}

		restauranteDAO.save(restaurante);

		


	}

	public void update(Restaurante restaurante) {



		java.util.Optional<Restaurante>  restauranteAux = this.restauranteDAO.findById(restaurante.getNombre());
		java.util.Optional<Restaurante>  emailAux = this.restauranteDAO.findByemail(restaurante.getEmail());


		if (!restauranteAux.isPresent())
			throw new IllegalArgumentException("No hay un restaurante con este nombre en el sistema");	

		if (restaurante.getTlf() <600000000 && restaurante.getTlf()>999999999)
			throw new IllegalArgumentException("Introduzca un telefono valido");
			
		if (!restaurante.getEmail().contains("@"))
			throw new IllegalArgumentException("Introduzca un correo valido");

		if (this.restauranteDAO.findByemail(restaurante.getEmail()).isPresent()) {
			throw new IllegalArgumentException("El correo introducido ya esta asociado a un restaurante");

		}

			this.restauranteDAO.save(restauranteAux.get());		

	}

	public void delete(Restaurante restaurante) {


		java.util.Optional<Restaurante>  restauranteAux = this.restauranteDAO.findById(restaurante.getNombre());

		if (!restauranteAux.isPresent()){
			throw new IllegalArgumentException("No hay un restaurante con este nombre en el sistema");	

		}else{
			this.restauranteDAO.delete(restauranteAux.get());

	}
	
	
}

	public void list() {

		List<Restaurante>  restauranteAux = this.restauranteDAO.findAll();

		for (int i =0;i<restauranteAux.size();i++){

			System.out.println(restauranteAux.get(i));

		}
		

		}

    public Iterable<Restaurante> getAllUsers() {
        return restauranteDAO.findAll();
    }



	}


