package g5.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import g5.app.dao.AdministradorRepository;
import g5.app.dao.RiderRepository;
import g5.app.dao.UsuarioRepository;
import g5.app.exception.UsernameNotFound;
import g5.app.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usrDao;

	@Autowired
	AdministradorRepository admDao;

	@Autowired
	RiderRepository rdrDao;

	public void guardarUsuario(Usuario usr) {
		usrDao.save(usr);
	}

	public void borrarUsuario() {

	}

	public Usuario buscarPorEmail(String email) throws UsernameNotFound {
		return usrDao.findByEmail(email).orElseThrow(() -> new UsernameNotFound("El email del usuario no existe."));
	}

	public Usuario getLoggedUser() throws Exception {
		// Obtener el usuario logeado
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		UserDetails loggedUser = null;

		// Verificar que ese objeto traido de sesion es el usuario
		if (principal instanceof UserDetails)
			loggedUser = (UserDetails) principal;

		Usuario myUser = null;

		switch (loggedUser.getAuthorities().iterator().next().toString()) {
		case "Usuario":
			myUser = usrDao.findByEmail(loggedUser.getUsername())
					.orElseThrow(() -> new Exception("Error obteniendo el usuario logeado desde la sesion."));
			break;
		case "Administrador":
			myUser = admDao.findByEmail(loggedUser.getUsername())
					.orElseThrow(() -> new Exception("Error obteniendo el usuario logeado desde la sesion."));
			break;
		case "Rider":
			myUser = rdrDao.findByEmail(loggedUser.getUsername())
					.orElseThrow(() -> new Exception("Error obteniendo el usuario logeado desde la sesion."));
			break;
		}

		return myUser;
	}

}
