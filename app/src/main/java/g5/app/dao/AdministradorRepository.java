package g5.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import g5.app.model.Administrador;

public interface AdministradorRepository extends MongoRepository<Administrador, String> {
    
}
