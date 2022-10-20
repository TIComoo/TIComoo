package g5.app;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>
{
	public Usuario buscarUsuarioPorId(String email);
    
}