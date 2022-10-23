package g5.app;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/*Debe permitir a los usuarios registrarse en el sistema, solicitar, gestionar y valorar sus 
pedidos de comida. Una vez entregado el pedido se podrá valorar tanto al restaurante 
como al rider. */
@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>
{
	//public Usuario buscarUsuarioPorId(String email);

	Usuario buscarPorEmail(String email);
	
    
}