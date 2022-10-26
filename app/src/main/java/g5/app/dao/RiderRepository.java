package g5.app.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import g5.app.exception.UsernameNotFound;
import g5.app.model.Rider;

public interface RiderRepository  extends MongoRepository<Rider, String> {

	Optional<Rider> findByEmail(String email) throws UsernameNotFound;

}
