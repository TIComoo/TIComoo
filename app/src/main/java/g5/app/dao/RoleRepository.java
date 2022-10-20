package g5.app.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import g5.app.model.Role;

public interface RoleRepository extends MongoRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
