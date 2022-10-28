package g5.app;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.*;

public interface CartaRepository extends MongoRepository<Carta,Long>{

	Optional<Carta> findBynombreRestaurante(String nombre);

	
}