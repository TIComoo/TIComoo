package g5.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g5.app.dao.UsuarioRepository;
import  g5.app.exception.CustomeFieldValidationException;
import g5.app.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class UsuarioServiceImpl implements UsuarioService{

	
	@Autowired
	UsuarioRepository uRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public Usuario createUser(Usuario usuario) throws Exception {

		if (checkUsernameAvailable(usuario) && checkPasswordValid(usuario)) {
			String encodedPassword = bCryptPasswordEncoder.encode(usuario.getPwd());
			usuario.setPwd(encodedPassword);
			usuario = uRepository.save(usuario);
		}
		return usuario;
	}
	
	private boolean checkUsernameAvailable(Usuario usuario) throws Exception {
		Usuario userFound = uRepository.findByNombre(usuario.getNombre());
		if (userFound != null) {
			throw new CustomeFieldValidationException("Username no disponible","username");
		}
		return true;
	}

	private boolean checkPasswordValid(Usuario usuario) throws Exception {
		if (usuario.getConfirmarPwd() == null || usuario.getConfirmarPwd().isEmpty()) {
			throw new CustomeFieldValidationException("Confirmar la contraseña es obligatorio","confirmarPwd");
		}
		
		if ( !usuario.getPwd().equals(usuario.getConfirmarPwd())) {
			throw new CustomeFieldValidationException("Contraseña y Confirmar cpntraseña no son iguales","pwd");
		}
		return true;
	}

	@Override
	public Usuario findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return uRepository.findByEmail(email);
	}

	@Override
	public Iterable<Usuario> getAllUsers() {
		// TODO Auto-generated method stub
		return uRepository.findAll();
	}
}
