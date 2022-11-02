package g5.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import g5.app.model.Plato;

import java.util.*;

public interface PlatoRepository extends MongoRepository<Plato,Long>{

	Optional<Plato> findBynombre(String nombre);
	List<Plato>findBynombreRestaurante(String nombre);

	
}