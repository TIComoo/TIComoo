package ticomo.app.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ticomo.app.model.Carta;

@Repository
public interface CartaRepository extends MongoRepository<Carta, Long> {

	public Carta findBynombreRestaurante(String nombre);


}