package g5.app;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;



@RestController
@RequestMapping("/restaurante")
public class RestauranteController {
    
    @Autowired
	private RestauranteService restauranteService;


	@PostMapping("/register")
	public void register(@RequestBody Map<String, Object> info) {
		try {
			JSONObject jso = new JSONObject(info);
				
			this.restauranteService.register(jso);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
		}
	}

 
	@PostMapping("/update")
	public void update(@RequestBody Map<String, Object> info) {
		try {
			JSONObject jso = new JSONObject(info);
			this.restauranteService.modify(jso);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
		}
	}

	@GetMapping("/list")
	public void list() {
		try {
			this.restauranteService.list();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
		}
	}
   

	@PostMapping("/delete")
	public void delete(@RequestBody Map<String, Object> info) {
		try {
			JSONObject jso = new JSONObject(info);
			this.restauranteService.delete(jso);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
		}
	}
    
}
