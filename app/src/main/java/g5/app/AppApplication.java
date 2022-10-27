package g5.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import g5.app.dao.AdministradorRepository;
import g5.app.dao.ClienteRepository;
import g5.app.dao.RiderRepository;
import g5.app.dao.UsuarioRepository;
import g5.app.model.Administrador;
import g5.app.model.Cliente;
import g5.app.model.Rider;
import g5.app.model.Usuario;

@SpringBootApplication
public class AppApplication /* implements CommandLineRunner */ {

//	@Autowired
//	private UsuarioRepository userDao;
//
//	@Autowired
//	private AdministradorRepository admDao;
//
//	@Autowired
//	private RiderRepository rdrDao;
//
//	@Autowired
//	private ClienteRepository cliDao;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Usuario usr1 = new Usuario("barchi2001@gmail.com", "Gregorio", "Barchino",
//				"$2a$04$kXq/2TBthNw35MI3DThV3uVqgqLKfcJW3j18YDnhfdQ499gW7zmV6", "cliente");
//		userDao.save(usr1);
//
//		Cliente cli = new Cliente("barchi2001@gmail.com", "Gregorio", "Barchino",
//				"$2a$04$kXq/2TBthNw35MI3DThV3uVqgqLKfcJW3j18YDnhfdQ499gW7zmV6", "28364842L", "Calle Lucero, 39",
//				"645845665");
//		cliDao.save(cli);
//
//		Usuario usr2 = new Usuario("sergio@gmail.com", "Sergio", "Moraleda",
//				"$2a$04$kXq/2TBthNw35MI3DThV3uVqgqLKfcJW3j18YDnhfdQ499gW7zmV6", "administrador");
//		userDao.save(usr2);
//		
//		Administrador adm = new Administrador("sergio@gmail.com", "Sergio", "Moraleda",
//				"$2a$04$kXq/2TBthNw35MI3DThV3uVqgqLKfcJW3j18YDnhfdQ499gW7zmV6", "Torreón");
//		admDao.save(adm);
//
//		Usuario usr3 = new Usuario("nacho@gmail.com", "Ignacio", "Ramos",
//				"$2a$04$kXq/2TBthNw35MI3DThV3uVqgqLKfcJW3j18YDnhfdQ499gW7zmV6", "rider");
//		userDao.save(usr3);
//		
//		Rider rdr1 = new Rider("nacho@gmail.com", "Ignacio", "Ramos",
//				"$2a$04$kXq/2TBthNw35MI3DThV3uVqgqLKfcJW3j18YDnhfdQ499gW7zmV6", "70334987U", "Moto", "4269 LTE", "548655T5R5W5D");
//		rdrDao.save(rdr1);
//	}

}
