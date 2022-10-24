package g5.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {

   
    @Autowired
    AdministradorRepository adminRepository;
    

    //CRUD Crear y Modificar. Testeado con TDD que Modificar funciona correctamente.
    
    public void crearAdministrador(Administrador a) {
       adminRepository.save(a);
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
