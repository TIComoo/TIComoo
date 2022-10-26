
package g5.app;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.*;
public interface RestauranteRepository extends MongoRepository<Restaurante,String>{

	Optional<Restaurante> findByemail(String email);
	Optional<Restaurante> findBynombre(String nombre);


}
