package ticomo.app.dao;



import org.springframework.data.mongodb.repository.MongoRepository;

import ticomo.app.model.Carta;

public interface CartaRepository extends MongoRepository<Carta, Long> {

	public Carta findBynombreRestaurante(String nombre);
	
}
