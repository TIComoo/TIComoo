package g5.app.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import g5.app.exception.UsernameNotFound;
import g5.app.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

	Optional<Cliente> findByEmail(String email) throws UsernameNotFound;

}