package g5.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import g5.app.dao.AdministradorRepository;
import g5.app.exception.CustomeFieldValidationException;
import g5.app.model.Administrador;
import g5.app.model.Cliente;

@Service
public class AdministradorService {

  @Autowired
  AdministradorRepository adminRepository;

  // CRUD Crear y Modificar. Testeado con TDD que Modificar funciona
  // correctamente.
  
  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;

  public void guardarAdministrador(Administrador a) throws Exception {
	  if(emailValido(a)) {
			String encodedPassword = bCryptPasswordEncoder.encode(a.getPwd());
			a.setPwd(encodedPassword);
		    adminRepository.save(a);

	  }
  }

  private boolean emailValido(Administrador administrador) throws Exception {
		Administrador encontrado = leerAdminPorEmail(administrador.getEmail());
		if (encontrado != null) {
			throw new CustomeFieldValidationException("Email no disponible","email");
		}
		return true;
	}
 

  public List<Administrador> leerAdministradores() {
    List<Administrador> administradores = adminRepository.findAll();

    return administradores;

  }

  public Administrador leerAdminPorEmail(String email) {
	    Administrador admin = adminRepository.findByEmail(email);


    return admin;

  }

  public void borrarAdminPorEmail(String email) {
    adminRepository.deleteById(email);
  }

}