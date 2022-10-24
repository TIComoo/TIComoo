package g5.app.service;

import org.springframework.stereotype.Service;

import g5.app.model.Usuario;

@Service
public interface UsuarioService{


	public Iterable<Usuario> getAllUsers();
	
	public Usuario findUserByEmail(String email);
	
	public Usuario createUser(Usuario usuario) throws Exception;
	
}
