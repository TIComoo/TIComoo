package g5.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import g5.app.model.Roles;


public interface RolRepository extends MongoRepository<Roles, Long>{

	public Roles findByNombre(String nombre);
}