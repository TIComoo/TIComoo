package g5.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import g5.app.model.Restaurante;

import java.util.*;
public interface RestauranteRepository extends MongoRepository<Restaurante,String>{

	Optional<Restaurante> findByemail(String email);
	Optional<Restaurante> findByNombre(String nombre);


}
