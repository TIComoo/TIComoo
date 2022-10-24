package g5.app;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    

    //CRUD Crear y Modificar. Testeado con TDD que Modificar funciona correctamente.
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    
    /* TODO Auto-generated constructor stub */
    /*
     * public void borrarUsuario() {
     * 
     * }
     * 
     * public void consultarUsuario() {
     * 
     * }
     */
}
