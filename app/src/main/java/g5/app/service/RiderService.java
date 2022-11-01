package g5.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g5.app.dao.RiderRepository;
import g5.app.exception.UsernameNotFound;
import g5.app.model.Rider;

@Service
public class RiderService {
	
	@Autowired
	private RiderRepository riderRepository;

	public void guardarRider(Rider rdr) {
		riderRepository.save(rdr);
	}

	public void borrarRiderPorEmail(String email) {
	    riderRepository.deleteById(email);
	}

	public Rider buscarPorEmail(String email) throws UsernameNotFound {
		return riderRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFound("El email del usuario no existe."));
	}

}
