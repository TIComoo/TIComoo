package g5.app.dao;


import org.springframework.data.mongodb.repository.MongoRepository;

import g5.app.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {
	
	public Usuario findByEmail(String email);
	public Usuario findByNombre(String nombre);


}