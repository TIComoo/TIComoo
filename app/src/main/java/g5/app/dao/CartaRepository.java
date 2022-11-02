package g5.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import g5.app.model.Carta;

import java.util.*;

public interface CartaRepository extends MongoRepository<Carta,Long>{

	Optional<Carta> findBynombreRestaurante(String nombre);

	
}