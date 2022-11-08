<<<<<<< HEAD:app/src/main/java/g5/app/dao/RestauranteRepository.java
package g5.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import g5.app.model.Restaurante;
=======
package ticomo.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import ticomo.app.model.Restaurante;
>>>>>>> main:server/src/main/java/ticomo/app/dao/RestauranteRepository.java

import java.util.*;
public interface RestauranteRepository extends MongoRepository<Restaurante,String>{

<<<<<<< HEAD:app/src/main/java/g5/app/dao/RestauranteRepository.java
	Optional<Restaurante> findByemail(String email);
	Optional<Restaurante> findBynombre(String nombre);


}
=======
	Optional<Restaurante> findByEmail(String email);

	Optional<Restaurante> findByNombre(String nombre);

}

>>>>>>> main:server/src/main/java/ticomo/app/dao/RestauranteRepository.java
