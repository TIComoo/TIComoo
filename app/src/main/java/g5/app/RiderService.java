package g5.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiderService {
    

    @Autowired
    RiderRepository usuarioRepository;

    public void crearRider(Rider rider) {
        usuarioRepository.save(rider);

    }

   /*  public void modificarRider() {

    }

    public void consultarRider(){

    }
    public void borrarRider() {

    } */
}
