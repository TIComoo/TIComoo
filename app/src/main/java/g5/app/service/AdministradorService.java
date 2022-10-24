package g5.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g5.app.dao.AdministradorRepository;
import g5.app.model.Administrador;

@Service
public class AdministradorService {
	
	@Autowired
	private AdministradorRepository repository;

	public void guardarAdministrador(Administrador adm) {
		repository.save(adm);
	}

	public void consultarAdministrador() {

	}

	public void borrarAdministrador() {

	}

}
