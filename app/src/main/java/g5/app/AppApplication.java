package g5.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication

public class AppApplication {
	
	@Autowired
	private PlatoRepository platoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
}
