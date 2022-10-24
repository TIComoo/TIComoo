package g5.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g5.app.dao.RiderRepository;
import g5.app.model.Rider;

@Service
public class RiderService {
	
	@Autowired
	RiderRepository repository;

	public void guardarRider(Rider rdr) {
		repository.save(rdr);
	}

	public void consultarRider() {

	}

	public void borrarRider() {

	}

}
