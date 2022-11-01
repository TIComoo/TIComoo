package g5.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g5.app.dao.AdministradorRepository;
import g5.app.exception.UsernameNotFound;
import g5.app.model.Administrador;

@Service
public class AdministradorService {
	
	@Autowired
	private AdministradorRepository adminRepository;

	public void guardarAdministrador(Administrador adm) {
		adminRepository.save(adm);
	}

	public void borrarAdminPorEmail(String email) {
	    adminRepository.deleteById(email);
	}

	public Administrador buscarPorEmail(String email) throws UsernameNotFound {
		return adminRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFound("El email del usuario no existe."));
	}

}
