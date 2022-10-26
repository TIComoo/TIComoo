package g5.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g5.app.dao.RiderRepository;
import g5.app.exception.UsernameNotFound;
import g5.app.model.Rider;

@Service
public class RiderService {
	
	@Autowired
	private RiderRepository repository;

	public void guardarRider(Rider rdr) {
		repository.save(rdr);
	}

	public void borrarRider() {

	}

	public Rider buscarPorEmail(String email) throws UsernameNotFound {
		return repository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFound("El email del usuario no existe."));
	}

}
