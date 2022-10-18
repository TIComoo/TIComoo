package g5.app;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.*;

public interface PlatoRepository extends MongoRepository<Plato,Integer>{

	Optional<Plato> findBynombre(String nombre);

	
}