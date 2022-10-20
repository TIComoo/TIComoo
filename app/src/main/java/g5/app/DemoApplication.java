package g5.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
*/

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {



		
	}

	
		}
		
		//INSERTAR
		
		//Restaurante r1 = new Restaurante ("MargaritasyAmapolas","Domino's","12345abc","Calle la mata,9","123456789","Pizzerias","dominos@hotmail.com");
		//Restaurante r2 = new Restaurante ("PruebaDeRiesgo","Domino's","12345abc","Calle la mata,9","123456789","Pizzerias","dominos@hotmail.com");
		//restauranteRepository.save(r1);
		//restauranteRepository.save(r2);
		
		
		//ELIMINAR
		
		//restauranteRepository.deleteById("PruebaDeRiesgo");
		
		//CONSULTAR
		
		
		//	System.out.println(restauranteRepository.findById("MargaritasyAmapolas").toString());
		
		
	
//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//	}
//
