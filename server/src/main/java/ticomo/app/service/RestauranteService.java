<<<<<<< HEAD:app/src/main/java/g5/app/service/RestauranteService.java
package g5.app.service;
import g5.app.model.*;

public interface RestauranteService {

	public Iterable<Restaurante> getAllRestaurantes();
	public Restaurante createRestaurante(Restaurante restaurante) throws Exception;
	public Restaurante editarRestaurante(Restaurante restaurante) throws Exception;
    public void eliminarRestaurante(String nombre)throws Exception;








	}

=======
package ticomo.app.service;

import java.util.List;

import ticomo.app.model.Restaurante;

public interface RestauranteService {

	public List<Restaurante> getAllRestaurantes();

	public Restaurante createRestaurante(Restaurante restaurante) throws Exception;

	public Restaurante editarRestaurante(Restaurante restaurante) throws Exception;

	public void eliminarRestaurante(String nombre) throws Exception;

}
>>>>>>> main:server/src/main/java/ticomo/app/service/RestauranteService.java

