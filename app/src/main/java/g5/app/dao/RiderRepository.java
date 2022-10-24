package g5.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import g5.app.model.Rider;

public interface RiderRepository  extends MongoRepository<Rider, String> {

}
