package g5.app;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdministradorRepository extends MongoRepository<Administrador, String> {
    
}
