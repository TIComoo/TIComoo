package g5.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g5.app.dao.RiderRepository;
import g5.app.model.Rider;

@Service
public class RiderService {

  @Autowired
  RiderRepository riderRepository;

  public void guardarRider(Rider rider) {
    riderRepository.save(rider);

  }

  public List<Rider> leerRiders() {
    List<Rider> administradores = riderRepository.findAll();

    return administradores;
  }

  public Rider leerRiderPorEmail(String email) {
    Optional<Rider> riderOptional = riderRepository.findById(email);

    Rider rider = riderOptional.get();

    return rider;

  }

}
