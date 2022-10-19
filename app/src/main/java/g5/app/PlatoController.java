package g5.app;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.json.JSONObject;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("plato")
public class PlatoController {

    @Autowired
    PlatoService platoService=new PlatoService();
    
    @PostMapping("/insert")
	public void register(@RequestBody Map<String, Object> info) {
		try {
			JSONObject jso = new JSONObject(info);
			platoService.insertPlato(jso);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
		}
	}

    @PostMapping("/update")
	public void update(@RequestBody Map<String, Object> info) {
		try {
			JSONObject jso = new JSONObject(info);
			platoService.updatePlato(jso);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
		}
	}

    @PostMapping("/delete")
	public void delete(@RequestBody Map<String, Object> info) {
		try {
			JSONObject jso = new JSONObject(info);
            
			platoService.deletePlato(jso);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
		}
	}
}
