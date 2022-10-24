package g5.app;



import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/crearUsuario", consumes = {"application/json"})
    public void crearUsuario(@RequestBody Usuario usuario) {
        
       /*  String email = jsonObject.getString("email");
        String nombre = jsonObject.getString("nombre");
        String apellido = jsonObject.getString("apellido");
        String nif = jsonObject.getString("nif");
        String direccion = jsonObject.getString("direccion");
        int telefono = jsonObject.getInt("telefono");
        String pwd = jsonObject.getString("pwd");
 */
        //Usuario usuario = new Usuario(email, nombre, apellido, nif, direccion, telefono, pwd);

        this.usuarioService.crearUsuario(usuario);
    }
    
}
