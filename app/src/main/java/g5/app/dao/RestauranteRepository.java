package g5.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.*;
import g5.app.model.*;
public interface RestauranteRepository extends MongoRepository<Restaurante,String>{

	Optional<Restaurante> findByemail(String email);
	Optional<Restaurante> findBynombre(String nombre);


}
