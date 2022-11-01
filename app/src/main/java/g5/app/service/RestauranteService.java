package g5.app.service;
import g5.app.model.*;

public interface RestauranteService {

	public Iterable<Restaurante> getAllRestaurantes();
	public Restaurante createRestaurante(Restaurante restaurante) throws Exception;
	public Restaurante editarRestaurante(Restaurante restaurante) throws Exception;
    public void eliminarRestaurante(String nombre)throws Exception;








	}


