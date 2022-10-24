package g5.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import g5.app.dao.UsuarioRepository;
import g5.app.model.Usuario;

@SpringBootApplication
public class AppApplication /*implements CommandLineRunner*/ {

//	@Autowired
//	private UsuarioRepository userDao;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Usuario usr1 = new Usuario("gregorio.barchino@alu.uclm.es", "$2a$04$kXq/2TBthNw35MI3DThV3uVqgqLKfcJW3j18YDnhfdQ499gW7zmV6");
//		userDao.save(usr1);
//	}

}
