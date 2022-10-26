package g5.app.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import g5.app.exception.UsernameNotFound;
import g5.app.model.Administrador;

public interface AdministradorRepository extends MongoRepository<Administrador, String> {

	Optional<Administrador> findByEmail(String email) throws UsernameNotFound;
    
}