package g5.app;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends MongoRepository<Rider, String>{

}
