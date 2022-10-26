package g5.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g5.app.dao.RiderRepository;
import g5.app.model.Rider;

@Service
public class RiderService {
    

    @Autowired
    RiderRepository usuarioRepository;

    public void crearRider(Rider rider) {
        usuarioRepository.save(rider);

    }


    public void modificarRider(Rider rider) {
    }

   /*  public void modificarRider() {

    }

    public void consultarRider(){

    }
    public void borrarRider() {

    } */
}
