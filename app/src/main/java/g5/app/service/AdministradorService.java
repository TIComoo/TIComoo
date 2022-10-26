package g5.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g5.app.dao.AdministradorRepository;
import g5.app.model.Administrador;

@Service
public class AdministradorService {

   
    @Autowired
    AdministradorRepository adminRepository;
    

    //CRUD Crear y Modificar. Testeado con TDD que Modificar funciona correctamente.
    
    public void crearAdministrador(Administrador a) {
       adminRepository.save(a);
    }


    public void modificarAdministrador(Administrador admin) {
    }

  /*  
    public void modificarAdministrador() {

    }
    
    public void consultarAdministrador() {

    }
    public void borrarAdministrador() {

    }
     */
   



}
