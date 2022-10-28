package g5.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import g5.app.model.Rider;

@Repository
public interface RiderRepository extends MongoRepository<Rider, String>{

    public Rider findByEmail(String email);

}
