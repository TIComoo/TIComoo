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
public class AppApplication /*implements CommandLineRunner*/ {




public class AppApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	
	

}
