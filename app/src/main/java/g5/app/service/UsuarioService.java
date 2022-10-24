package g5.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g5.app.dao.UsuarioRepository;
import g5.app.exception.UsernameNotFound;
import g5.app.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repository;

	public void guardarUsuario(Usuario usr) {
		repository.save(usr);
	}

	public void borrarUsuario() {

	}

	public Usuario buscarPorEmail(String email) throws UsernameNotFound {
		return repository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFound("El email del usuario no existe."));
	}

}
