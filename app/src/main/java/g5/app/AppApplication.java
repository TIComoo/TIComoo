package g5.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import g5.app.dao.AdministradorRepository;
import g5.app.dao.RiderRepository;
import g5.app.dao.UsuarioRepository;
import g5.app.model.Administrador;
import g5.app.model.Rider;
import g5.app.model.Usuario;

@SpringBootApplication
public class AppApplication /*implements CommandLineRunner*/ {

//	@Autowired
//	private UsuarioRepository userDao;
//	
//	@Autowired
//	private AdministradorRepository admDao;
//	
//	@Autowired
//	private RiderRepository rdrDao;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Usuario usr1 = new Usuario("barchi2001@gmail.com", "$2a$04$kXq/2TBthNw35MI3DThV3uVqgqLKfcJW3j18YDnhfdQ499gW7zmV6");
//		userDao.save(usr1);
//		
//		Administrador adm1 = new Administrador("admin@admin.com", "$2a$04$kXq/2TBthNw35MI3DThV3uVqgqLKfcJW3j18YDnhfdQ499gW7zmV6");
//		admDao.save(adm1);
//		
//		Rider rdr1 = new Rider("rider@rider.com", "$2a$04$kXq/2TBthNw35MI3DThV3uVqgqLKfcJW3j18YDnhfdQ499gW7zmV6");
//		rdrDao.save(rdr1);
//	}

}
