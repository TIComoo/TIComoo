package g5.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g5.app.dao.AdministradorRepository;
import g5.app.model.Administrador;
import g5.app.model.Cliente;

@Service
public class AdministradorService {

  @Autowired
  AdministradorRepository adminRepository;

  // CRUD Crear y Modificar. Testeado con TDD que Modificar funciona
  // correctamente.

  public void guardarAdministrador(Administrador a) {
    adminRepository.save(a);
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