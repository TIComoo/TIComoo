package g5.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import g5.app.model.Administrador;
import g5.app.model.Cliente;

public interface AdministradorRepository extends MongoRepository<Administrador, String> {

	public Administrador findByEmail(String email);

    
}