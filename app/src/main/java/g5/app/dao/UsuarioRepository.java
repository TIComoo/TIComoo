package g5.app.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import g5.app.exception.UsernameNotFound;
import g5.app.model.Usuario;

/*
 * Debe permitir a los usuarios registrarse en el sistema, solicitar, 
 * gestionar y valorar sus pedidos de comida. Una vez entregado el pedido 
 * se podrá valorar tanto al restaurante como al rider.
 */

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	// Le he cambiado el nombre a findBy porque si no da error, tiene que llamarse así, no puede llamarse buscarPor
	Optional<Usuario> findByEmail(String email) throws UsernameNotFound;

}