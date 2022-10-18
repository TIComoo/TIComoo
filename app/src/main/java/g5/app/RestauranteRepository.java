package g5.app;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.*;
public interface RestauranteRepository extends MongoRepository<Restaurante,String>{
	List<Restaurante> findBynombre(String nombre);
}
