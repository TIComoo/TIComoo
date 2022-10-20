package g5.app.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import g5.app.model.User;

public interface UserRepository extends MongoRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
