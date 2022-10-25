package g5.app;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.*;

public interface CartaRepository extends MongoRepository<Carta,Integer>{

	Optional<Carta> findBynombreRestaurante(String nombre);

	
}