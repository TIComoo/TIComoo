package g5.app.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import g5.app.exception.UsernameNotFound;
import g5.app.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
	Optional<Usuario> findByEmail(String email) throws UsernameNotFound;

}